package com.coder.lock;

/**
 * @author: lichunxia
 * @create: 11/20/21 2:25 PM
 */
public class AQSTest {

    public static void main(String[] args) {

        try {
            for (;;) {
                System.out.println("for");
            }

        }finally {
            System.out.println("finally");
        }

    }
}
