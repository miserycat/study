package multiThreading.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {

  public static void main(String[] args) {
    ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    concurrentLinkedQueue.add("a");
    concurrentLinkedQueue.add("b");
    concurrentLinkedQueue.add("c");
    concurrentLinkedQueue.add("d");
    concurrentLinkedQueue.add("e");

    String v1 = concurrentLinkedQueue.poll();
    System.out.println(v1);
    System.out.println(concurrentLinkedQueue.size());
    String v2 = concurrentLinkedQueue.peek();
    System.out.println(v2);
    System.out.println(concurrentLinkedQueue.size());
  }





}
