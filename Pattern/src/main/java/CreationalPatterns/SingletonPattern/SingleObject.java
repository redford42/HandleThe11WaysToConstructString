package CreationalPatterns.SingletonPattern;

/**
 * @author Hanz
 * @date 2019/12/12
 */
public class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject(){}

    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello Abe.");
    }
}
