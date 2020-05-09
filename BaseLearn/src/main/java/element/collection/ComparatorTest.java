package element.collection;

import java.util.Scanner;

/**
 * @author Hanz
 * @date 2019/8/16
 */
public class ComparatorTest {
    public static void main(String[] args) {

        boolean finish = false;
        while (!finish) {
            // print menu
            System.out.println("NEXT!");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n) {
                case 0:
                    finish = true;
                    break;
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
            }
        }
    }
}
