package CreationalPatterns.BuilderPattern;

/**
 * @author Hanz
 * @date 2019/12/12
 */
public class Bottle implements Packing{

    @Override
    public String pack() {
        return "Bottle";
    }
}
