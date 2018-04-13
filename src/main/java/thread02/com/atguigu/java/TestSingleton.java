package thread02.com.atguigu.java;

/*
 * 懒汉式
 */
public class TestSingleton {

}

class Singleton{

	//2.
	private static Singleton instance = null;
	
	//1.
	private Singleton(){}
	
	public static Singleton getInstance(){
		
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		
		return instance;
	}
	
	
}