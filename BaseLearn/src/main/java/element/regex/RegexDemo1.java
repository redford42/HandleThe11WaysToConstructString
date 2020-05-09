package element.regex;

/**
 * @author Hanz
 * @date 2020/3/5
 */
public class RegexDemo1 {
    public static void main(String[] args) {
        System.out.println(
                "edit_?volume".matches("^[A-Za-z_]+$")
        );
    }
}
