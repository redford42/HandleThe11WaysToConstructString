package CreationalPatterns.FactoryPattern;

/**
 * @author Hanz
 * @date 2019/12/12
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRcle");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("trangLe");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("SquAre");
        shape3.draw();
    }
}
