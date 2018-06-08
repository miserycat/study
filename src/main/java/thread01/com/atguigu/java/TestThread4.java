package thread01.com.atguigu.java;


public class TestThread4 {
	
	public static void main(String[] args) {
		HelloThread ht = new HelloThread();
		ht.start();
		
		for (int i = 0; i < 1000000; i++) {
			if(i == 120000){
				ht.interrupt();
				System.out.println("----------------------------------------");
			}
		}
	}

}
