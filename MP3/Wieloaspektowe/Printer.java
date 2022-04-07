public class Printer extends Device {

    public Printer(String serialNumber) {
        super(serialNumber);
    }

    @Override
    void doMyThing() {
        System.out.println("Printing!");
    }
}
