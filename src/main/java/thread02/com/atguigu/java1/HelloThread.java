package thread02.com.atguigu.java1;

public class HelloThread implements Runnable{
	
	int num = 0;

	@Override
	public void run() {
		
		while(true){
			
			synchronized (this) {
				
				notify();
				
				if(num < 100){
					System.out.println(Thread.currentThread().getName() + ":" + num++);
				}
				
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
		}
		
	}

}
