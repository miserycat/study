package thread01.com.atguigu.exer;

public class HelloThread4 implements Runnable{

	static boolean flag = true;
	
	@Override
	public void run() {
		
		while(flag){
			int num = (int)(Math.random() * 101);
			System.out.println(num);
		}
		
	}
	
	public static void setFlag(){
		
		flag = false;
	}

}
