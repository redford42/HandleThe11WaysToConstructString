package CreationalPatterns.FactoryPattern;

/**
 * @author Hanz
 * @date 2019/12/12
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("我画一个圆");
    }
}
