public class MainOverlappingS {
    public static void main(String[] args) {
        PersonOverlappingS p1 = new PersonOverlappingS("Jan");
        PersonOverlappingS p2 = new PersonOverlappingS("Janusz");

        System.out.println("~No client & no worker~");
        p1.buy();
        p1.checkMyBonus();


        System.out.println("\n~Client & no worker~");
        p1.isClient("ul. Nosacza 3");
        p1.buy();
        p1.checkMyBonus();

        System.out.println("\n~Client & worker~");
        p1.isWorker(100);
        p1.buy();
        p1.checkMyBonus();

        System.out.println("\n~No client & worker~");
        p2.isWorker(999);
        p2.buy();
        p2.checkMyBonus();

    }

}
