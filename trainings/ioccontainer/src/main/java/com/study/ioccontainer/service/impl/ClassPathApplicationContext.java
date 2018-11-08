package com.study.ioccontainer.service.impl;

import com.study.ioccontainer.entity.Bean;
import com.study.ioccontainer.entity.BeanDefinition;
import com.study.ioccontainer.service.ApplicationContext;
import com.study.ioccontainer.service.BeanDefinitionReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathApplicationContext implements ApplicationContext {

    private BeanDefinitionReader beanDefinitionReader;
    private List<Bean> beanList;
    private List<BeanDefinition> beanDefinitionList;
    private String beanFile;

    public ClassPathApplicationContext(String beanFileName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.beanFile = beanFileName;

        beanDefinitionReader = new XmlBeanDefinitionReader(beanFile);
        beanDefinitionList = beanDefinitionReader.readBeanDefinition();
        Bean bean;

        // build beans list
        beanList = constructBeans(beanDefinitionList);
        // values dependencies
        injectValuesDependencies(beanDefinitionList, beanList);
        // values depandencies
        injectRefDependencies(beanDefinitionList, beanList);

    }

    @Override
    public Object getBean(String id) {

        for (Bean bean : beanList) {
            if (bean.getId().equals(id)) {
                return bean.getValue();
            }
        }
        return null;
    }

    @Override
    public Object getBean(Class clazz) {

        for (Bean bean : beanList) {
            if (bean.getValue().getClass() == clazz) {
                return bean.getValue();
            }
        }
        return null;
    }

    @Override
    public Object getBean(String id, Class clazz) {

        for (Bean bean : beanList) {
            if ((bean.getId().equals(id)) && (bean.getValue().getClass() == clazz)) {
                return bean.getValue();
            }
        }
        return null;

    }

    private List<Bean> constructBeans(List<BeanDefinition> beanDefinitionList) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        List<Bean> beanList = new ArrayList<>();
        Bean bean;

        /*if (beanList.isEmpty()) {
            beanList = new ArrayList<>();
        }
*/
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            try {
                Class<?> clazz = Class.forName(beanDefinition.getClassName());
                Object instance = clazz.newInstance();
                bean = new Bean(beanDefinition.getId(), instance);
                beanList.add(bean);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return beanList;
    }

    /*List<Bean>*/void injectValuesDependencies(List<BeanDefinition> beanDefinitionList, List<Bean> beanList) {

        String beanID = "";
        String setterName= "";
        Map<String, String> valuesDependencies = new HashMap<>();

        for (BeanDefinition beanDefinition : beanDefinitionList) {

            beanID = beanDefinition.getId();
            valuesDependencies = beanDefinition.getValuesDependencies();

            Object beanObject = new Object();

            // get bean for current beanDefinition
            beanObject = getBeanValueByID(beanList, beanID);

            Method setter;
            for (Map.Entry<String, String> entry : valuesDependencies.entrySet()) {
                // get setter by name = set + beanDefinition.name
                setterName = "set" + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1);

                Class<?> clazz = beanObject.getClass();
                try {
                    setter = clazz.getMethod(setterName, entry.getValue().getClass());
                    // call setter for current bean object with beanDefinition.value
                    setter.invoke(beanObject,entry.getValue());
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void injectRefDependencies(List<BeanDefinition> beanDefinitionList, List<Bean> beanList) {

        String beanID = "";
        String setterName= "";
        Map<String, String> refDependencies = new HashMap<>();

        for (BeanDefinition beanDefinition : beanDefinitionList) {

            beanID = beanDefinition.getId();
            refDependencies = beanDefinition.getRefDependencies();

            if (refDependencies != null) {

                Object beanObject = new Object();
                // get bean for current beanDefinition
                beanObject = getBeanValueByID(beanList, beanID);
                Method setter;

                for (Map.Entry<String, String> entry : refDependencies.entrySet()) {
                    // get setter by name = set + beanDefinition.name
                    setterName = "set" + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1);

                    Class<?> clazz = beanObject.getClass();
                    Object refBeanObject = new Object();
                    try {
                        // get referenced bean
                        refBeanObject = getBeanValueByID(beanList, entry.getValue());
                        //
                        setter = clazz.getMethod(setterName, (Class<?>) refBeanObject.getClass());
                        // call setter for current bean object with beanDefinition.value - existing bean object
                        setter.invoke(beanObject,refBeanObject);

                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private Object getBeanValueByID(List<Bean> beanList, String beanID) {

        for (Bean bean : beanList) {
            if (bean.getId().equals(beanID)) {
                return bean.getValue();
            }
        }
        return null;
    }


}
