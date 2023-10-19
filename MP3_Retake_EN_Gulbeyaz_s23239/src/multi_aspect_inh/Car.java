package multi_aspect_inh;

public class Car extends Vehicle implements OwnedVehicle {
    private String ownerName;

    public Car(String manufacturer, String model, String ownerName) {
        super(manufacturer, model);
        setOwnerName(ownerName);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if(ownerName == null || ownerName.isEmpty()){
            throw new IllegalArgumentException("Owner name can not be null and empty!");
        }
        this.ownerName = ownerName;
    }


}