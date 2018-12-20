package com.example.jvm.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/*利用btrace来打印相同方法名
 *
 * @author Lucifer
 * @date 2018／12／11 23:12
 * */


@BTrace //注明当前类为一个btrace脚本
public class PrintSameMethod {

    @OnMethod(  //拦截的地点
        clazz = "com.example.jvm.web.BtraceController", //拦截的类
        method = "same"    //拦截的方法
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn
            , String name, int id){
        BTraceUtils.println(name + id);   //利用其提供的方法打印出参数数组
        BTraceUtils.println(pcn + " , " + pmn); //  利用其提供的方法打印出类名和方法名
        BTraceUtils.println();
    }

}
