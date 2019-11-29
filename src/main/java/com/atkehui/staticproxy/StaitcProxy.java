package com.atkehui.staticproxy;
/**
 * 代理:做功能增强
 * 静态代理
 * @author Administrator
 * 中介公司
 */
public class StaitcProxy implements Person {
	
	private Zhangsan zs;
	

	public StaitcProxy(Zhangsan zs) {
		super();
		this.zs = zs;
	}
	@Override
	public void House() {
		
		System.out.println("你好,欢迎光临...");
		zs.House();
		System.out.println("走 我们去带你看房子...");
		
	}
	
	
	public static void main(String[] args) {
		
		Zhangsan zs = new Zhangsan();
		StaitcProxy proxy = new StaitcProxy(zs);
		proxy.House();
	}

}
