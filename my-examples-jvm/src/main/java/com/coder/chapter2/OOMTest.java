package com.coder.chapter2;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 *  -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 *  -XX:CompressedClassSpaceSize=5M
 *
 * @author: lichunxia
 * @create: 2021-05-03 18:28
 */
public class OOMTest extends ClassLoader {

    public static void main(String[] args) {
        // try {
        //     Thread.sleep(1000000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        int j = 0;
        try {
            OOMTest test = new OOMTest();
            for (int i = 0; i < 10000; i++) {
                // 创建ClassWriter对象，用于生产类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                // 指明版本号、修饰符、类名、包名、父类、接口
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                byte[] code = classWriter.toByteArray();
                // 类的加载
                test.defineClass("Class" + i, code, 0, code.length);
                j++;
            }
        } finally {
            System.out.println(j);
        }
    }

}
