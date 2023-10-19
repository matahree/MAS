package attribute;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String name;
    private String lastName;
    private int age;
    private String address;
    private String phoneNumber;;
    private List<String> medicalHistory;
    private List<String> allergies;
    public Patient( String name, String lastName, int age, String address, String phoneNumber){

        setName(name);
        setLastName(lastName);
        setAge(age);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        this.medicalHistory = new ArrayList<>();
        this.allergies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name can not be null and empty");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("Last name cannot be null and empty!");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }


    // DYNAMIC - it changes
    public void setAge(int age) {
        if(age <= this.age){
            throw new IllegalArgumentException("Age should be increasing.");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120.");
        }
        this.age = age;
    }
    // dynamic
    public void addMedicalCondition(String condition) {
        if (condition == null || condition.isEmpty()) {
            throw new IllegalArgumentException("Condition cannot be null or empty");
        }
        if (medicalHistory.contains(condition) || allergies.contains(condition)) {
            throw new IllegalStateException("Patient already has a history of " + condition);
        }
        medicalHistory.add(condition);
    }


    public void setAllergies(List<String> allergies) {
        if(allergies == null || allergies.isEmpty()){
            throw new IllegalArgumentException("Allergies can not be null and empty.");
        }
        this.allergies = allergies;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address == null || address.isEmpty()){
            throw new IllegalArgumentException("Address can not be null and empty.");
        }
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // TEACHER'S COMMENT: FIRST CHECK IF ITS NULL OR NOT AS WELL.
    // STATIC constraint
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.isEmpty()){
            throw new IllegalArgumentException("Phone Number can not be null and empty!");
        }
        if (phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Phone number should have exactly 10 digits.");
        }
        this.phoneNumber = phoneNumber;
    }



}



//    HERE I USED ARRAY LIST SO IN METHOD I USED STRING ONLY. ITS WRONG. I HAVE TO USE ARRAY LIST NOT ONLY STRING.
//    public void setSocialSecurityNumber(String socialSecurityNumber) {
//        if (extent.contains(socialSecurityNumber)) {
//            throw new IllegalArgumentException("Social Security Number already exists in the class extent");
//        } else {
//            extent.add(this);
//            this.socialSecurityNumber = socialSecurityNumber;
//        }
//    }