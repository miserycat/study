package thread02.com.atguigu.java2;

import org.junit.Test;

/*
 * Java程序的运行分为两种状态：
 * 编译时：通过javac命名，生成一个或多个的.class字节码文件（每个.class字节码文件对应着一个类）
 * 运行时：通过java命令，将一个或多个.class字节码文件加载到内存中。（由JVM的类加载器完成）
 * 
 * 类是用于描述现实生活中一类事物，若需要具体到某一个事物，需要通过 new 关键字创建对象
 * 就可以调用其属性和方法。 (以上过程在编译时我们就可以确定创建什么类的对象，调用什么对象的属性和方法)
 * 
 * 某种情况下，我们需要得知并使用一个在编译期间完全未知的类，创建其对象，调用其属性和方法。
 * 
 * 反射机制：被视为动态语言的关键，可以在运行时创建一个类的对象，在运行时调用其属性和方法
 * 
 * Class 是开启反射的源头！
 * 
 * 1. 如何获取Class实例
 * 
 * 		//1. 使用运行时类的 class 属性
		
		//2. 通过运行时类对象的 getClass() 方法
		
		//3. 通过 Class 类中 静态方法 forName(String className)
		
		//4. 通过运行时类的加载器(了解)
 * 
 */
public class TestReflection {
	
	@Test
	public void test2() throws ClassNotFoundException{
		//1. 使用运行时类的 class 属性
		Class clazz1 = Person.class;
		System.out.println(clazz1);
		
		//2. 通过运行时类对象的 getClass() 方法
		Person p = new Person();
		Class clazz2 = p.getClass();
		System.out.println(clazz2);
		
		//3. 通过 Class 类中 静态方法 forName(String className)
		String className = "com.atguigu.java2.Person";
		Class clazz3 = Class.forName(className);
		System.out.println(clazz3);
		
		//4. 通过运行时类的加载器(了解)
		ClassLoader cl = this.getClass().getClassLoader();
		Class clazz4 = cl.loadClass(className);
		System.out.println(clazz4);
	}

	
	//反射之前
	@Test
	public void test1(){
		Person p = new Person();
		System.out.println(p.getName());
	}

}
