package element.learnEnum;

/**
 * @author Hanz
 * @date 2020/6/12
 */
public enum KeyTest {
    FIRST_TEST("e_admin.admin"),
    SECOND_TEST("e_admin.admin");

    private final String securityCode;

    KeyTest(String securityCode) {
        this.securityCode = securityCode;
    }


    public String getSecurityCode() {
        return securityCode;
    }
}
