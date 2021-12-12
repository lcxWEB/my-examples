package com.coder.chapter2;

/**
 * @author: lichunxia
 * @create: 2021-05-03 19:32
 */
public class MethodAreaTest {

    public static void main(String[] args) {
        Order order = null;
        order.hello(); // 不会报空指针异常
        System.out.println(order.count);
    }
}


class Order {

    public static final int number = 2;
    public static int count = 1;


    public static void hello() {
        System.out.println("hello");
    }

}