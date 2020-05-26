package wenjun.concurrent.chapter31;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CountDownLatchTest3 {
    public static void main(String[] args) {
        List<Event> events = Lists.newArrayList(new Event(1), new Event(2));
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        events.forEach(event -> {
            List<Table> tables = captor(event);
            TaskGroup taskGroup = new TaskGroup(tables.size(), event);
            tables.forEach(table -> {
                TaskBatch taskBatch = new TaskBatch(2, taskGroup);
                TrustSourceColumns columnsRunnable = new TrustSourceColumns(table, taskBatch);
                TrustSourceRecordCount recordCountRunnable = new TrustSourceRecordCount(table, taskBatch);
                executorService.submit(columnsRunnable);
                executorService.submit(recordCountRunnable);
            });
        });

        executorService.shutdown();
    }

    private static List<Table> captor(Event event) {
        List<Table> tables = new ArrayList<>();
        IntStream.rangeClosed(1, 10)
                .forEach(index -> tables.add(new Table("table-" + event.getId() + "-" + index , index * 1000)));
        return tables;
    }


    static interface Watcher {
        void done(Table table);
    }

    static class TaskGroup implements Watcher {
        private CountDownLatch latch;
        private Event event;

        public TaskGroup(int size, Event event) {
            latch = new CountDownLatch(size);
            this.event = event;
        }

        @Override
        public void done(Table table) {
            latch.countDown();
            if (latch.getCount() == 0) {
                System.out.println("All of table done in event: " + event.getId());
            }
        }
    }

    static class TaskBatch implements Watcher {
        private CountDownLatch latch;
        private TaskGroup taskGroup;

        public TaskBatch(int size, TaskGroup taskGroup) {
            latch = new CountDownLatch(size);
            this.taskGroup = taskGroup;
        }

        @Override
        public void done(Table table) {
            latch.countDown();
            if (latch.getCount() == 0) {
                System.out.println("The table  " + table.getTableName() + " finished work,  target count:" + table.getTargetCount() + " target schema:" + table.getTargetColumnSchema() );
                taskGroup.done(table);
            }
        }
    }

    static class Table {
        String tableName;
        long sourceRecordsCount;
        long targetCount;
        String sourceColumnSchema = "<table name='xxx'><column name='cxxx'></column></table>";
        String targetColumnSchema = "";

        public Table(String tableName, long sourceRecordsCount) {
            this.tableName = tableName;
            this.sourceRecordsCount = sourceRecordsCount;
        }

        public String getTableName() {
            return tableName;
        }

        public long getSourceRecordsCount() {
            return sourceRecordsCount;
        }

        public long getTargetCount() {
            return targetCount;
        }

        public String getSourceColumnSchema() {
            return sourceColumnSchema;
        }

        public String getTargetColumnSchema() {
            return targetColumnSchema;
        }

        @Override
        public String toString() {
            return "Table{" +
                    "tableName='" + tableName + '\'' +
                    ", sourceRecordsCount=" + sourceRecordsCount +
                    ", targetCount=" + targetCount +
                    ", sourceColumnSchema='" + sourceColumnSchema + '\'' +
                    ", targetColumnSchema='" + targetColumnSchema + '\'' +
                    '}';
        }
    }

    static class Event {
        private int id;

        public Event(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    static class TrustSourceColumns implements Runnable {
        private final  Table table;
        private final TaskBatch taskBatch;

        TrustSourceColumns(Table table, TaskBatch taskBatch) {
            this.table = table;
            this.taskBatch = taskBatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.targetColumnSchema = table.sourceColumnSchema;
            System.out.println("finish source column schema job " + table.getTableName());
            taskBatch.done(table);
        }
    }

    static class TrustSourceRecordCount implements Runnable {
        private final  Table table;
        private final TaskBatch taskBatch;

        TrustSourceRecordCount(Table table, TaskBatch taskBatch) {
            this.table = table;
            this.taskBatch = taskBatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            table.targetCount = table.sourceRecordsCount;
            System.out.println("finish source record count job " + table.getTableName());
            taskBatch.done(table);
        }
    }

}
