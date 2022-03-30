import java.io.*;

public class MainRead {

    public static void main(String[] args) {
        System.out.println("\nInit state:");
        Person.showExtent();
        System.out.println("--");
        Person.showNumberOfPeople();

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream(System.getProperty("user.home")+"\\Documents\\Data")));
            Person.readExtent(inputStream);
            inputStream.close();
            System.out.println("\nData loaded from file: " + System.getProperty("user.home")+"\\Documents\\Data");
        } catch (FileNotFoundException e) {
            System.out.println("\nThere is no file with data (" + System.getProperty("user.home")+"\\Documents\\Data)");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\nData from file:");
        Person.showExtent();
        System.out.println("--");
        Person.showNumberOfPeople();
    }
}
