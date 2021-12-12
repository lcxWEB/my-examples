package com.coder.finals;

/**
 * @author: lichunxia
 * @create: 2021-03-27 11:42
 */
public class BlankFinal {

    final int i1 = 10;
    final int i2;//空白final

    public BlankFinal() {
        i2 = 1;
    }

    public BlankFinal(int x) {
        this.i2 = x;
    }

    public static void main(String[] args) {
        BlankFinal blankFinal = new BlankFinal();
        System.out.println(blankFinal.i2);
        System.out.println(blankFinal.i1);
    }
}
