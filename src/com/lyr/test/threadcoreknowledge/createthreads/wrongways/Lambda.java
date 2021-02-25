package com.lyr.test.threadcoreknowledge.createthreads.wrongways;

/**
 * @Author lyr
 * @Date 2/25/21 10:09 PM
 * @Version 1.0
 * @Description Lambda表达式实现线程
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
