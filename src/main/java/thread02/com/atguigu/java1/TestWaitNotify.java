package thread02.com.atguigu.java1;

/*
 * 线程通信（线程交互）： 当多个线程共同完成任务时，线程之间有时也需要一定的通信，即线程通信
 * 
 * 	如：有一个银行账户，用户A往该银行账户中存钱，最多存储10000元。
 * 	    用户B从该银行账户中取钱，当余额不足时，需要通知用户A开始存钱
 * 
 * 
 * 使用两个线程打印 1-100. 线程1, 线程2 交替打印
 * 
 * wait() : 使当前线程处于等待状态,同时释放“锁”
 * notify() / notifyAll() : 唤醒等待状态的单个（所有）线程
 * 
 *  wait() 和 notify() / notifyAll() 必须使用在同步中
 * 
 */
public class TestWaitNotify {
	
	public static void main(String[] args) {
		HelloThread ht = new HelloThread();
		
		new Thread(ht).start();
		new Thread(ht).start();
	}

}
