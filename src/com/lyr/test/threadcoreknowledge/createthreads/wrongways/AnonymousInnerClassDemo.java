package com.lyr.test.threadcoreknowledge.createthreads.wrongways;

/**
 * @Author lyr
 * @Date 2/25/21 10:07 PM
 * @Version 1.0
 * @Description 用匿名内部类实现线程
 */
public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
