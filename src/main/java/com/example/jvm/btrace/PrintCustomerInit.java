package com.example.jvm.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/*利用btrace来打印类构造器的入参
 *
 * @author Lucifer
 * @date 2018／12／11 23:12
 * */


@BTrace //注明当前类为一个btrace脚本
public class PrintCustomerInit {

    @OnMethod(  //拦截的地点
        clazz = "com.example.jvm.dto.User", //拦截的类
        method = "<init>"    //拦截的方法
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn
            , AnyType[] args){
        BTraceUtils.printArray(args);   //利用其提供的方法打印出参数数组
        BTraceUtils.println(pcn + " , " + pmn); //  利用其提供的方法打印出类名和方法名
        BTraceUtils.println();
    }

}
