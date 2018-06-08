package threadCore.tb7;

import java.util.concurrent.Exchanger;

public class Demo {
	
	public void a (Exchanger<String> exch) {
		
		System.out.println("method a execute ...");
		
		try {
			System.out.println("method a is retrieving data...");
			Thread.sleep(2000);
			System.out.println("method a fetch data finish...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String res = "23458";
		
		try {
			System.out.println("thread a wait for compare result");
			String value = exch.exchange(res);
			System.out.println(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void b (Exchanger<String> exch) {
		System.out.println("method b start to execute...");
		try {
			System.out.println("method b is retrieving data...");
			Thread.sleep(4000);
			System.out.println("method b fetch data finish...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String res = "12345";
		
		try {
			String value = exch.exchange(res);
			System.out.println("start to compare...");
			System.out.println("compare result is: " + value.equals(res));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Demo d = new Demo();
		Exchanger<String> exch = new Exchanger<>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				d.a(exch);
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				d.b(exch);
			}
		}).start();


	}

}
