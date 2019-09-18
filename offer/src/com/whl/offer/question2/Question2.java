package com.whl.offer.question2;

public class Question2 {
    public static void main(String[] args) {
        Singleton6.INSTANCE.whatEverMethod();
        Singleton6.INSTANCE2.whatEverMethod();
    }
}


/**
 * 懒汉式
 */
class Singleton1 {
    private static Singleton1 singleton1;

    public synchronized static Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }

        return singleton1;
    }

    private Singleton1() {
    }
}

/**
 * 饿汉式
 */
class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2();

    public static Singleton2 getInstance() {
        return singleton2;
    }

    private Singleton2() {
    }
}

/**
 * 饿汉式
 */
class Singleton3 {
    private static Singleton3 singleton3;

    static {
        singleton3 = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return singleton3;
    }

    private Singleton3() {
    }
}

/**
 * 静态内部类
 */
class Singleton4 {
    private static class SingletonHolder {
        private static Singleton4 singleton4 = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.singleton4;
    }

    private Singleton4() {
    }
}


/**
 * 双重检查锁定
 * <p>
 * 枚举
 */
class Singleton5 {
    private static volatile Singleton5 singleton5;

    public static Singleton5 getInstance() {
        if (singleton5 == null) {
            synchronized (Singleton5.class) {
                if (singleton5 == null) {
                    singleton5 = new Singleton5();
                }
            }
        }

        return singleton5;
    }
}


/**
 * 枚举
 */
enum Singleton6{
    INSTANCE,INSTANCE2;
    public void whatEverMethod(){
        System.out.println("Singleton6....");
    }
}