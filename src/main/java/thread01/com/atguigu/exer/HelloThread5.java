package thread01.com.atguigu.exer;


import java.util.Scanner;

public class HelloThread5 implements Runnable{

	@Override
	public void run() {
		
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()){
			String str = scan.next();
			if(str.equalsIgnoreCase("q")){
				HelloThread4.setFlag();
				System.out.println("--------------------------");
			}
		}
	}

	
	
}
