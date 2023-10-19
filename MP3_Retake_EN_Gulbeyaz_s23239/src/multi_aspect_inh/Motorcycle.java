package multi_aspect_inh;

public class Motorcycle extends Vehicle implements RentedVehicle {
    private String renterName;


    public Motorcycle(String manufacturer, String model, String renterName) {
        super(manufacturer, model);
        setRenterName(renterName);
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        if(renterName == null || renterName.isEmpty()){
            throw new IllegalArgumentException("Renter name can not be null and empty!");
        }
        this.renterName = renterName;
    }


}
