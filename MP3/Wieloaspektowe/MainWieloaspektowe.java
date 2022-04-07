public class MainWieloaspektowe {
    public static void main(String[] args) {
        Printer p = new Printer("ABC");
        p.setIpAdress("123");
        p.connectToMe();
        p.doMyThing();

        Scaner s = new Scaner("123");
        s.setCableType("USB-B");
        s.connectToMe();
        s.doMyThing();
    }
}
