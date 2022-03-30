import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Year;
import java.util.*;

public class Person implements Serializable {
    //Extent of Person class
    private static List<Person> personExtent = new ArrayList<>();

    //Class attribute
    private static int numberOfPeople = 0;

    private String fName;

    //Complex attribute
    private ContactDetails contactDetails;

    //Optional attribute
    private String sName;

    //Multi-value attribute
    private List<Person> know;

    //Derived attribute
    private int age;

    public Person(String fName, String sName,String email, String phoneNumber, int yearOfBirth) {
        this.fName = fName;
        this.sName = sName;
        this.contactDetails = new ContactDetails(email, phoneNumber);
        this.age = Year.now().getValue() - yearOfBirth;
        this.know = new ArrayList<>();

        addPerson(this); //Add class to extent
    }

    public int getAge() {
        return age;
    }

    public String getKnow() {
        if (know.size() == 0)
            return " No one";
        String knowString = "";
        for (Person p : know)
            knowString += " " + p.fName; //just first name for simplicity
        return knowString;
    }

    public void addKnow(Person p){ //no reverse connection for simplicity
        this.know.add(p);
    }

    // Method overloading
    public void addKnow(Person p1, Person p2){ //no reverse connection for simplicity
        this.know.add(p1);
        this.know.add(p2);
    }

    //Method overriding
    @Override
    public String toString() {
        return this.getClass().getName() + ": " + fName + (sName != null ? " "+sName : "") +
                ", (" + contactDetails + "), Know:" + getKnow();
    }

    private static void addPerson(Person personToAdd){
        personExtent.add(personToAdd);
        numberOfPeople++;
    }

    public static void removePerson(Person personToRemove){
        personExtent.remove(personToRemove);
        numberOfPeople--;
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + Person.class.getName());

        for (Person p : personExtent){
            System.out.println(p);
        }
    }

    //Class method
    public static void showNumberOfPeople(){
        System.out.println("There are/is " + numberOfPeople + " people in class " + Person.class.getName());
    }

    //Class extent- persistence write
    public static void writeExtent (ObjectOutputStream stream) throws IOException {
        stream.writeObject(personExtent);
    }

    //Class extent- persistence read
    public static void readExtent (ObjectInputStream stream) throws IOException, ClassNotFoundException {
        personExtent = (ArrayList<Person>) stream.readObject();
        numberOfPeople = personExtent.size();
    }
}
