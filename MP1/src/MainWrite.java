import java.io.*;

public class MainWrite {

    public static void main(String[] args) {
        Person p1 = new Person("Jan", null, "jan.kowalski@wp.pl", "123-456-789", 1990);
        Person p2 = new Person("Adam", "Nowak", "anowak@onet.pl", "987-654-321" , 1991);
        Person p3 = new Person("Anna", "Nowak", "anowak2@onet.pl", "098-765-432", 1992);
        Person p4 = new Person("Jan", "Anonim", "ja@o2.pl", "111-222-333", 1993);
        p2.addKnow(p3, p4);
        p3.addKnow(p2);
        p4.addKnow(p2);
        System.out.println("p1 age = " +p1.getAge());

        System.out.println("Init state:");
        Person.showExtent();
        System.out.println("--");
        Person.showNumberOfPeople();

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream(System.getProperty("user.home")+"\\Documents\\Data")));
            Person.writeExtent(outputStream);
            outputStream.close();
            System.out.println("\nData saved to file: " + System.getProperty("user.home")+"\\Documents\\Data");
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("\nRemove 1 person:");
        Person.removePerson(p1);
        Person.showExtent();
        System.out.println("--");
        Person.showNumberOfPeople();
    }
}
