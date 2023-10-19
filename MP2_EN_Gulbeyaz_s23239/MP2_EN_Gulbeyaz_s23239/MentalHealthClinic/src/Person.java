import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private static Integer totalPersons = 0;

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;


    public Person(int id, String firstName,  String lastName, LocalDate dateOfBirth) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id <0){
            throw new IllegalArgumentException("id can not be negative");
         }
        this.id = id;
    }
    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("First name can not be null or empty!");
        }
        this.firstName = firstName;
    }

    public String getMiddleName() {

        return middleName;
    }

    public void setMiddleName(String middleName) {
        if(middleName == null){
            throw new IllegalArgumentException("Middle name can not be null");
        }
        this.middleName = middleName;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if(dateOfBirth == null){
            throw new IllegalArgumentException("Date of birth can not be null");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dateOfBirth, currentDate);
        return age.getYears();
    }

    public static void totalPersons(Integer total) {
        if(total == null){
            throw new IllegalArgumentException("Number of total person can not be null");
        }
        if(total < 1){
            throw new IllegalArgumentException("There must be at least one person.");
        }
        totalPersons += total;
    }

    public void setPatients(MedicalHistory medicalHistory) {
        if(medicalHistory == null){
            throw new IllegalArgumentException("It can not be null.");
        }
    }
}
