import java.io.Serializable;
import java.time.LocalDate;


public class Patient extends Person implements Serializable {
    private MedicalHistory medicalHistory;


    public Patient(int id, String firstName, String middleName, String lastName, LocalDate dateOfBirth, MedicalHistory medicalHistory) {
        super(id, firstName, middleName, lastName, dateOfBirth);
        setMedicalHistory(medicalHistory);

    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }



    @Override
    public String toString() {
        return "Patient{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", middleName='" + getMiddleName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", medicalHistory='" + getMedicalHistory() + '\'' +
                '}';
    }
}
