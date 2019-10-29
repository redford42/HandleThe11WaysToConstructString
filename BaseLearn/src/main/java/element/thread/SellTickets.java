package element.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;


/**
 * @author Hanz
 * @date 2019/8/16
 */
@Slf4j
class SellByRunnable implements Runnable {
    private int ticket;
    private long startTime;

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
            ticket--;
            log.info("从" + Thread.currentThread().getName() + "窗口卖出第" + (ticket + 1) + "张票, " + "剩余" + ticket + "张票" + "耗时:" + (System.currentTimeMillis() - startTime));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

@Slf4j
class SellByNormal {
    private int ticket;
    private long startTime;

    SellByNormal(long startTime, int ticket) {
        this.startTime = startTime;
        this.ticket = ticket;
    }


    public void selling() {
        while (ticket > 0) {
            ticket--;
            log.info("从普通窗口卖出第" + (ticket + 1) + "张票, " + "剩余" + ticket + "张票" + "耗时:" + (System.currentTimeMillis() - startTime));
        }
    }

}

@Slf4j
//@SpringBootApplication
public class SellTickets {

    public static void main(String[] args) {
        SpringApplication.run(SellTickets.class, args);
//        SellByNormal n = new SellByNormal(System.currentTimeMillis(), 10000);
//        n.selling();
        SellByRunnable m = new SellByRunnable(System.currentTimeMillis(), 1000);
        new Thread(m, "windowA").start();
        new Thread(m, "windowB").start();
        new Thread(m, "windowC").start();
    }
}
