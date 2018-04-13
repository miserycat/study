package thread01.com.atguigu.exer;

public class HelloThread extends Thread{

		public void run(){
			for (int i = 0; i < 100; i++) {

				int num = (int)(Math.random() * 101);

				System.out.println(Thread.currentThread().getName() + ":" + num);

			}
		}

}
