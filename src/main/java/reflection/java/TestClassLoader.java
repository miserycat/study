package reflection.java;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class TestClassLoader {
	
	/*
	 * 必须掌握
	 */
	@Test
	public void test2() throws IOException{
		//1. 创建 Properties 对象
		Properties props = new Properties();
		
		//2. 通过 load() 方法加载属性文件
//		props.load(new FileInputStream("hello.properties"));
		
//		ClassLoader cl = this.getClass().getClassLoader();
//		InputStream in = cl.getResourceAsStream("com\\atguigu\\java\\hello.properties");
//		
//		props.load(in);
		
		props.load(this.getClass().getClassLoader().getResourceAsStream("com\\atguigu\\java\\hello.properties"));
		
		//3. 通过 getProperty() 方法读取属性文件的内容
		String userName = props.getProperty("username");
		String password = props.getProperty("password");
		
		System.out.println(userName);
		System.out.println(password);
	}
	
	/*
	 * 了解
	 */
	@Test
	public void test1() throws ClassNotFoundException{
		ClassLoader cl1 = this.getClass().getClassLoader();
		System.out.println(cl1);
		
		ClassLoader cl2 = cl1.getParent();
		System.out.println(cl2);
		
		ClassLoader cl3 = cl2.getParent();
		System.out.println(cl3);
		
//		String className = "com.atguigu.java.Person";
		String className = "java.lang.String";
		ClassLoader cl4 = Class.forName(className).getClassLoader();
		System.out.println(cl4);
	}

}
