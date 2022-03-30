public class Phone {

    private final String serialNumber;
    private final String brand;
    private Person ownedBy;

    public Phone(String serialNumber, String brand) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.ownedBy = null;
    }

    public Phone(String serialNumber, String brand, Person ownedBy) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        setOwnedBy(ownedBy);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public Person getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Person person) {
        if(this.ownedBy != person){
            this.ownedBy = person;
            person.addPhone(this); //reverse connection
        }
    }

    @Override
    public String toString() {
        return "Phone: [Brand-" + brand + ", S/N- " + serialNumber + ", Owned by- " + (ownedBy != null ? ownedBy.getName() : "No one") + "]";
    }
}
