package threadCore.t2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Demo4 implements Callable<Integer> {
	
	
	public static void main(String[] args) throws Exception {
		Demo4 d = new Demo4();
		
		FutureTask<Integer> task = new FutureTask<>(d);
		
		Thread t = new Thread(task);
		
		t.start();

		Thread.sleep(100);
		
		System.out.println("execute others ...");
		
		Integer result = task.get();
		System.out.println("thread execute result is:" + result);
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("start complicated calculation....");
		Thread.sleep(3000);
		return 1;
	}

}
