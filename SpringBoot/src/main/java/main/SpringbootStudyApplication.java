package main;

import config.MYSQLConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Hanz
 * @date 2020/5/11
 */
//@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
public class SpringbootStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStudyApplication.class,args);
        MYSQLConfig mysqlConfig = new MYSQLConfig();
        System.out.println(mysqlConfig.getHost());
    }
}
