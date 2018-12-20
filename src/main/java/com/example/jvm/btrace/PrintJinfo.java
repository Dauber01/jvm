package com.example.jvm.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/*利用btrace来打印运行中的jinfo信息
 *
 * @author Lucifer
 * @date 2018／12／11 23:12
 * */


@BTrace //注明当前类为一个btrace脚本
public class PrintJinfo {

    static {
        BTraceUtils.println("system propertise");
        //打印启动属性
        BTraceUtils.printProperties();
        BTraceUtils.println("vm flag");
        //打印虚拟机的参数
        BTraceUtils.printVmArguments();
        BTraceUtils.println("os everement");
        //打印操作系统的环境变量
        BTraceUtils.printEnv();
        //退出
        BTraceUtils.exit(0);
    }

}
