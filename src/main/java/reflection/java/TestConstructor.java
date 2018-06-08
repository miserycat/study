package reflection.java;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestConstructor {
	
	//获取运行时类的构造器
	@Test
	public void test1(){
		Class clazz = Person.class;
		
		//getConstructors() : 获取本类public修饰的构造器
		Constructor[] cons = clazz.getConstructors();
		
		for (int i = 0; i < cons.length; i++) {
			System.out.println(cons[i]);
		}
		
		System.out.println("---------------------------------");
		//
		Constructor[] cons1 = clazz.getDeclaredConstructors();
		for (int i = 0; i < cons1.length; i++) {
			System.out.println(cons1[i]);
		}
	}

	//获取并调用运行时类的构造器
	@Test
	public void test2() throws Exception{
		Class clazz = Person.class;
		
		Constructor con = clazz.getConstructor();
		Person p = (Person) con.newInstance();
		System.out.println(p);
		
		System.out.println("--------------------------------------------");
		Constructor con2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
		con2.setAccessible(true);
		Person p2 = (Person) con2.newInstance("张三", 18, "中国");
		System.out.println(p2);
	}
}
