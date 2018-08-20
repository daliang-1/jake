package com.jake.jvm.Error;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存溢出Error: OutOfMemoryError(OOM)
 * 线程申请内存时,虚机无法再分配新的内存时,导致出现内存溢出
 *
 * @author: chenliang.wang
 * @Date: 2018年07月31日 PM3:18
 * @company: 易宝支付(YeePay)
 */
public class OutOfMemoryErrorModel {

    public static void main(String[] args) {
//        OOM1();

        OOM2();
    }

    /**
     * 堆内存溢出("Java heap space")
     */
    public static void OOM1() {
        List<Object> list = Lists.newArrayList();
        int num = 0;
        while (true) {
            // 无限制的新增数据量,线程无限制申请内存,导致内存溢出
            list.add(new byte[1024 * 1024]); // 每次新增1M大小的数据对象
            System.out.println(++num);
        }
    }

    /**
     * 方法区内存溢出
     *
     * 1.6 -> -XX:PermSize=10M -XX:MaxPermSize=10M
     *        "PermGen space" : 说明常量池位于方法区(永久代)
     *
     * 1.7 -> -Xms5m -Xmx5m
     *        "Java heap space" : 说明常量池位于堆中
     *        "GC overhead limit exceeded" : 程序基本上耗尽了所有的可用内存,GC也清理不了,而GC主要负责堆回收。
     */
    public static void OOM2() {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
