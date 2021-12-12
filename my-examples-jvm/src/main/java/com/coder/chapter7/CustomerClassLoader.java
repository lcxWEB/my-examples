package com.coder.chapter7;

import java.io.FileNotFoundException;

/**
 * @author: lichunxia
 * @create: 2021-04-26 21:48
 */
public class CustomerClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            byte[] bytes = getClassFromCustomerPath(name);
            if (bytes == null) {
                throw new FileNotFoundException();
            } else {
                return defineClass(name, bytes, 0, bytes.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }

    private byte[] getClassFromCustomerPath(String name) {
        // 比如对字节码文件进行解密
        return null;
    }

}
