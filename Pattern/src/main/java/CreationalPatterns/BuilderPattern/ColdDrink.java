package CreationalPatterns.BuilderPattern;

/**
 * @author Hanz
 * @date 2019/12/12
 */
public abstract class ColdDrink implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
