package com.lyr.test.threadcoreknowledge.createthreads;

/**
 * @Author lyr
 * @Date 2/25/21 9:42 PM
 * @Version 1.0
 * @Description 同时使用Runnable和Thread两种实现线程的方式
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
