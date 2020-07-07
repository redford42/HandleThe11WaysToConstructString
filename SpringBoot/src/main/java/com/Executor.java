package com;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * @author Hanz
 * @date 2020/7/6
 */
@Service
public class Executor implements ApplicationRunner {
//    @PostConstruct
//    public void init() {
//
//    }

    public void fakeOutPut() {
        System.out.println("假吧意思输出一下");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("难道是我没执行？？？？？？？？？？？？？");
        boolean exitFlag = false;
        ExecutorService taskScanner = newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread("Report Task Scanner");
            }
        });
        taskScanner.submit((Runnable) () -> {
            while (true) {
                System.out.println("hais_________________________");
            }
        });
    }
}
