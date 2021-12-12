package com.coder.chapter7;

import sun.misc.Launcher;
import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

/**
 * @author: lichunxia
 * @create: 2021-04-26 14:14
 */
public class MyClassLoaderTest {

    public static void main(String[] args) {

        // 系统类加载器(应用程序类加载器)
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获取上层：扩展类加载器   jre/lib/ext 下的类库
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent); // sun.misc.Launcher$ExtClassLoader@511d50c0

        // 获取不到 引导类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1); // null


        // 对于用户自定义类
        ClassLoader classLoader = MyClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1); // null

        System.out.println("****引导类加载器/启动类加载器*****");
        // 获取BootstraClassLoader加载的类路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }

        ClassLoader classLoader3 = Provider.class.getClassLoader();
        System.out.println(classLoader3); // null
        System.out.println("****end*****");

        System.out.println("****扩展类加载器*****");
        String extDirs = System.getProperty("java.ext.dirs");
        String[] paths = extDirs.split(":");
        for (String path : paths) {
            System.out.println(path);
        }
        System.out.println("****end*****");

        ClassLoader classLoader2 = CurveDB.class.getClassLoader();
        System.out.println(classLoader2); //sun.misc.Launcher$ExtClassLoader@511d50c0


    }
}
