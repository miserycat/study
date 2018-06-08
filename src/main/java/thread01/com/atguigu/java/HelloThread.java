package thread01.com.atguigu.java;

/*
 * 结束线程：通常在线程执行体中写一些循环语句，因此控制住了循环就相当于控制住了线程
 */
public class HelloThread extends Thread{
	
	int i = 0;
	
	boolean flag = true;
	
	public void run(){
		while(!isInterrupted()){
			System.out.println(i++);
		}
	}

	public void setFlag(){
		flag = false;
	}
}
