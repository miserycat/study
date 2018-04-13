package thread02.com.atguigu.java;

/*
 * 死锁：
 */
public class DeadLock implements Runnable{
	
	static Object obj1 = new Object(); //共享资源1
	static Object obj2 = new Object(); //共享资源2
	

	boolean flag = true;
	
	@Override
	public void run() {
		
		if(flag){
			
			synchronized (obj1) {
				System.out.println("获取共享资源1，等待共享资源2……");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj2) {
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				}
			}
			
		}else{
			
			synchronized (obj2) {
				System.out.println("获取共享资源2，等待共享资源1……");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj1) {
					System.out.println("###################################");
				}
			}
			
		}
		
	}
	
	

}
