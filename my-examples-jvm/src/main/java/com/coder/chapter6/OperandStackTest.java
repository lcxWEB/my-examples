package com.coder.chapter6;

/**
 * @author: lichunxia
 * @create: 2021-05-01 10:02
 */
public class OperandStackTest {

    public int getSum() {
        int m = 10;
        int n = 20;
        int k = m + n;
        return k;
    }

    /**
     * bipush（byte immediate push）、
     * sipush（short immediate push）、
     * ldc（load constant）
     */
    public synchronized void testGetSum() {
        int m = 900000; // 0 ldc #2 <900000>
        int n = 32767; // 3 sipush 32767
        int k = 127; //  7 bipush 127
        int a = 5; //  10 iconst_5
        int b = -1; //  13 iconst_m1
        int i = getSum();
        int j = 10;
    }

    public void add() {
        int i1 = 10;
        i1++;

        int i2 = 10;
        ++i2;


        int i3 = 10;
        int i4 = i3++;

        int i5 = 10;
        int i6 = ++i5;

        int i8 = 10;
        i8 = ++i8;

        int i9 = 10;
        int i10 = i9++ + ++i9;
    }
}
