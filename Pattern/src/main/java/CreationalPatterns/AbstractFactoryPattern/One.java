package CreationalPatterns.AbstractFactoryPattern;

public class One implements  Runnable {
    Temp temp;
    public  One(Temp temp){
        this.temp =temp;
    }
    @Override
    public void run() {

            while (temp.temp<=100){
                synchronized (temp){
                    if (!temp.flag){
                        System.out.println(Thread.currentThread().getName()+(temp.temp++));
                        temp.flag=true;
                        temp.notify();


                    }
                    try {
                        temp.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

            }



    }
}
