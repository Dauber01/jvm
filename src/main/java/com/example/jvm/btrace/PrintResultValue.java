package com.example.jvm.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/*利用btrace来打印返回值
 *
 * @author Lucifer
 * @date 2018／12／11 23:12
 * */


@BTrace //注明当前类为一个btrace脚本
public class PrintResultValue {

    @OnMethod(  //拦截的地点
        clazz = "com.example.jvm.web.BtraceController", //拦截的类
        method = "sayHello",    //拦截的方法
        location = @Location(Kind.RETURN)    //拦截的节点,ENTRY表示进入方法的时候
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn
            , @Return AnyType result){
        BTraceUtils.println(pcn + " , " + pmn + ", " + result); //  利用其提供的方法打印出类名和方法名
        BTraceUtils.println();
    }

}
