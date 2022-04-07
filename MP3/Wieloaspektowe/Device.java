public abstract class Device {
    private String serialNumber;
    private String cableType;
    private String ipAdress;

    public Device(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setIpAdress(String ipAdress){
        this.ipAdress = ipAdress;
    }

    public void setCableType(String cableType){
        this.cableType = cableType;
    }
    public void connectToMe(){
        if(cableType != null){
            System.out.println("Connect to me by using cable: " + cableType);
        }
        if(ipAdress != null){
            System.out.println("Connect to me by my ip adress: " + ipAdress);
        }
    }

    abstract void doMyThing();
}
