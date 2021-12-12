package com.coder.thread;

public class SleepMessages {
    public static void main(String args[]) throws InterruptedException {
        // float f = 4.6667777788887f;
        // double d = 4.6667777788887555566666;
        // System.out.println(f);
        // System.out.println(d);

        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for (int i = 3; i < 55; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        System.out.println(f3);
        System.out.println(Integer.MAX_VALUE);
        int[] x = {1,2,3};

        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 4 seconds
            //The thread does not lose ownership of any monitors.
            Thread.sleep(4000);
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }

}