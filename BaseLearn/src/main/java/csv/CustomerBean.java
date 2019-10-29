package csv;

import java.util.Date;

/**
 * @author Hanz
 * @date 2019/7/29
 */
public class CustomerBean extends PersonBean {
    private String customerNo;
    private long loyaltyPoints;
    private String mailingAddress;

    /**
     * Default Constructor.
     */
    public CustomerBean() {
    }

    public CustomerBean(final String customerNo, final String firstName, final String lastName, final Date birthDate,
                        final String mailingAddress, final Boolean married, final Integer numberOfKids, final String favouriteQuote,
                        final String email, final long loyaltyPoints) {
        super(firstName, lastName, birthDate, married, numberOfKids, favouriteQuote, email);
        this.customerNo = customerNo;
        this.loyaltyPoints = loyaltyPoints;
        this.mailingAddress = mailingAddress;
    }



    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public long getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
