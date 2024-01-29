package com.atguigu.boot.controller.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Child {
    private String name;
    private Integer age;
    private Date birthday;
    private List<String> text;

}
