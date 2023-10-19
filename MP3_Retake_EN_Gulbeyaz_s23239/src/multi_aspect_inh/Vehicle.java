package multi_aspect_inh;

public class Vehicle {
    private String manufacturer;
    private String model;

    public Vehicle(String manufacturer, String model) {
        setManufacturer(manufacturer);
        setModel(model);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setManufacturer(String manufacturer) {
        if(manufacturer == null || manufacturer.isEmpty()){
            throw new IllegalArgumentException("Manufacturer can not be null and empty!");
        }
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        if(model == null || model.isEmpty()){
            throw new IllegalArgumentException("Model can not be null and empty!");
        }
        this.model = model;
    }
}