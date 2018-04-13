package thread01.com.atguigu.java;

public class Window extends Thread{
	
	static int tick = 100; //
	
	public void run(){
		while(tick > 0){
			System.out.println(Thread.currentThread().getName() + "完成售票，余票：" + --tick);
		}
	}

}
