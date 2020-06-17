package com.whisper.springsecurity.demo;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * 线程的创建方式：简单方式：继承Thread类；实现Runnable接口
 *              复杂方式：实现Callable接口；
 * */
public class DemoThread {

    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
                pong();
            }
        };
        t.run();
        //System.out.println("ping=======t");

        Thread thread = new Thread() {

            @Override
            public void run() {
                pong();
            }
        };
        thread.start();
        //System.out.println("ping======thread");


        FutureTask<String> futureTask = new FutureTask<>(new Thread1());
        Thread thread2 = new Thread(futureTask);
        thread2.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void pong() {
        //System.out.println("pong");
    }
}
