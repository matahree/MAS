package abstract_inh;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
       setFirstName(firstName);
       setLastName(lastName);
       setDateOfBirth(dateOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("First name can not be null and empty!");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("Last name can not be null and empty!");
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

    public int calculateAgeFromDateOfBirth(LocalDate birthdate) {
        LocalDate currentDate = LocalDate.now();
        Period agePeriod = Period.between(birthdate, currentDate);
        return agePeriod.getYears();
    }


    public abstract String getFullName();
    public abstract String calculateAge();
}
