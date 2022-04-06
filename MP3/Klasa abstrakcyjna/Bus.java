public class Bus {
    public void getInto(Person person) {
        if(person == null){//Can be- null, Driver or Passenger
            System.out.println("Is there anyone here?"); //Exception- given argument is null
            return;
        }
        if(person.getClass() == Driver.class) { //Can be- Driver or Passenger
            System.out.println("Driver " + person.getfName() + " got in!");
            if(((Driver) person).hasLicense())
                System.out.println("\tDon't worry, he has driving license!");
            else
                System.out.println("\tBetter get out! He doesn't have a driving license!");
            return;
        }
        System.out.println("Passenger " + person.getfName() + " got in!");//Is Passenger
        if(((Passenger) person).hasTicket())
            System.out.println("\tIt's honest man with ticket!");
        else
            System.out.println("\tOh look! The brave one without ticket!");
    }
}
