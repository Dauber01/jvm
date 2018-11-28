package com.example.jvm.web;

import com.example.jvm.dto.User;
import com.example.jvm.utils.Metaspace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 测试堆超时的controller
 *
 * @author Lucifer
 * @date 2018／11／25 16:47
 */
@RestController
public class MemoryController {

    private List<User> userList = new ArrayList<User>();

    private List<Class<?>> classList = new ArrayList<>();

    /**
     * 定义关于初始化内存的参数 -Xmx=32M -Xms=32M
     */
    @GetMapping("/heap")
    public void heapMemory(){
        System.out.println("start");
        int i = 0;
        while (true){
            userList.add(new User(i++, UUID.randomUUID().toString()));
            System.out.println(i);
        }
    }

    /**
     * 定义关于初始化metaspace区的大小 -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     */
    @GetMapping("/nonheap")
    public void nonHeapMemory(){
        while (true){
            System.out.println("---");
            classList.addAll(Metaspace.createClass());
        }
    }

}
