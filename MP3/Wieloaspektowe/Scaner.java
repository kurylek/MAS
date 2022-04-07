public class Scaner extends Device {

    public Scaner(String serialNumber) {
        super(serialNumber);
    }

    @Override
    void doMyThing() {
        System.out.println("Scanning!");
    }
}
