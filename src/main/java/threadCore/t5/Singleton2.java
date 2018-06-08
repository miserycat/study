package threadCore.t5;

public class Singleton2 {
	
	private Singleton2() {}
	
	private static volatile Singleton2 instance;
	
	/**
	 * 双重检查加锁
	 * 
	 * @return
	 */
	public static Singleton2 getInstance () {
		// 自旋   while(true)
		if(instance == null) {
			synchronized (Singleton2.class) {
				if(instance == null) {
					instance = new Singleton2();  // 指令重排序
					
					// 申请一块内存空间   // 1
					// 在这块空间里实例化对象  // 2
					// instance的引用指向这块空间地址   // 3
				}
			}
		}
		return instance;
	}
	
	// 多线程的环境下
	// 必须有共享资源
	// 对资源进行非原子性操作

}
