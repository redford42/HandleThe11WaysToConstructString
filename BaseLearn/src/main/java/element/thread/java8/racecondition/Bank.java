package element.thread.java8.racecondition;

/**
 * @author Hanz
 * @date 2020/7/14
 */
public class Bank {

    public void transfer(int from, int to, double amount) {
        System.out.println(Thread.currentThread());

    }
}
