package CreationalPatterns.BuilderPattern;

/**
 * @author Hanz
 * @date 2019/12/12
 */
public class Coke extends ColdDrink {

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 15.0f;
    }
}
