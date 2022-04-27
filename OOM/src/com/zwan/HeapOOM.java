package com.zwan;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出异常测试
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * -Xms20m 最小堆内存
 * -Xmx20m 最大堆内存
 * -XX:+HeapDumpOnOutOfMemoryError 内存溢出时将当前内存堆转储快照
 *
 * @author zwan
 * Create by zwan on 2022/4/27 21:56
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }

    static class OOMObject {
    }
}
