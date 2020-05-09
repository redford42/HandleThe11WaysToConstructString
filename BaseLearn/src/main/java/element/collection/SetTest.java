package element.collection;

import java.util.*;

/**
 * @author Hanz
 * @date 2019/8/7
 */
public class SetTest {

    public static void main(String[] args) {
//        Set<String> deviceIds = new HashSet<>();
//        deviceIds.add("01");
//        deviceIds.add("02");
//
//        int size = deviceIds.size();
//        String[] deviceIdList = new String[size];
//        deviceIds.toArray(deviceIdList);
//        System.out.println("?????我觉得不对吼" + Arrays.toString(deviceIdList));

        Long testNum = 0L;
        test(testNum);
        System.out.println(testNum);

    }


    public static void test(Long num) {
        num = 10L;
    }
//    public static void main(String[] args) {
//        Set<String> words = new HashSet<>();
//        long totalTime = 0;
//
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String word = in.next();
//            long callTime = System.currentTimeMillis();
//            words.add(word);
//            callTime = System.currentTimeMillis() - callTime;
//            totalTime += callTime;
//        }
//
//        Iterator<String> iter = words.iterator();
//        for (int i = 0; iter.hasNext(); i++) {
//            System.out.print(iter.next() + " ");
//        }
//        System.out.println("...");
//        System.out.println(words.size() + "distinct words." + totalTime + "milliseconds.");
//    }

}
