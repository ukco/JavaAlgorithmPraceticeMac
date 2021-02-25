package com.lyr.test.threadcoreknowledge.createthreads;

/**
 * @Author lyr
 * @Date 2/25/21 9:19 PM
 * @Version 1.0
 * @Description 用Thread方式实现线程
 */
public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
