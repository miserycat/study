package threadCore.tb4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by shengchao wu on 5/30/2018.
 */
public class LockDownLatchTest {

    private static int nums[];

    public LockDownLatchTest(int nums) {
        this.nums = new int[nums];
    }

    public static void main(String[] args) {
        List<String> contents = readFile("C:\\study\\src\\main\\java\\threadCore\\tb4\\nums.txt");
        CountDownLatch countDownLatch = new CountDownLatch(contents.size());
        LockDownLatchTest l = new LockDownLatchTest(contents.size());

        for (int i = 0; i < contents.size(); i++) {
            final int index = i;
            new Thread(() -> {
                l.calc(index, contents.get(index), countDownLatch);
            }).start();
        }

//        while (Thread.activeCount() > 1) {
//
//        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getCollectAllTasksResult(nums));

    }

    public void calc(int index, String lineNum, CountDownLatch latch) {
        int total = 0;
        for (String s : lineNum.split(",")) {
            total = total + Integer.parseInt(s);
        }
        System.out.println(Thread.currentThread().getName() + "calc result is : " + total);
        nums[index] = total;
        latch.countDown();
    }

    public static int getCollectAllTasksResult(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        return total;
    }


    public static List<String> readFile(String path) {
        List<String> result = new ArrayList<>();
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(path));
            while( (line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
