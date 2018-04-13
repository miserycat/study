package thread01.com.atguigu.java;

public class PrimeThread extends Thread{
	
	//线程执行体
	public void run(){
		
		for (int i = 0; i < 100; i++) {
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
		
	}

}
