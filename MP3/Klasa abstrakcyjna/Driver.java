public class Driver extends Person {
    private boolean hasLicense;

    public Driver(String fName, boolean hasLicense) {
        super(fName);
        this.hasLicense = hasLicense;
    }

    public boolean hasLicense() {
        return hasLicense;
    }

    @Override
    String whoAmI() {
        return "I'm driver!";
    }
}
