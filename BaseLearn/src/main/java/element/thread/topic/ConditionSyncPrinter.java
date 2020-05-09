package element.thread.topic;

import java.util.concurrent.locks.Condition;

/**
 * @author Hanz
 * @date 2020/3/16
 */
public class ConditionSyncPrinter implements Runnable {
    private static final int PRINT_COUNT = 10;
    private final CloseableReentrantLock lock;
    private final Condition thisCondition;
    private final Condition nextCondition;
    private final char printChar;

    public ConditionSyncPrinter(CloseableReentrantLock lock, Condition thisCondition, Condition nextCondition, char printChar) {
        this.lock = lock;
        this.thisCondition = thisCondition;
        this.nextCondition = nextCondition;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        try (CloseableReentrantLock closeableLock = lock.open()) {
            for (int i = 0; i < PRINT_COUNT; i++) {
                try {
                    thisCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(printChar);
                nextCondition.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
