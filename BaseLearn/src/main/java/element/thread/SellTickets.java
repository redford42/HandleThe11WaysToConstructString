package element.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author Hanz
 * @date 2019/8/16
 */
@Slf4j
class SellByRunnable implements Runnable {
    private int ticket;
    private long startTime;
    private static final Lock lock = new ReentrantLock();

    SellByRunnable(long startTime, int ticket) {
        this.startTime = startTime;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        selling();
    }

    private synchronized void selling() {
        while (ticket > 0) {
            try {
                lock.lock();
                ticket--;
                log.info("从" + Thread.currentThread().getName() + "窗口卖出第" + (ticket + 1) + "张票, " + "剩余" + ticket + "张票" + "耗时:" + (System.currentTimeMillis() - startTime));
            } finally {
                lock.unlock();
            }

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}

@Slf4j
class SellByNormal implements Runnable {
    private int ticket;
    private long startTime;

    SellByNormal(long startTime, int ticket) {
        this.startTime = startTime;
        this.ticket = ticket;
    }


    public void selling() {
        while (ticket > 0) {
            ticket = ticket - 1;
            log.info(Thread.currentThread().getName() + (ticket + 1) + "张票, " + "剩余" + ticket + "张票" + "耗时:" + (System.currentTimeMillis() - startTime));
//            try {
//                Thread.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public void run() {
        selling();
    }
}

@Slf4j
//@SpringBootApplication
public class SellTickets {

    public static void main(String[] args) {
        SpringApplication.run(SellTickets.class, args);
//        SellByNormal n = new SellByNormal(System.currentTimeMillis(), 10000);
//        new Thread(n, "windowA").start();
//        new Thread(n, "windowB").start();
//        new Thread(n, "windowC").start();
        SellByRunnable m = new SellByRunnable(System.currentTimeMillis(), 1000);
        new Thread(m, "windowA").start();
        new Thread(m, "windowB").start();
        new Thread(m, "windowC").start();
    }
}
