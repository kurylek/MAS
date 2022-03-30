import java.util.*;

public class Room { //Part
    private String number;
    private Building building;
    private List<AccessKey> accessKeys;
    private Map<String, Computer> computers = new TreeMap<>();

    private Room(String number, Building building) {
        this.number= number;
        this.building = building;
        this.accessKeys = new ArrayList<>();
    }

    public static Room createRoom(String number, Building building) throws Exception {
        if(building == null)
            throw new Exception("Given building do not exist!");

        Room room = new Room(number,building);

        building.addRoom(room);

        return room;
    }

    public String getNumber() {
        return number;
    }

    public void addAccessKey(AccessKey accessKey){
        if(!accessKeys.contains(accessKey)){
            accessKeys.add(accessKey);
        }
    }

    public String whoHasAccess(){
        String res = "These people have access to this room: ";
        Set<String > access = new HashSet<>();
        for(AccessKey ak : accessKeys){
            if(ak.isOwned()) //AccessKey can be owned by no one
                access.add(ak.ownedBy());
        }
        return res+(access.toString().replaceAll("\\[|\\]",""));
    }

    public void addComputer(Computer computer){
        if(!computers.containsKey(computer.getDomainName())){
            computers.put(computer.getDomainName(), computer);

            computer.setInRoom(this);
        }
    }

    public Computer findComputer(String domainName) throws Exception{
        if(!computers.containsKey(domainName)){
            throw new Exception("This computer is not in this room!");
        }
        return computers.get(domainName);
    }

    public String computerList(){
        return computers.keySet().toString().replaceAll("\\[|\\]","");
    }

    @Override
    public String toString() {
        return "Room: [Number- " + number + ", Is part of building- " + building.getAddress() + "]";
    }
}
