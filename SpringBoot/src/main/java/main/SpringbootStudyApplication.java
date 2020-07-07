package main;

import com.Executor;
import config.MYSQLConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * @author Hanz
 * @date 2020/5/11
 */
//@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
public class SpringbootStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStudyApplication.class, args);
        MYSQLConfig mysqlConfig = new MYSQLConfig();
        System.out.println(mysqlConfig.getHost());
        ExecutorService executorService = newSingleThreadExecutor(
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread("Report Task Scanner");
                    }
                }
        );
        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("?????????????????????日");
            }
        });
    }
}

