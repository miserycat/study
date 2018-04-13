package thread01.com.atguigu.exer;


import java.io.File;

public class HelloThread2 extends Thread{
	
	File file = new File("e:\\");
	
	public void run(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String[] strs = file.list();
		System.out.println("文件个数为：" + strs.length + " 所占总空间数：" + (file.getTotalSpace() - file.getFreeSpace()));
	}

	public File getFile() {
		return file;
	}
}
