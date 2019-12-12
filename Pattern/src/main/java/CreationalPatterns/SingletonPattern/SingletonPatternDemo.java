package CreationalPatterns.SingletonPattern;

/**
 * @author Hanz
 * @date 2019/12/12
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();

        object.showMessage();
    }
}
