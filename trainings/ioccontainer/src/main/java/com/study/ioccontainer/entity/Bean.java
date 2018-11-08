package com.study.ioccontainer.entity;

public class Bean {
    public Bean(String id, Object value) {
        this.id = id;
        this.value = value;
    }

    String id;
    Object value;
}
