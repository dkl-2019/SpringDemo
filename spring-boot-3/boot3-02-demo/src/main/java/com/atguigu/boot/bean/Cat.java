package com.atguigu.boot.bean;

public class Cat {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat() {
        this.name = name;
    }

    private String name;

}
