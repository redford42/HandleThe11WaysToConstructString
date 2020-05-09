package element.thread.topic;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hanz
 * @date 2020/3/16
 */
public class CloseableReentrantLock extends ReentrantLock implements AutoCloseable {
    public CloseableReentrantLock open() {
        this.lock();
        return this;
    }

    @Override
    public void close() throws Exception {
        try {
            this.unlock();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
