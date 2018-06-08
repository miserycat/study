package reflection.java;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	
	//获取运行时类的属性
	@Test
	public void test1(){
		Class clazz = Person.class;
		
		//getFields() : 可以获取所有public修饰的属性，包括父类的
		Field[] fileds = clazz.getFields();
		
		for (int i = 0; i < fileds.length; i++) {
			System.out.println(fileds[i].getName());
		}
		
		System.out.println("----------------------------------");
		
		//getDeclaredFields() : 获取本类中所有的属性，包括私有的，但是没有父类的
		Field[] fileds1 = clazz.getDeclaredFields();
		for (int i = 0; i < fileds1.length; i++) {
			System.out.println(fileds1[i].getName());
		}
	}
	
	//获取运行时类属性的完整结构：    访问控制修饰符    数据类型    属性名;
	@Test
	public void test2() throws ClassNotFoundException{
		Class clazz = Class.forName("com.atguigu.java.Person");
		
		Field[] field = clazz.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			//1. 访问控制修饰符
			int mod = field[i].getModifiers();
			String strMod = Modifier.toString(mod);
			System.out.print(strMod + "\t");
			
			//2. 数据类型
			Class type = field[i].getType();
			System.out.print(type.getName() + "\t");
			
			//3. 属性名
			System.out.println(field[i].getName());
		}
	}
	
	//获取并调用运行时类对象的指定属性
	@Test
	public void test3() throws Exception{
		Class clazz = Class.forName("com.atguigu.java.Person");
		
		Person p = (Person) clazz.newInstance();
		
		//getField(String name) : 获取所有public修饰的属性
//		Field name = clazz.getField("name");
		Field name = clazz.getDeclaredField("name");
		name.setAccessible(true); //设置该属性的访问权限
		name.set(p, "张三");
		
		Object obj = name.get(p);
		System.out.println(obj);
		
		System.out.println("-----------------------");
		
		Field nation = clazz.getField("nation");
		nation.set(p, "中国");
		
		Object obj2 = nation.get(p);
		System.out.println(obj2);
	}

}
