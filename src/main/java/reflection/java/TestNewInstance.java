package reflection.java;

import org.junit.Test;

/*
 * 反射的功能：
 * ①在运行时获取一个对象所属的类
 * ②在运行时创建一个类的对象
 * ③在运行时判断一个对象的属性和方法
 * ④在运行时调用一个对象的属性和方法
 * ⑤生成动态代理
 * 
 * 1. 在运行时创建一个类的对象
 * 		通过 Class 类的 newInstance() :默认调用运行时类的无参构造器创建对象
 */
public class TestNewInstance {
	
	@Test
	public void test1() throws Exception{
//		Class<Person> clazz = Person.class;
//		Person p = clazz.newInstance();
//		System.out.println(p);
		
		Class clazz = Person.class;
		Object obj = clazz.newInstance();
		Person p = (Person) obj;
		System.out.println(p);
	}

}
