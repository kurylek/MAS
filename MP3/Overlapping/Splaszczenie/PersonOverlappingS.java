import java.util.EnumSet;

enum PersonType {Person, Client, Worker};

public class PersonOverlappingS {
    private EnumSet<PersonType> personKind;
    private String fName;
    private String deliveryAddress;
    private double bonus;

    public PersonOverlappingS(String fName) {
        this.fName = fName;
        this.deliveryAddress = null;
        this.personKind = EnumSet.of(PersonType.Person);
    }

    public void isClient(String deliveryAddress){
        this.personKind.add(PersonType.Client);
        this.deliveryAddress = deliveryAddress;
        System.out.println("Person " + fName + " is our client.");
    }

    public void isWorker(double bonus){
        this.personKind.add(PersonType.Worker);
        this.bonus = bonus;
        System.out.println("Person " + fName + " is our worker.");
    }

    public void buy(){
        if(personKind.contains(PersonType.Client)) {
            System.out.println("I bought something! Deliver it to " + deliveryAddress);
        }else {
            System.out.println("I'm not your client!");
        }
    }

    public void checkMyBonus() {
        if(personKind.contains(PersonType.Worker)) {
            System.out.println("My bonus is - $" + bonus);
        }else {
            System.out.println("I'm not your worker!");
        }
    }
}
