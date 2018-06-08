package threadCore.ta7;

public class Tmall {
	
	private int count;
	
	public final int MAX_COUNT = 10;
	
	public synchronized void push () {
		while(count >= MAX_COUNT) {
			try {
				System.out.println(Thread.currentThread().getName() + "count >= MAX_COUNT.. wait for consumer");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count ++;
		System.out.println(Thread.currentThread().getName() + " producer produce, current count is: " + count);
		notifyAll();
	}
	
	public synchronized void take () {
		while(count <= 0) {
			try {
				System.out.println(Thread.currentThread().getName() + " count is zero wait for producer to produce");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count --;
		System.out.println(Thread.currentThread().getName() + " consumer consume current count is: " + count);
		notifyAll();
	}

}
