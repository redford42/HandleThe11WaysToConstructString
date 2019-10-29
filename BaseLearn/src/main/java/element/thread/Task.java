package element.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Hanz
 * @date 2019/8/19
 */
@Slf4j
@EnableAsync
@SpringBootApplication
public class Task {
    @Autowired
    private AsyncDemo asyncDemo;

    public static void main(String[] args) {
        SpringApplication.run(Task.class, args);
        Task task = new Task();
        task.test();
    }

    public void test() {
        try {
            asyncDemo.asyncNoReturn2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        asyncDemo.asyncNoReturn1();
    }
}
