package com.zwan;

/**
 * 虚拟机栈和本地方法栈测试
 * VM Args: -Xss128k
 * -Xss128k 规定了每个线程虚拟机栈大小
 *
 * 此次报错是因为超过虚拟机栈最大深度 新的栈帧内存无法分配
 * @author zwan
 * Create by zwan on 2022/4/27 22:20
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();

        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("虚拟机栈深度：" + javaVMStackSOF.stackLength);
            throw e;
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
}
