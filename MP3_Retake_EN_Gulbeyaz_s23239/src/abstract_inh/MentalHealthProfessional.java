package abstract_inh;

import java.time.LocalDate;

public class MentalHealthProfessional extends Person {
    private String certification;

    public MentalHealthProfessional(String firstName, String lastName, LocalDate dateOfBirth, String certification) {
        super(firstName, lastName, dateOfBirth);
        setCertification(certification);
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        if(certification == null || certification.isEmpty()){
            throw new IllegalArgumentException("Certification can not be null and empty!");
        }
        this.certification = certification;
    }

    @Override
    public String getFullName() {
        String firstName = getFirstName();
        String lastName = getLastName();
        return "Mental Health Professional: " + firstName + " " + lastName;
    }

    @Override
    public String calculateAge() {
        LocalDate birthdate = getDateOfBirth();
        int age = calculateAgeFromDateOfBirth(birthdate);
        return "Professional experience: " + (age - 10) + " years";
    }
}
