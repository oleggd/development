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
    private List<BeanDefinition> beanDefinitionList;
    private String beanFile;

    public ClassPathApplicationContext(String beanFileName) {
        this.beanFile = beanFileName;

        beanDefinitionReader = new XmlBeanDefinitionReader(beanFile);
        beanDefinitionList = beanDefinitionReader.readBeanDefinition();
        Bean bean;
        //beanList = constructBeans(beanDefinitionReader.readBeanDefinition());
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            try {
                Class<?> clazz = Class.forName(beanDefinition.getClassName()/*"com.foo.MyClass"*/);
                Constructor<?> constructor = (Constructor<?>) clazz.getConstructor(beanDefinition.getValuesDependencies());
                Object instance = constructor.newInstance("stringparam", 42);
                bean = new Bean(beanDefinition.getId(),instance);
                beanList.add(bean);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


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
