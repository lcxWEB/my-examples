package com.coder.chapter3;

/**
 * @author: lichunxia
 * @create: 2021-05-05 09:27
 */
public class CanReliveObj {

    private static CanReliveObj obj;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        obj = this;
    }


    public static void main(String[] args) {
        obj = new CanReliveObj();

        obj = null;

        System.gc();

        System.out.println("第一次GC");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("第二次GC");
        obj = null;

        System.gc();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
