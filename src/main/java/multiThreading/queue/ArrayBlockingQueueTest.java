package multiThreading.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest {

  public static void main(String[] args) throws Exception{
    ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
    arrayBlockingQueue.add("a");
    arrayBlockingQueue.add("b");
    arrayBlockingQueue.add("c");
    arrayBlockingQueue.add("d");
    arrayBlockingQueue.add("e");

    System.out.println(arrayBlockingQueue.offer("a", 1, TimeUnit.SECONDS));

  }

}
