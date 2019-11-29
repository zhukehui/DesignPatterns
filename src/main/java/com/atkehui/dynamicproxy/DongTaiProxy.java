package com.atkehui.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理实现方式:
 * 	1,jdk面试接口:
 * 	2,cglib
 * @author Administrator
 *
 */
public class DongTaiProxy {

	public static void main(String[] args) {
		//被代理对象
		Person p = new JK(); //多态
		/**
		 * 参数:
		 * 	第一个参数:被代理对象的类加载器
		 * 	第二个参数:被代理对象实现的所有接口们
		 * 	第三个参数:用来对被代理对象进行增强的核心接口
		 */
		Person personProxy = (Person) Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), new InvocationHandler() {
			
			/**
			 * invoke: 增强方法的核心方法
			 * 	1,proxy 代理对象
			 *  2,method:通过反射生成的代理对象的方法
			 *  3,args:被增强方法的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				Object invoke = null;
				String name = method.getName();
				if(name.equals("eat")) {
					System.out.println("你吃什么呢");
					invoke = method.invoke(p, args);
					System.out.println("我帮你搞定了");
				}else {
					System.out.println("欢迎你jk,我会帮你物色好的战队");
					invoke = method.invoke(p, args);
					System.out.println("我会帮你搞定");
				}
				
				return invoke;
			}
		});
		personProxy.play();
		//personProxy.eat("香蕉");

		
	}
}
