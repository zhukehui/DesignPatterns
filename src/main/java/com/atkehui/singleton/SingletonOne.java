package com.atkehui.singleton;

/**
 * @author eternity
 * @create 2019-11-29 22:19
 *
 * 恶汉式
 *  1、构造私有化
 *  2、提供方法
 *
 *  优点：简单、线程安全
 *  缺点：private static final Singleton s = new Singleton(); 长期存在于内存中
 *
 */
public class SingletonOne {

    //构造方法私有化
    private SingletonOne(){};

    private static final SingletonOne s = new SingletonOne();

    public static SingletonOne getSingleton(){
        return s ;
    }
}
