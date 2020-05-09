package element.collection;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Hanz
 * @date 2020/2/24
 */
public class CollectionTest {
    private static Collection<DataTest> test = new ArrayList<>();
    private static DataTest c1 = new DataTest("abe", 13);
    private static DataTest c2 = new DataTest("red", 46);
    private static DataTest c3 = new DataTest("abe", 13);

    static {
        test.add(c1);
        test.add(c2);
    }


    public static void main(String[] args) {
        learnIterator();
    }

    public static void testList() {
        //remove all 去掉相同的元素
        // retain all 保留相同的元素
    }

    public static void learnIterator() {
        for (Iterator<DataTest> it = test.iterator(); it.hasNext(); ) {
            DataTest dataTest = it.next();
            System.out.println(dataTest.toString());
        }
    }


    public static void testCollection() {
        System.out.println("test" + test.toString());

        test.remove(c3);
        System.out.println("is c1 === c3?" + c1.equals(c3));
        System.out.println("test" + test.toString());
    }

}

@Data
class DataTest {
    String name;
    int age;

    DataTest(String name, int age) {
        this.name = name;
        this.age = age;
    }
}