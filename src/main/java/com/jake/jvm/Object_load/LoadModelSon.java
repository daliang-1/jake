package com.jake.jvm.Object_load;

/**
 * @author: chenliang.wang
 * @Date: 2018年08月09日 PM6:15
 * @company: 易宝支付(YeePay)
 */
public class LoadModelSon extends LoadModelFather {

    public static int d = 0;

    static {
        System.out.println("This is LoadModelSon init");
    }


    public LoadModelSon() {
        d++;
    }
}
