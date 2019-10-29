package element.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * @author Hanz
 * @date 2019/8/19
 */
@Slf4j
@Component
public class AsyncDemo {
//    public static void main(String[] args) {
//        SpringApplication.run(AsyncDemo.class, args);
//        AsyncDemo asyncDemo = new AsyncDemo();
//        asyncDemo.doTask();
//    }

    @Async
    public void asyncNoReturn1() {
        System.out.println("一个莫得感情的杀手" + Thread.currentThread().getName());
    }

    @Async
    public void asyncNoReturn2() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("一个莫得感情的杀手还沉睡了五秒钟" + Thread.currentThread().getName());
    }
}
