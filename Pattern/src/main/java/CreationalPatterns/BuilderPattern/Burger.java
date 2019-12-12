package CreationalPatterns.BuilderPattern;

/**
 * @author Hanz
 * @date 2019/12/12
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
