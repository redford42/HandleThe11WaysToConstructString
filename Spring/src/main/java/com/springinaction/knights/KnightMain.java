package com.springinaction.knights;

import com.springinaction.knights.config.KnightConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Hanz
 * @date 2020/5/29
 */
public class KnightMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("knights.xml");

//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(KnightConfig.class);

        Knight knight = (Knight) context.getBean("knight");

        knight.embarkOnQuest();
    }
}
