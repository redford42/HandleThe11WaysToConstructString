package CreationalPatterns.FactoryPattern;

/**
 * @author Hanz
 * @date 2019/12/12
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if ("circle".equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else if ("trangle".equalsIgnoreCase(shapeType)) {
            return new Trangle();
        } else if ("square".equalsIgnoreCase(shapeType)) {
            return new Square();
        }
        return null;
    }
}
