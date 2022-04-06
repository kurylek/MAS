public class Passenger extends Person {
    private boolean hasTicket;

    public Passenger(String fName, boolean hasTicket) {
        super(fName);
        this.hasTicket = hasTicket;
    }

    public boolean hasTicket() {
        return hasTicket;
    }

    @Override
    String whoAmI() {
        return "I'm Passenger";
    }
}
