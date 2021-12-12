package com.coder.classloader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @author: lichunxia
 * @create: 2021-01-02 21:50
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(systemClassLoader);

        // 获取其上层：扩展类加载器
        ClassLoader exClassLoader = systemClassLoader.getParent();
        // sun.misc.Launcher$ExtClassLoader@61bbe9ba
        System.out.println(exClassLoader);

        // 试图获取其上层，获取不到引导类加载器
        ClassLoader parent = exClassLoader.getParent();
        // null
        System.out.println(parent);

        // 用户自定义类来说：默认使用系统自定义类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);

        // null
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);


        System.out.println("=====启动类加载器=====");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }

    }
}
