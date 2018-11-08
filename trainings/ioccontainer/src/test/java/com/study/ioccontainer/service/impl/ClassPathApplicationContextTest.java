package com.study.ioccontainer.service.impl;

import com.study.ioccontainer.entity.Bean;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class ClassPathApplicationContextTest {

    ClassPathApplicationContext classPathApplicationContext;

    @Before
    public void Before () throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {


        String testContextFile = "testContextFile.xml";
        //List<BeanDefinition> beanDefinitionList = new ArrayList<>();

        //XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(testContextFile);
        //beanDefinitionList = beanDefinitionReader.readBeanDefinition();
        classPathApplicationContext = new ClassPathApplicationContext(testContextFile);
    }
    @Test
    public void getBeanByID() {
        Object bean = classPathApplicationContext.getBean("testProductID");
        assertTrue(bean.getClass().getName().equals("com.study.ioccontainer.service.impl.TestProductClass"));

        bean = null;
        bean = classPathApplicationContext.getBean("testUserID");
        assertTrue(bean.getClass().getName().equals("com.study.ioccontainer.service.impl.TestUserClass"));
        bean = null;
        bean = classPathApplicationContext.getBean("testRoleID");
        assertTrue(bean.getClass().getName().equals("com.study.ioccontainer.service.impl.TestRoleClass"));

    }

    @Test
    public void getBeanByClass() {

        Object bean = classPathApplicationContext.getBean(TestProductClass.class);
        assertTrue(bean != null);

        bean = null;
        bean = classPathApplicationContext.getBean(TestUserClass.class);
        assertTrue(bean != null);
        bean = null;
        bean = classPathApplicationContext.getBean(TestRoleClass.class);
        assertTrue(bean != null);
    }

    @Test
    public void getBeanByClassAndID() {
        Object bean = classPathApplicationContext.getBean("testProductID", TestProductClass.class);
        assertTrue(bean != null);

        bean = null;
        bean = classPathApplicationContext.getBean("testUserID", TestUserClass.class);
        assertTrue(bean != null);
        bean = null;
        bean = classPathApplicationContext.getBean("testRoleID", TestRoleClass.class);
        assertTrue(bean != null);
    }

}

