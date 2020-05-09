package element.thread.AnotherClass;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author Hanz
 * @date 2019/12/19
 */
public class FirstClassOfThread {

//    public static void main(String... ar) {
//        Thread th = Thread.currentThread();
//        System.out.println("Thread information : " + th);
//        System.out.println("Name of main thread - " + th.getName());
//
//        th.setName("Thread2");    //Setting a new name of the main thread.
//
//        System.out.println("Thread's new information " + th);
//        System.out.println("New name of main thread - " + th.getName());
//
//    }

    //    public static void main(String... ar) {
//        Thread th = Thread.currentThread();
//        System.out.println("Thread information:" + th);
//        System.out.println("Name of the thread - " + th.getName());
//        try {
//            System.out.println("main thread going to sleep for 5 seconds");
//            th.sleep(5000); //Sleep method may throw InterruptedException, hence a try-catch block
//            System.out.println("main thread is awakened and exits");
//        } catch (InterruptedException e) {
//            System.out.println(e);
//        }
//
//    }
//    public static void main(String... ar) throws InterruptedException {
//        Thread newThread = new Thread("Thread2"); //line1
//        Thread newThread2 = new Thread("Thread3"); //line1
//        newThread2.start();
//        newThread.start();             //line2
//        newThread.join();             //line3
//        newThread2.join();
//        System.out.println("sleep begin" + System.currentTimeMillis());
//        newThread2.sleep(3000);
//        newThread.sleep(3000);
//        System.out.println("Hello from main" + System.currentTimeMillis());
//    }


//    public static void main(String... ar)
//    {
//        ThJoin newTh= new ThJoin();
//        ThOJoin newThO= new ThOJoin();
//        Thread th= new Thread(newTh, "OtherThread");//Calling Thread's constructor & passing the object
//        Thread thO= new Thread(newThO, "AnotherThread");//Calling Thread's constructor & passing the object
//        //of class that  implemented  Runnable learnInterface
//        //& the name of new thread.
//        th.start();
//        thO.start();
//
//        try
//        {
//            th.join(); //main thread will wait for other thread to complete its execution and join it.
//
//            System.out.println("Main thread ends");
//        }
//        catch(InterruptedException e)
//        {
//            System.out.println(e);
//        }
//
//
//    }
//
//    static class ThOJoin implements Runnable
//    {
//
//        @Override
//        public void run()  //Entry Point of the new thread.
//        {
//            Thread th=Thread.currentThread(); //Getting the reference to the currently executing thread.
//            try
//            {
//                for(int i=0;i<100;i++)
//                {
//                    Thread.sleep(2000); //This will make this thread sleep for 1000 ms.
//                    System.out.println(i + th.getName());
//                }
//                System.out.println(th.getName() + " completed");
//            }
//            catch(InterruptedException e)
//            {
//                System.out.println("Thread Interrupted" + e);
//            }
//
//        }
//
//
//    }
//
//    static class ThJoin implements Runnable
//    {
//
//        @Override
//        public void run()  //Entry Point of the new thread.
//        {
//            Thread th=Thread.currentThread(); //Getting the reference to the currently executing thread.
//            try
//            {
//                for(int i=0;i<100;i++)
//                {
//                    Thread.sleep(500); //This will make this thread sleep for 1000 ms.
//                    System.out.println(i + th.getName());
//                }
//                System.out.println(th.getName() + " completed");
//            }
//            catch(InterruptedException e)
//            {
//                System.out.println("Thread Interrupted" + e);
//            }
//
//        }
//
//
//    }

}
