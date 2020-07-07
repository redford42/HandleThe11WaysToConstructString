package element.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * @author Hanz
 * @date 2020/7/6
 */
public class Executor {
    public static void main(String[] args) {
        boolean exitFlag = false;
        ExecutorService taskScanner = newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread("Report Task Scanner");
            }
        });
        taskScanner.submit(new Runnable() {
            @Override
            public void run() {
                while (!exitFlag) {
                    System.out.println("hais_________________________");
                }
            }
        });

    }

}
