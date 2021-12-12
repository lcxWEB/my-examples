package com.coder.thread;

/**
 * The Thread class defines a number of methods useful for thread management.
 * These include static methods, which provide information about, or affect the status of, the thread invoking the method.
 * The other methods are invoked from other threads involved in managing the thread and Thread cooperate.
 * We'll examine some of these methods in the following sections.
 */
public class HelloRunnable implements Runnable {

    private Integer sum = 0;

    public static void main(String args[]) {
        HelloRunnable target = new HelloRunnable();
        Thread thread = new Thread(target);
        thread.start();
        try {
            thread.join();
            System.out.println("result：" + target.sum);
        } catch (InterruptedException e) {

        }
        thread.interrupt();
    }

    public void run() {
        // while (true) {
        //     System.out.println("Hello from a thread!");
        //     try {
        //         Thread.sleep(10000);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }
        for (int i = 0; i < 100; i++) {
            sum = sum + i;
            System.out.println(sum);
        }

    }

}