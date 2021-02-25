package com.lyr.test.threadcoreknowledge.createthreads;

/**
 * @Author lyr
 * @Date 2/25/21 9:17 PM
 * @Version 1.0
 * @Description 用Runnable方式创建线程
 */
public class RunnableStyle implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("用Runnable方法实现线程");
    }
}
