package threadCore.tb2;

public class Demo {

	public void a(Thread joinThread) {

		System.out.println("method a start...");
		joinThread.start();
		try {
			joinThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("method a end...");

	}

	public void b() {
		System.out.println("join thread start...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("join thread end...");
	}

	public static void main(String[] args) {
		Demo demo = new Demo();
		Thread joinThread = new Thread(new Runnable() {

			@Override
			public void run() {
				demo.b();
			}
		});

		new Thread(new Runnable() {

			@Override
			public void run() {
				demo.a(joinThread);
			}
		}).start();
	}

}
