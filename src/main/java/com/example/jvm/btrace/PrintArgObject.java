package com.example.jvm.btrace;

import com.example.jvm.dto.User;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import java.lang.reflect.Field;

/*利用btrace来打印Object类型的入参
 *
 * @author Lucifer
 * @date 2018／12／11 23:12
 * */


@BTrace //注明当前类为一个btrace脚本
public class PrintArgObject {

    @OnMethod(  //拦截的地点
        clazz = "com.example.jvm.web.BtraceController", //拦截的类
        method = "findUser",    //拦截的方法
        location = @Location(Kind.ENTRY)    //拦截的节点,ENTRY表示进入方法的时候
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, User user){
        BTraceUtils.println(user);
        Field field = BTraceUtils.field("com.example.jvm.dto.User", "name");
        BTraceUtils.println(BTraceUtils.get(field, user)); //  利用其提供的方法打印出类名和方法名
        BTraceUtils.println();
    }

}
