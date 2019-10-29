package element.stream;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Hanz
 * @date 2018/12/27
 */
public class Stream {
    @Test
    public void streamMap() {
        List<Integer> number = Arrays.asList(3, 2, 2, 3, 7, 4, 9);
        //获取对应的平方数
        List<Integer> squaresList = number.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);
    }

    @Test
    public void streamFilter() {
        List<String> strings = Arrays.asList("red", "abe", "", "nate", "hanz", "");
        long count = strings.stream().filter(String::isEmpty).count();

        System.out.println("吱吱吱=====================>" + count);
    }

    @Test
    public void streamLimit() {
        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println);
    }

    @Test
    public void streamSorted() {
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    @Test
    public void parallelStream() {
        List<String> strings = Arrays.asList("red", "abe", "", "", "nate", "ford");
        long count = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println("知了知了=======================>" + count);
    }

    @Test
    public void streamCollectors() {
        List<String> strings = Arrays.asList("red", "abe", "", "", "nate", "ford");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表" + filtered);

        String margedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
        System.out.println("知了知了==========================>" + margedString);
    }

    /**
     * 统计结果的收集器
     * 主要用于 int double long等基本类型
     */
    @Test
    public void streamStatistics() {
        List<Integer> numbers = Arrays.asList(3,2,4,7,8,9,14);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("lets get max ： " + stats.getMax());
        System.out.println("lets get min ： " + stats.getMin());
        System.out.println("lets get sum ： " + stats.getSum());
        System.out.println("lets get Avg ： " + stats.getAverage());
        System.out.println("lets get Count ： " + stats.getCount());
    }

    @Test
    public void countListMapByProperty() {
        Map user1 = Maps.newHashMap();
        user1.put("id", 1);
        user1.put("pass", "qsy");
        user1.put("name", "qsy");
        user1.put("age",14);
        Map user2 = Maps.newHashMap();
        user2.put("id", 2);
        user2.put("pass", "123");
        user2.put("name", "abe");
        user2.put("age",17);
        Map user3 = Maps.newHashMap();
        user3.put("id", 3);
        user3.put("pass", "123");
        user3.put("name", "red");
        user3.put("age",16);
        List<Map> countList = Arrays.asList(user1, user2, user3);
        String gProperty = "name";
        String cProperty = "age";

        Map result = countList.stream()
                .collect(Collectors.groupingBy(map -> map.get(gProperty),
                        Collectors.summarizingInt(map -> (int)map.get(cProperty))));

        System.out.println(result.get("red"));
    }

}
