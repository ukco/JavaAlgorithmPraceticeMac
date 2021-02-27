package com.lyr.test.threadcoreknowledge.startthread;

/**
 * @Author lyr
 * @Date 2/27/21 2:32 PM
 * @Version 1.0
 * @Description 掩饰不能两次调用start方法，否则会报错
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
