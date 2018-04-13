package thread01.com.atguigu.exer;

/*
编写程序，在main方法中创建一个线程。线程每隔一定时间（200ms以内的随机时间）产生一个0-100之间的随机整数，打印后将该整数放到集合中；
共产生100个整数，全部产生后，睡眠30秒，然后将集合内容打印输出；
在main线程中，唤醒上述睡眠的线程，使其尽快打印集合内容。
 */
public class TestThread3 {
	
	public static void main(String[] args) {
		
		HelloThread6 ht6 = new HelloThread6();
		ht6.start();
		
		while(ht6.isAlive()){
			if(ht6.flag){
				ht6.interrupt();
			}
		}
	}

}
