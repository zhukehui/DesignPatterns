package com.atkehui.singleton;

/**
 * @author eternity
 * @create 2019-11-29 22:23
 *
 * 懒汉式：
 *  1、构造方法私有化
 *  2、提供方法
 *
 *  优点：内存中如果不使用该对象就不会去创建  简单
 *  缺点：线程不安全
 *    为什么？操作共享资源的代码有多余
 */
public class SingletonTwo {

    private SingletonTwo(){};

    private static SingletonTwo s = null;

    public synchronized static SingletonTwo getInstance(){
        if (s == null){
            s = new SingletonTwo();
        }
        return s;
    }

}
