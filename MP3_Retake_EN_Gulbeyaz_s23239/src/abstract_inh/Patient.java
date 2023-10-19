package abstract_inh;

import java.time.LocalDate;

public class Patient extends Person{
    private String medicalHistory;
    private int patientId;

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, String medicalHistory,int patientId) {
        super(firstName, lastName, dateOfBirth);
        setMedicalHistory(medicalHistory);
        setPatientId(patientId);
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        if(medicalHistory == null || medicalHistory.isEmpty()){
            throw new IllegalArgumentException("Medical history can not be null and empty!");
        }
        this.medicalHistory = medicalHistory;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        if(patientId < 0){
            throw new IllegalArgumentException("Patient Id can not be negative!");
        }
        this.patientId = patientId;
    }

    @Override
    public String getFullName() {
        String firstName = getFirstName();
        String lastName = getLastName();
        return "Patient: " + lastName + ", " + firstName + " (ID: " + getPatientId() + ")";
    }

    @Override
    public String calculateAge() {
        LocalDate birthdate = getDateOfBirth();
        int age = calculateAgeFromDateOfBirth(birthdate);
        return "Patient age: " + age;
    }
}
