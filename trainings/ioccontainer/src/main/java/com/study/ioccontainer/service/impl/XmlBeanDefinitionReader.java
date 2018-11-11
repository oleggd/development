package com.study.ioccontainer.service.impl;

import com.study.ioccontainer.entity.BeanDefinition;
import com.study.ioccontainer.service.BeanDefinitionReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

 public class XmlBeanDefinitionReader implements BeanDefinitionReader {

     private String contextFile;
     private List<BeanDefinition> beanDefinitionList = null;
     private BeanDefinition beanDefinition = null;

     public XmlBeanDefinitionReader(String contextFile) {
         this.contextFile = contextFile;
     }

     public List<BeanDefinition> readBeanDefinition() {
         //List<BeanDefinition> beanDefinitionList = new ArrayList<>();
         //
         // read xml context file by beans
         // save bean into BeanDefinition
         // add to list of BeanDefinition
         // return list of BeanDefinition

         SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

         try {
             SAXParser saxParser = saxParserFactory.newSAXParser();
             XMLBeanHandler handler = new XMLBeanHandler();
             File xmlFile = new File(contextFile);

             saxParser.parse(xmlFile, handler);
             beanDefinitionList = handler.getBeanDefinitionList();

         } catch (ParserConfigurationException | SAXException | IOException e) {
             e.printStackTrace();
         }

         return beanDefinitionList;
     }

 }
