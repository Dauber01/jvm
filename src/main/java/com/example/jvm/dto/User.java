package com.example.jvm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用来提供堆内存储的对象信息的类
 *
 * @author Lucifer
 * @date 2018／11／25 16:49
 */
@Data
@AllArgsConstructor
public class User {

    /** 用户的id属性. */
    private int id;

    /** 用户的名字. */
    private String name;

}
