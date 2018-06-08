package threadCore.tc4;

/**
 * 程序次序规则 
 * 监视器规则
 * 传递性
 * @author worker
 *
 */
public class Demo {
	
	private int value;
	
	public synchronized void a() { // 1  获取锁
		value ++; // 2
	} // 3 释放锁
	
	public synchronized void b() { // 4 获取锁
		int a = value; // 5
		// 处理其他的操作 
	} // 6 释放锁
	

}
