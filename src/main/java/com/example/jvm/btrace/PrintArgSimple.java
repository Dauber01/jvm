package com.example.jvm.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/*利用btrace来打印运行中的类的入参的脚本*
 *
 * @author Lucifer
 * @date 2018／12／11 23:12
 * */


@BTrace //注明当前类为一个btrace脚本
public class PrintArgSimple {

    @OnMethod(  //拦截的地点
        clazz = "com.example.jvm.web.BtraceController", //拦截的类
        method = "sayHello",    //拦截的方法
        location = @Location(Kind.ENTRY)    //拦截的节点,ENTRY表示进入方法的时候
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn
            , AnyType[] args){
        BTraceUtils.printArray(args);   //利用其提供的方法打印出参数数组
        BTraceUtils.println(pcn + " , " + pmn); //  利用其提供的方法打印出类名和方法名
        BTraceUtils.println();
    }

}
