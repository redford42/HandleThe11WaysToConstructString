package element.thread.topic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hanz
 * @date 2020/3/16
 */
public class ThreeThreadPrintVer2 {
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        CloseableReentrantLock lock = new CloseableReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Thread printerA = new Thread(new ConditionSyncPrinter(lock, conditionA, conditionB, 'A'));
        Thread printerB = new Thread(new ConditionSyncPrinter(lock, conditionB, conditionC, 'B'));
        Thread printerC = new Thread(new ConditionSyncPrinter(lock, conditionC, conditionA, 'C'));
        printerA.start();
        printerB.start();
        printerC.start();
        //这里会有问题
        try(CloseableReentrantLock closeableLock = lock.open()) {
            conditionA.signalAll();
        }
    }
}
