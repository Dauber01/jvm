package com.example.jvm.web;

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
     * @param name
     * @return
     */
    @GetMapping("/test")
    public String sayHello(@RequestParam("name") String name){
        return "hello " + name + " !";
    }

}
