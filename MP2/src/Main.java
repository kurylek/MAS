public class Main {
    public static void main(String[] args) throws Exception {

        //Basic Associations
        Person person1 = new Person("Jan");
        Person person2 = new Person("Adam");
        Person person3 = new Person("Anna");

        Phone phone1 = new Phone("ABC123", "Samsung");
        Phone phone2 = new Phone("ABC124", "Samsung", person1);
        Phone phone3 = new Phone("ABC125", "Samsung", person2);
        Phone phone4 = new Phone("CBA123", "Apple");
        Phone phone5 = new Phone("CBA124", "Apple");

        person1.addPhone(phone1);
        phone4.setOwnedBy(person1);

        System.out.println("Basic Associations:");
        System.out.println("Person1: " + person1);
        System.out.println("Person2: " + person2);
        System.out.println("Person3: " + person3);
        System.out.println("~");
        System.out.println("Phone1: " + phone1);
        System.out.println("Phone2: " + phone2);
        System.out.println("Phone3: " + phone3);
        System.out.println("Phone4: " + phone4);
        System.out.println("Phone5: " + phone5 + "\n---");

        System.out.println("\nComposition Associations:");
        Building building1 = new Building("Koszykowa 86");
        Building building2 = new Building("Nowogrodzka 84/86");
        Room roomNull = null;
        Room room1 = Room.createRoom("A/361", building1);
        Room room2 = Room.createRoom("A/362", building1);
        Room room3 = Room.createRoom("P15", building2);
        try {
            roomNull = Room.createRoom("null", null);
        } catch (Exception e) {
            System.out.println("Room (part) with null Building(whole)" + e.getMessage());
        }
        System.out.println(room1);
        System.out.println(room2);
        System.out.println(room3);
        System.out.println("~");
        System.out.println(building1);
        System.out.println(building2 + "\n---");

        System.out.println("\nAssociations with an attribute:");
        AccessKey accessKey1 = new AccessKey(room1);
        AccessKey accessKey2 = new AccessKey(person1, room2);
        AccessKey accessKey3 = new AccessKey(person2, room3);
        AccessKey accessKey4 = new AccessKey(person2, room2);
        accessKey4.setOwnedBy(person1);

        System.out.println(accessKey1);
        System.out.println(accessKey2);
        System.out.println(accessKey3);
        System.out.println(accessKey4);
        System.out.println("~");
        System.out.println(person1.getAccessKeys());
        System.out.println(person2.getAccessKeys());
        System.out.println(person3.getAccessKeys());
        System.out.println("~");
        System.out.println(room1.whoHasAccess());
        System.out.println(room2.whoHasAccess());
        System.out.println(room3.whoHasAccess() + "\n---");

        System.out.println("\nQualified Associations:");
        Computer computer1 = new Computer("22001D");
        computer1.setInRoom(room1);
        Computer computer2 = new Computer("22002D", room1);
        Computer computer3 = new Computer("22003D", room2);
        Computer computer4 = new Computer("22004D");

        System.out.println(computer1);
        System.out.println(computer2);
        System.out.println(computer3);
        System.out.println(computer4);
        System.out.println("~");
        System.out.println("Is 22001D in Room1? " + room1.findComputer("22001D"));
        try {
            System.out.println("Is 22003D in Room1? " + room1.findComputer("22003D"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("~");
        System.out.println("Computers in Room1: " + room1.computerList());
        System.out.println("Computers in Room2: " + room2.computerList());
        System.out.println("Computers in Room3: " + room3.computerList());
    }
}
