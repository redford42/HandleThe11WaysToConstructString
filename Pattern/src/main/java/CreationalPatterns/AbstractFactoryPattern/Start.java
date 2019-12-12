package CreationalPatterns.AbstractFactoryPattern;

public class Start {
    public static void main(String [] args){
        Temp temp = new Temp();
        One one = new One(temp);
        Tow tow = new Tow(temp);
        Thread thread = new Thread(one);
        Thread thread2 = new Thread(tow);
        thread.setName("一:");
        thread2.setName("二:");
        thread2.start();
        thread.start();

    }

}
