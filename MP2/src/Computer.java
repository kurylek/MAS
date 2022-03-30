public class Computer {
    private String domainName;
    private Room inRoom;

    public Computer(String domainName) {
        this.domainName = domainName;
        this.inRoom = null;
    }

    public Computer(String domainName, Room inRoom) {
        this.domainName = domainName;
        this.inRoom = inRoom;
        inRoom.addComputer(this);
    }

    public void setInRoom(Room room){
        if(inRoom != room){
            inRoom = room;
            room.addComputer(this);
        }
    }

    public String getDomainName() {
        return domainName;
    }

    @Override
    public String toString() {
        return "Computer: [Domain name- " + domainName + ", Room- " + (inRoom!= null ? inRoom.getNumber() : "Not assigned") + "]";
    }
}
