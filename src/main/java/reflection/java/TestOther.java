package reflection.java;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestOther {
	
	//获取运行时类的内部类
	@Test
	public void test6(){
		
		Class clazz = Person.class;
		
		Class[] clazzes = clazz.getClasses();
		
		for (int i = 0; i < clazzes.length; i++) {
			System.out.println(clazzes[i]);
		}
		
		System.out.println("---------------------------");
		
		Class[] clazzes1 = clazz.getDeclaredClasses();
		for (int i = 0; i < clazzes1.length; i++) {
			System.out.println(clazzes1[i]);
		}
		
	}
	
	//获取运行时类的注解
	@Test
	public void test5(){
		Class clazz = Person.class;
		
		Annotation[] annos = clazz.getAnnotations();
		for (int i = 0; i < annos.length; i++) {
			System.out.println(annos[i]);
		}
	}
	
	//获取运行时类的接口
	@Test
	public void test4(){
		Class clazz = Person.class;
		
		Class[] interfaces = clazz.getInterfaces();
		
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println(interfaces[i].getName());
		}
	}
	
	//获取运行时类带泛型的父类的泛型类型(重要)
	@Test
	public void test3(){
		Class clazz = Person.class;
		
		//1. 获取带泛型的父类
		Type type = clazz.getGenericSuperclass();
		
		//2. 获取参数化类型
		ParameterizedType pt = (ParameterizedType) type;
		
		Type[] types = pt.getActualTypeArguments();
		
		System.out.println(((Class)types[0]).getName());
	}
	
	//获取运行时类带泛型的父类
	@Test
	public void test2(){
		Class clazz = Person.class;
		
		Type type = clazz.getGenericSuperclass();
		System.out.println(type);
	}
	
	//获取运行时类的父类
	@Test
	public void test1(){
		Class clazz = Person.class;
		Class superClass = clazz.getSuperclass();
		System.out.println(superClass);
	}

}
