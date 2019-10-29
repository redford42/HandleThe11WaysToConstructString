package csv;

import java.util.Date;
import java.util.Objects;

/**
 * @author Hanz
 * @date 2019/7/29
 */
public class PersonBean {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Boolean married;
    private Integer numberOfKids;
    private String favouriteQuote;
    private String email;

    public PersonBean() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonBean)) return false;
        PersonBean that = (PersonBean) o;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getBirthDate(), that.getBirthDate()) &&
                Objects.equals(getMarried(), that.getMarried()) &&
                Objects.equals(getNumberOfKids(), that.getNumberOfKids()) &&
                Objects.equals(getFavouriteQuote(), that.getFavouriteQuote()) &&
                Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getBirthDate(), getMarried(), getNumberOfKids(), getFavouriteQuote(), getEmail());
    }

    public PersonBean(String firstName, String lastName, Date birthDate, Boolean married, Integer numberOfKids, String favouriteQuote, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.married = married;
        this.numberOfKids = numberOfKids;
        this.favouriteQuote = favouriteQuote;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", married=" + married +
                ", numberOfKids=" + numberOfKids +
                ", favouriteQuote='" + favouriteQuote + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Integer getNumberOfKids() {
        return numberOfKids;
    }

    public void setNumberOfKids(Integer numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

    public String getFavouriteQuote() {
        return favouriteQuote;
    }

    public void setFavouriteQuote(String favouriteQuote) {
        this.favouriteQuote = favouriteQuote;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
