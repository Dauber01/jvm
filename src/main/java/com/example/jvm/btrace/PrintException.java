package com.example.jvm.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 利用btrace来打印运行中出现,但是并没有被打印出的异常的信息
 *
 * @author Lucifer
 * @date 2018／12／11 23:12
 */


@BTrace //注明当前类为一个btrace脚本
public class PrintException {

    //用来保存拦截到的异常,该注解表明将异常的本体保存到了threadlocal中进行存储
    @TLS
    static Throwable throwable;

    @OnMethod(  //拦截的地点
        clazz = "java.lang.Throwable", //拦截的类
        method = "<init>"    //拦截的方法
    )
    public static void onThrowable(@Self Throwable sef){    //self指为函数本身
        throwable = sef;
    }

    @OnMethod(  //拦截的地点
        clazz = "java.lang.Throwable", //拦截的类
        method = "<init>"    //拦截的方法
    )
    public static void onThrowable1(@Self Throwable sef, String message){    //self指为函数本身
        throwable = sef;
    }

    @OnMethod(  //拦截的地点
        clazz = "java.lang.Throwable", //拦截的类
        method = "<init>"    //拦截的方法
    )
    public static void onThrowable2(@Self Throwable sef, String message, Throwable cause){    //self指为函数本身
        throwable = sef;
    }

    @OnMethod(  //拦截的地点
        clazz = "java.lang.Throwable", //拦截的类
        method = "<init>"    //拦截的方法
    )
    public static void onThrowable3(@Self Throwable sef, Throwable cause){    //self指为函数本身
        throwable = sef;
    }

    @OnMethod(  //拦截的地点
        clazz = "java.lang.Throwable", //拦截的类
        method = "<init>",    //拦截的方法
        location = @Location(Kind.RETURN)
    )
    public static void onThrowReturn(){
        //在方法结束的时候,如果该异常状态有值,则将其打印出来
        if (throwable != null){
            BTraceUtils.Threads.jstack(throwable);
            BTraceUtils.println("========");
            throwable = null;
        }
    }

}
