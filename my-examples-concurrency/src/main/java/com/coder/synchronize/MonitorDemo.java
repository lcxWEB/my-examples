package com.coder.synchronize;

/**
 * @author: lichunxia
 * @create: 2021-03-22 16:06
 */
public class MonitorDemo {

    private int a =0;

    public synchronized void writer() {
        a++;
    }

    public synchronized void reader() {
        int i = a;
        System.out.println(i);
    }

    public static void main(String[] args) {
        MonitorDemo monitorDemo = new MonitorDemo();
        monitorDemo.writer();
        monitorDemo.reader();
    }

}
