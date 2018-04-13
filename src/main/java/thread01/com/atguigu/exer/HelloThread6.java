package thread01.com.atguigu.exer;

import java.util.ArrayList;
import java.util.Iterator;

public class HelloThread6 extends Thread{
	
	boolean flag = false;
	
	public void run(){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 100; i++) {
			int millis = (int)(Math.random() * 200);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
			
			int num = (int)(Math.random() * 100);
			System.out.println(num);
			
			list.add(num);
		}
		
		//
		flag = true;
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
		}
		
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()){
			System.out.println("--" + it.next());
		}
		
	}

}
