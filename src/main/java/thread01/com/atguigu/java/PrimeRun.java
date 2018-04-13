package thread01.com.atguigu.java;

public class PrimeRun implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName() + ":" + i);
			} 
		}
	}

}
