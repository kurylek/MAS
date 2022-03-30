import java.io.Serializable;

public class ContactDetails implements Serializable {
    private String email;
    private String phoneNumber;

    public ContactDetails(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Email- " + email + " Phone number- " + phoneNumber;
    }
}
