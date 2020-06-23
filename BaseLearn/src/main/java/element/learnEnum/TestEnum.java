package element.learnEnum;

/**
 * @author Hanz
 * @date 2020/6/12
 */
public class TestEnum {
    public static void main(String[] args) {
        try {
            KeyTest keyTest = KeyTest.valueOf("first".toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("执行到这里return了");
            return;
        }
        KeyTest keyTest = KeyTest.valueOf("first".toUpperCase());
        System.out.println(keyTest.getSecurityCode());
    }
}
