package unique;

import java.util.HashSet;
import java.util.Set;

public class Vehicle {

    private String brand;
    private String model;
    private String registrationNumber;
    private static Set<Vehicle> registrationNumbers = new HashSet<>();

    public Vehicle(String registrationNumber, String brand, String model) {
        setRegistrationNumber(registrationNumber);
        setBrand(brand);
        setModel(model);
        addToExtent();
    }

    private void addToExtent() {
        registrationNumbers.add(this);
    }
    public static Set<Vehicle> getExtent() {
        return new HashSet<>(registrationNumbers);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isBlank()) {
            throw new IllegalArgumentException("Registration number cannot be null or empty.");
        }
        else if (!registrationNumber.matches("[A-Z]{2}[A-Z0-9]{3}[0-9]{7}")) {
            throw new IllegalArgumentException("Attribute is invalid for registration number!");
        }
        else if (isVehicleContains(registrationNumber)) {
            throw new IllegalArgumentException("A vehicle with the same registration number already exists.");
        }
        //registrationNumbers.remove(this);
        this.registrationNumber = registrationNumber;
        //registrationNumbers.add(this);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand == null || brand.isEmpty()){
            throw new IllegalArgumentException("Brand can not be null and empty.");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model == null || model.isEmpty()){
            throw new IllegalArgumentException("Model can not be null and empty.");
        }
        this.model = model;;
    }
    // Check if another vehicle in the class extent has the same registration number
    private boolean isVehicleContains(String registrationNumber) {
        for (Vehicle vehicle : registrationNumbers) {
            if (vehicle != this && vehicle.getRegistrationNumber().equals(registrationNumber)) {
                return true;
            }
        }
        return false;
    }
}
