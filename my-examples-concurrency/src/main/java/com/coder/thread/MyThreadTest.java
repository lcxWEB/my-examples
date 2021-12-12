package com.coder.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThreadTest {

    public static void main(String[] args) {
        MyCallThread thread = new MyCallThread();
        FutureTask<Integer> task = new FutureTask<>(thread);
        Thread t = new Thread(task, "新线程");
        t.start();

        try {
            System.out.println("task get : " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        FutureTask<String> futureTask = new FutureTask<>(() -> "callable线程");
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}