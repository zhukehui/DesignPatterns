package com.atkehui.dynamicproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib的方式
 * @author Administrator
 *
 */
public class CglibProxy {
	
	public static Object getProxyByCglib(Object target) {
		//该类是实现增强的核心类
		Enhancer enhancer = new Enhancer();
		//设置被代理对象
		enhancer.setSuperclass(target.getClass());
		
		//设置增强
		enhancer.setCallback(new MethodInterceptor() {
			
			/**
			 * 参数:
			 * 	第一个:代理对象
			 * 	第二个:被代理对象方法
			 *  第三个:被代理对象方法参数
			 *  第四个:通过反射的方式生成的代理方法的代理对象
			 */
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				
				System.out.println("增强前.....cglib");
				Object invokeSuper = methodProxy.invokeSuper(proxy, args);
				System.out.println("增强后.....cglib");
				return invokeSuper;
			}
		});
		
		return enhancer.create();
		
	}

	public static void main(String[] args) {
		JK jk = new JK();
		JK proxyByCglib = (JK)CglibProxy.getProxyByCglib(jk);
		proxyByCglib.play();
		
	}

}
