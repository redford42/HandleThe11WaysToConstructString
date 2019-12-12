package CreationalPatterns.BuilderPattern;

/**
 * @author Hanz
 * @date 2019/12/12
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
