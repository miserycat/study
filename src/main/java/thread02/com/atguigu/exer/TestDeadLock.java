package thread02.com.atguigu.exer;

public class TestDeadLock {
	public static void main(String[] args) {
		final StringBuffer s1 = new StringBuffer();
		final StringBuffer s2 = new StringBuffer();
		
		
		new Thread() {
			public void run() {
				
				synchronized (s1) {
					
					s2.append("A");
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
					
					synchronized (s2) {
						s2.append("B");
						
						System.out.print(s1);
						System.out.print(s2);
					}
				}
			}
		}.start();
		
		
		new Thread() {
			public void run() {
				
				synchronized (s2) {
					
					s2.append("C");
					
					synchronized (s1) {
						s1.append("D");
						
						System.out.print(s2);
						System.out.print(s1);
					}
				}
			}
		}.start();
	}
}
