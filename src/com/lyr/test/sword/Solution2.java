package com.lyr.test.sword;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author lyr
 * @Date 3/18/21 8:45 PM
 * @Version 1.0
 * @Description 2. 实现Singleton
 */
public class Solution2 {

}

/**
 * 懒汉式
 */
class Singleton1 {
    private static Singleton1 instance = null;

    private Singleton1() {}

    /**
     * 1、适用于单线程环境（不推荐）
     * @return
     */
    public static Singleton1 getInstanceA() {
        if (null == instance) {
            instance = new Singleton1();
        }
        return instance;
    }

    /**
     * 2、适用于多线程环境，但效率不高（不推荐）
     * @return
     */
    public static synchronized Singleton1 getInstanceB() {
        if (null == instance) {
            instance = new Singleton1();
        }
        return instance;
    }

    /**
     * 3、双重检查加锁，JVM本质重排序的原因，可能会初始化多次，不推荐使用
     * @return
     */
    public static Singleton1 getInstanceC() {
        if (null == instance) {
            synchronized (Singleton1.class) {
                if (null == instance) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类
 * 加载一个类时，其内部类不会同时被加载。一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。
 * 由于在调用 StaticSingleton.getInstance() 的时候，才会对单例进行初始化，而且通过反射，
 * 是不能从外部类获取内部类的属性的；由于静态内部类的特性，只有在其被第一次引用的时候才会被加载，所以可以保证其线程安全性。
 *
 * 优势：兼顾了懒汉模式的内存优化（使用时才初始化）以及饿汉模式的安全性（不会被反射入侵）。
 * 劣势：需要两个类去做到这一点，虽然不会创建静态内部类的对象，但是其 Class 对象还是会被创建，而且是属于永久带的对象。
 */
class StaticSingleton {
    /**
     * 私有构造方法，禁止在其他类中创建实例
     */
    private StaticSingleton() {}

    /**
     * 获取实例
     * @return
     */
    public static StaticSingleton getInstance() {
        return StaticSingletonHolder.instance;
    }

    /**
     * 一个私有的静态内部类，用于初始化一个静态final实例
     */
    private static class StaticSingletonHolder {
        private static final StaticSingleton instance = new StaticSingleton();
    }

    /**
     * 方法A
     */
    public void methodA() {}

    /**
     * 方法B
     */
    public void methodB() {}

    public static void main(String[] args) {
        StaticSingleton.getInstance().methodA();
        StaticSingleton.getInstance().methodB();
    }
}

/**
 * 饿汉式
 */
class Singleton2 {
    private static final Singleton2 instance = new Singleton2();

    private Singleton2() {}

    public static Singleton2 getInstance() {
        return instance;
    }
}

/**
 * 枚举方式
 * 创建枚举默认就是线程安全的，所以不需要担心double checked locking，
 * 而且还能防止反序列化导致重新创建新的对象。保证只有一个实例（即使使用反射机制也无法多次实例化一个枚举量）。
 */
class Singleton3 {
    public static Singleton3 getInstance() {
        return Single.INSTANCE.getInstance();
    }

    enum Single {
        INSTANCE;

        private Singleton3 singleton3;

        private Single() {
            System.out.println("枚举Single私有构造参数");
            singleton3 = new Singleton3();
        }

        public Singleton3 getInstance() {
            return singleton3;
        }
    }
}

/**
 * volatile 关键字
 * 解决 jvm内部重排序问题
 */
class Singleton4 {

    private volatile static Singleton4 instance = null;

    private Singleton4() {}

    public static Singleton4 getInstanceC() {
        if (null == instance) {
            synchronized (Singleton1.class) {
                if (null == instance) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}

/**
 * 使用 ThreadLocal
 * ThreadLocal会为每一个线程提供一个独立的变量副本，从而隔离了多个线程对数据的访问冲突。
 * 对于多线程资源共享的问题，同步机制采用了“以时间换空间”的方式，
 * 而ThreadLocal采用了“以空间换时间”的方式。前者仅提供一份变量，让不同的线程排队访问，
 * 而后者为每一个线程都提供了一份变量，因此可以同时访问而互不影响。
 */
class Singleton5 {

    private Singleton5() {}

    private static final ThreadLocal<Singleton5> tlSingleton = new ThreadLocal<Singleton5>() {
        @Override
        protected Singleton5 initialValue() {
            return new Singleton5();
        }
    };

    public static Singleton5 getInstance() {
        return tlSingleton.get();
    }
}

/**
 * 使用CAS锁实现
 */
class Singleton6 {
    /**
     * 利用AtomicReference
     */
    private static final AtomicReference<Singleton6> INSTANCE = new AtomicReference<>();

    /**
     * 私有化
     */
    private Singleton6() {}

    /**
     * 使用CAS确保线程安全
     * @return
     */
    public static final Singleton6 getInstance() {
        for (; ;) {
            Singleton6 current = INSTANCE.get();
            if (current != null) {
                return current;
            }
            current = new Singleton6();
            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }
}