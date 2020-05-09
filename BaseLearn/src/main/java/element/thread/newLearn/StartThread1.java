package element.thread.newLearn;

/**
 * 继承Thread 重写Run
 *
 * @author Hanz
 * @date 2020/2/28
 */
public class StartThread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Listening to music");
        }
    }

    public static void main(String[] args) {
        StartThread1 startThread1 = new StartThread1();
        startThread1.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("coding the project");
        }
    }
}
