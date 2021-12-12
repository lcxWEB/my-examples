package com.coder.finals;

public class FinalReferenceDemo {
    final int[] arrays;
    private FinalReferenceDemo finalReferenceDemo;

    public FinalReferenceDemo() {
        arrays = new int[1];  //1
        arrays[0] = 1;        //2
    }

    /**
     * 线程A
     */
    public void writerOne() {
        finalReferenceDemo = new FinalReferenceDemo(); //3
    }

    /**
     * 线程B
     * 对arrays的写入对C不可见
     */
    public void writerTwo() {
        arrays[0] = 2;  //4
    }

    /**
     * 线程C
     */
    public void reader() {
        if (finalReferenceDemo != null) {  //5
            int temp = finalReferenceDemo.arrays[0];  //6
        }
    }
}
  