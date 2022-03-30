import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {
    private String name;
    private List<Phone> ownedPhones;
    private List<AccessKey> accessKeys;

    public Person(String name) {
        this.name = name;
        this.ownedPhones = new ArrayList<>();
        this.accessKeys = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getOwnedPhones() {
        if(ownedPhones.size() == 0)
            return " None";
        else{
            String res = "";

            for(Phone p : ownedPhones)
                res += " "+p.getSerialNumber();

            return res;
        }
    }

    public void addPhone(Phone phone) {
        //Check if already exist
        if(!ownedPhones.contains(phone)){
            ownedPhones.add(phone);
            phone.setOwnedBy(this); //reverse connection
        }
    }

    public void addAccessKey(AccessKey accessKey){
        if(!accessKeys.contains(accessKey)){
            accessKeys.add(accessKey);
        }
    }

    public void removeAccessKey(AccessKey accessKey){
        if(accessKeys.contains(accessKey)){
            accessKeys.remove(accessKey);
        }
    }

    public String getAccessKeys(){
        String res = "This person has access to rooms: ";
        Set<String > access = new HashSet<>();
        for(AccessKey ak : accessKeys){
            access.add(ak.toRoom());
        }
        return res+(access.toString().replaceAll("\\[|\\]",""));
    }

    @Override
    public String toString() {
        return "Person: [Name-" + name + ", Phones-" + getOwnedPhones() + "]";
    }
}
