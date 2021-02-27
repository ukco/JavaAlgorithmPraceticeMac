package com.lyr.test.threadcoreknowledge.startthread;

/**
 * @Author lyr
 * @Date 2/27/21 2:20 PM
 * @Version 1.0
 * @Description 对比start和run两种启动线程的方式
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();

        new Thread(runnable).start();
    }
}
