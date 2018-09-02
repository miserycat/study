package multiThreading.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {
  public static void main(String[] args) {
    LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(5);
    linkedBlockingQueue.offer("a");
    linkedBlockingQueue.offer("b");
    linkedBlockingQueue.offer("c");
    linkedBlockingQueue.offer("d");
    linkedBlockingQueue.offer("e");
    linkedBlockingQueue.add("f");

    System.out.println(linkedBlockingQueue);
  }

}
