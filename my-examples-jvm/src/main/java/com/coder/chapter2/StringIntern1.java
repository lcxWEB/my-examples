package com.coder.chapter2;

/**
 * @author: lichunxia
 * @create: 2021-05-04 18:25
 */
public class StringIntern1 {

    public static void main(String[] args) {
        String s = new String("1");
        s.intern(); // 调用此方法之前，字符串常量池中已经存在了"1"
        String s2 = "1";
        System.out.println(s == s2); // false

        String s3 = new String("1") + new String("1");
        s3.intern(); // 在字符串常量池中生成"11"
        String s4 = "11";
        System.out.println(s3 == s4); // true，因为intern的时候会把"11"的引用地址放到字符串常量池
    }
}
