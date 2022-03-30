import java.util.Date;

public class AccessKey {
    private Date recived;
    private Person ownedBy;
    private Room toRoom;

    public AccessKey(Person ownedBy, Room toRoom) {
        this.recived = new Date();
        this.ownedBy = ownedBy;
        this.toRoom = toRoom;
        ownedBy.addAccessKey(this);
        toRoom.addAccessKey(this);
    }

    public AccessKey(Room toRoom) {
        this.toRoom = toRoom;
        this.ownedBy = null;
        this.recived = null;
        toRoom.addAccessKey(this);
    }

    public void setOwnedBy(Person ownedBy) {
        this.ownedBy.removeAccessKey(this);
        ownedBy.addAccessKey(this);
        toRoom.addAccessKey(this);
        this.ownedBy = ownedBy;
        this.recived = new Date();
    }

    public String toRoom(){
        return toRoom.getNumber();
    }

    public String ownedBy(){
        return ownedBy.getName();
    }

    public boolean isOwned(){
        return ownedBy != null;
    }

    @Override
    public String toString() {
        return "AccessKey: [Owned by- " + (ownedBy != null ? ownedBy.getName() : "No one") + ", To room- " +
                toRoom.getNumber() + ", Recived-  " + (recived != null ? recived : "Not assigned") + "]";
    }
}
