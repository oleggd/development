package com.study.ioccontainer.service.impl;

import com.study.ioccontainer.entity.Bean;
import com.study.ioccontainer.entity.BeanDefinition;
import com.study.ioccontainer.service.ApplicationContext;
import com.study.ioccontainer.service.BeanDefinitionReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassPathApplicationContext implements ApplicationContext {

    private BeanDefinitionReader beanDefinitionReader;
    private List<Bean> beanList;
    private String beanFile;

    public ClassPathApplicationContext(String beanFileName) {
        this.beanFile = beanFileName;

        beanDefinitionReader = new XmlBeanDefinitionReader(beanFile);
        beanList = constructBeans(beanDefinitionReader.readBeanDefinition());

    }

    @Override
    public Object getBean(String id) {
        return null;
    }

    @Override
    public Object getBean(Class clazz) {
        return null;
    }

    @Override
    public Object getBean(String id, Class clazz) {

        return null;

    }

    public List<Bean> constructBeans(List<BeanDefinition> beanDefinitionList) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if ( beanList.isEmpty() ) {
            beanList = new ArrayList<>();
        }
        Bean bean = new Bean();
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            //
            //bean = getBean(beanDefinition.getId(),Class<beanDefinition.getClass()>);
            Class<?> clazz = Class.forName(String.valueOf(beanDefinition.getClass()));
            Constructor<?> constructor = clazz.getConstructor();
            Object object = constructor.newInstance(new Object[] {});
        }
        return null;
    }

    public List<Bean> injectValuesDependencies(List<BeanDefinition> beanDefinitionList, List<Bean> beanList) {
        return null;
    }

    public List<Bean> injectRefDependencies(List<BeanDefinition> beanDefinitionList, List<Bean> beanList) {
        return null;
    }
}
