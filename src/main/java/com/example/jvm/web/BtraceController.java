package com.example.jvm.web;

import com.example.jvm.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Btrace的controller
 *
 * @author Lucifer
 * @date 2018／12／11 22:58
 */
@RestController
@RequestMapping("/btrace")
public class BtraceController {

    /**
     * 用来演示,btrace示例的controller
     *
     * @param name
     * @return
     */
    @GetMapping("/test")
    public String sayHello(@RequestParam("name") String name){
        return "hello " + name + " !";
    }

    /**
     * 通过传入的user的属性,直接构造user,进行监听,同时获取对应的值
     *
     * @param user 用户信息
     * @return
     */
    @GetMapping("/test2")
    public User findUser(User user){
        return user;
    }

    /**
     * 用来演示,当方法的名字相同的时候,通过参数来区分btrace需要拦截的方法
     *
     * @param name
     * @return
     */
    @GetMapping("/same1")
    public String same(@RequestParam("name") String name){
        return "hello " + name + " !";
    }

    /**
     * 用来演示,当方法的名字相同的时候,通过参数来区分btrace需要拦截的方法
     *
     * @param name
     * @return
     */
    @GetMapping("/same2")
    public String same(@RequestParam("name") String name, @RequestParam("id") int id){
        return "hello " + name + ", " + id + " !";
    }

    /**
     * 抛出一个异常,供btrace的异常拦截来演示拦截
     *
     * @return
     */
    @GetMapping("/exception")
    public String exception(){
        try {
            System.out.println("start");
            System.out.println(1/0);
            System.out.println("end");
        }catch (Exception e){
            //do nothing
        }
        return "SUCCESS";
    }

}
