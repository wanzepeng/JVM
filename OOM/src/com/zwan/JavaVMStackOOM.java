package com.zwan;

/**
 * 创建线程导致内存溢出异常
 * VM Args: -Xss100m
 * -Xss2m 规定了每个线程虚拟机栈大小
 * 在32位机器上 规定了每个进程的最大内存限制 因此无限制的新建进程并分配给虚拟机栈内存后会导致OOM
 * 在64位机器上没有复现
 *
 * @author zwan
 * Create by zwan on 2022/4/27 22:47
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(()-> dontStop());
            thread.start();
        }
    }
    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
