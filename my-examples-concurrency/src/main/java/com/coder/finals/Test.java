package com.coder.finals;

import java.util.Random;

public class Test {

    // byte b1=1;
    // byte b2=3;
    // // 当程序执行到这一行的时候会出错，因为b1、b2可以自动转换成int类型的变量，运算时java虚拟机对它进行了转换，结果导致把一个int赋值给byte-----出错
    // byte b3=b1+b2;

    final byte b1=1;
    final byte b2=3;
    byte b3=b1+b2;//不会出错，相信你看了上面的解释就知道原因了。

    //编译期常量
    final int i = 1;
    final int[] a = {1, 2, 3, 4};
    //非编译期常量
    static Random r = new Random();
    final int k = r.nextInt(10);
    final static int J = r.nextInt(10);

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.k);
        System.out.println(J);
        Test test2 = new Test();
        System.out.println(test2.k);
        System.out.println(J);
    }
}