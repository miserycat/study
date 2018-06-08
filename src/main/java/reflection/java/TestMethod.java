package reflection.java;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {
	
	//获取运行时类的方法
	@Test
	public void test1(){
		Class clazz = Person.class;
		
		//getMethods() : 获取所有public修饰的方法，包括父类的
		Method[] methods = clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
		}
		
		System.out.println("----------------------");
		
		//getDeclaredMethods() : 获取本类中所有的方法，包括私有的，但是不包括父类的
		Method[] methods1 = clazz.getDeclaredMethods();
		for (int i = 0; i < methods1.length; i++) {
			System.out.println(methods1[i].getName());
		}
	}
	
	//获取运行时类方法的完成结构：   注解   访问控制修饰符  返回值类型   方法名(参数类型1 参数名1, 参数类型2 参数名2 ……) 异常
	@Test
	public void test2() throws ClassNotFoundException{
		Class clazz = Class.forName("com.atguigu.java.Person");
		
		Method[] methods = clazz.getDeclaredMethods();
		
		for (int i = 0; i < methods.length; i++) {
			//0. 注解
			Annotation[] annos = methods[i].getAnnotations();
			for (int j = 0; j < annos.length; j++) {
				System.out.println(annos[j]);
			}
			
			//1. 访问控制修饰符
			int mod = methods[i].getModifiers();
			String strMod = Modifier.toString(mod);
			System.out.print(strMod + "\t");
			
			//2. 返回值类型
			Class returnType = methods[i].getReturnType();
			System.out.print(returnType.getName() + "\t");
			
			//3. 方法名
			System.out.print(methods[i].getName() + "(");
			
			//4. 参数列表
			Class[] paramTypes = methods[i].getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				System.out.print(paramTypes[j].getName() + ",");
			}
			System.out.print(")");
			
			//5. 异常
			Class[] exceTypes = methods[i].getExceptionTypes();
			for (int j = 0; j < exceTypes.length; j++) {
				System.out.print(exceTypes[j].getName() + "\t");
			}
			
			System.out.println();
		}
	}
	
	//获取并调用运行时类对象的指定方法
	@Test
	public void test3() throws Exception{
		Class clazz = Class.forName("com.atguigu.java.Person");
		
		Person p = (Person) clazz.newInstance();
		
		Method method = clazz.getMethod("setName", String.class);
		
		Object obj1 = method.invoke(p, "张三");
		System.out.println(obj1);
		
		System.out.println("----------------------------");
		
		Method setAge = clazz.getMethod("setAge", int.class, String.class, double.class);
		Object obj = setAge.invoke(p, 123, "abc", 15.6);
		System.out.println(obj);
		
		System.out.println("--------------------------------");
		Method sleep = clazz.getDeclaredMethod("sleep");
		sleep.setAccessible(true); // 设置访问权限为true
		Object obj2 = sleep.invoke(p);
		System.out.println(obj2);
	}

}
