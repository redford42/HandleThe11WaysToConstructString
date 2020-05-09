package element.collection;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Hanz
 * @date 2020/2/24
 */
public class CollectionTest {
    public static void main(String[] args) {

    }

    public static void testList () {
        //remove all 去掉相同的元素
        // retain all 保留相同的元素
    }

    public static void testCollection () {
        Collection<DataTest> test = new ArrayList<>();
        DataTest c1 = new DataTest("abe", 13);
        DataTest c2 = new DataTest("red", 46);
        test.add(c1);
        test.add(c2);
        System.out.println("test" + test.toString());
        DataTest c3 = new DataTest("abe", 13);
        ;
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