package multiThreading.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

  public static void main(String[] args) {
    Callable<Integer> callable = () -> {
      System.out.println("start to calculate...");
      Thread.sleep(4000);
      return 1;
    };

    FutureTask<Integer> futureTask = new FutureTask(callable);

    new Thread(futureTask).start();

    System.out.println("do something else...");

    try {
      Integer result = futureTask.get();
      System.out.println(result);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }

}
