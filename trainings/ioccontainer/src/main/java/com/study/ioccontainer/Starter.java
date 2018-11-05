package com.study.ioccontainer;

import com.study.ioccontainer.service.ApplicationContext;
import com.study.ioccontainer.service.impl.ClassPathApplicationContext;

public class Starter {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathApplicationContext("testContextFile.xml");

    }
}
