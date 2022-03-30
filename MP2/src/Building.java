import java.util.ArrayList;
import java.util.List;

public class Building { //Whole
    private String address;
    private List<Room> rooms;

    public Building(String address) {
        this.address = address;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        if(!rooms.contains(room))
            rooms.add(room);
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        String res = "Building: [Address- " + address + ", Rooms-";

        for(Room r : rooms)
            res += " "+r.getNumber();

        res += "]";
        return res;
    }
}
