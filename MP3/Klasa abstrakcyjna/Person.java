public abstract class Person {
    private String fName;

    public Person(String fName) {
        this.fName = fName;
    }

    public String getfName() {
        return fName;
    }

    abstract String whoAmI();
}
