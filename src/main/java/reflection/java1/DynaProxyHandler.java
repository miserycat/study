package reflection.java1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 生成动态代理类（了解）：
 * 
 * 		需要实现 InvocationHandler 接口
 * 
 * 		public Object invoke(Object proxy, Method method, Object[] args)
 * 		proxy : 返回的那个代理类对象
 * 		method ： 需要指定方法的Method实例
 * 		args : 执行方法需要的参数
 * 
 */
public class DynaProxyHandler implements InvocationHandler{
	
	//目标对象
	Object target;
	
	//动态生成代理类对象
	public Object newProxyInstance(Object target){
		this.target = target;
		
		/*
		 * 第一个参数：需要使用哪个类加载器加载：通常目标对象的类加载器一致
		 * 第二个参数：该代理实现了哪些接口：通常与目标对象一致
		 * 第三个参数：需要一个实现了InvocationHandler接口的实例，目的用于执行实现InvocationHandler接口中的invoke() 方法
		 */
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.println("判断是否符合条件");
		
		Object obj = method.invoke(this.target, args);
		
		System.out.println("代理结束");
		
		return obj;
	}

}
