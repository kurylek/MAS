public class MainKlasaAbstr {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Driver d1 = new Driver("Jan", true);
        Driver d2 = new Driver("Leon", false);
        Passenger p1 = new Passenger("Franciszek", true);
        Passenger p2 = new Passenger("Adam", false);

        bus.getInto(null);
        bus.getInto(d1);
        bus.getInto(d2);
        bus.getInto(p1);
        bus.getInto(p2);
    }
}
