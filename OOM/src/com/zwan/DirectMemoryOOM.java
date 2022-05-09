package com.zwan;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出
 * 使用unsafe分配本机内存
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * -XX:MaxDirectMemorySize=10M 直接内存的容量大小
 *
 * @author zwan
 * Create by zwan on 2022/5/5 22:57
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
