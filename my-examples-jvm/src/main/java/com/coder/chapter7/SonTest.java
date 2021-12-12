package com.coder.chapter7;

/**
 * @author: lichunxia
 * @create: 6/6/21 5:59 PM
 */
public class SonTest {

    public static void main(String[] args) {
        Son son = new Son();
        son.print();
    }

}

/**
 * @author: lichunxia
 * @create: 6/6/21 5:53 PM
 */
class Father {

    int x = 10;

    public Father() {
        this.print();
        x = 20;
    }

    public void print() {
        System.out.println("father === " + x);
    }


}

class Son extends Father {

    int x = 30;

    public Son() {
        this.print();
        x = 40;
    }

    public void print() {
        System.out.println("son === " + x);
    }

}
