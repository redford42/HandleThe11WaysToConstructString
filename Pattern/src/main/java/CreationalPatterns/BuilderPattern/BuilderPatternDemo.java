package CreationalPatterns.BuilderPattern;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/**
 * @author Hanz
 * @date 2019/12/12
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost() );
        Meal nonVegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Non-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost() );
    }
}
