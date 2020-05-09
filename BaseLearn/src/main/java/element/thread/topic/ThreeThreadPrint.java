package element.thread.topic;

/**
 * @author Hanz
 * @date 2020/3/16
 */
public class ThreeThreadPrint {
    private int count = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();

    public static void main(String[] args) throws InterruptedException {
        new ThreeThreadPrint().multiTurning();
    }

    public void multiTurning() throws InterruptedException {
        Thread t1 = new Thread(new MultiTurningRunner(lock3, lock1, "线程1: "));
        Thread t2 = new Thread(new MultiTurningRunner(lock1, lock2, "线程2: "));
        Thread t3 = new Thread(new MultiTurningRunner(lock2, lock3, "线程3: "));
        t1.start();
        Thread.sleep(100);
        t2.start();
        t3.start();
    }

    class MultiTurningRunner implements Runnable {
        private final Object preLock;
        private final Object currentLock;
        private final String content;

        public MultiTurningRunner(Object preLock, Object currentLock, String content) {
            this.preLock = preLock;
            this.currentLock = currentLock;
            this.content = content;
        }

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (preLock) {
                    synchronized (currentLock) {
                        System.out.println(content + count++);
                        // 唤醒等待当前锁的线程
                        currentLock.notifyAll();
                    }
                    try {
                        // 如果还需要继续执行，则让出下一个线程对应的锁并进入等待状态
                        if (count <= 100) {
                            preLock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
