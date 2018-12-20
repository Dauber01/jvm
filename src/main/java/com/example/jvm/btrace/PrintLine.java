package com.example.jvm.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/*利用btrace来打印某行是否执行,如果执行了,则可以打印,没执行则无法打印
 *
 * @author Lucifer
 * @date 2018／12／11 23:12
 * */


@BTrace //注明当前类为一个btrace脚本
public class PrintLine {

    @OnMethod(  //拦截的地点
        clazz = "com.example.jvm.web.BtraceController", //拦截的类
            method = "exception",
            location = @Location(value = Kind.LINE, line = -1)    //当值为具体的行号的时候会显示该行有没有被执行，当为-1的时候,配合方法名来使用,会打印出该方法的所有的行
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn
            , int line){
        BTraceUtils.println(pcn + " , " + pmn + ", " + line); //  利用其提供的方法打印出类名和方法名
        BTraceUtils.println();
    }

}
