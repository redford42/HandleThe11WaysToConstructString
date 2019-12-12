package CreationalPatterns.AbstractFactoryPattern;

public class Tow implements  Runnable {
     Temp temp;
public  Tow(Temp temp){
    this.temp =temp;
}
    @Override
    public void run() {

            while (temp.temp<=100){
                synchronized (temp){
                    if (temp.flag){

                        System.out.println(Thread.currentThread().getName()+(temp.temp++));
                        temp.flag=false;
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
