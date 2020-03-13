package com.abeford.beanFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Hanz
 * @date 2020/3/10
 */
public class maintest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Simplebean bean = context.getBean(Simplebean.class);
        bean.send();
        context.close();
    }
}
