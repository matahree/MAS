import java.io.Serializable;
import java.time.LocalDate;


public class Psychiatrist extends MentalHealthProfessional implements Serializable {

    public Psychiatrist(int id, String firstName, String middleName, String lastName, LocalDate dateOfBirth, String specialization) {
        super(id, firstName, middleName, lastName, dateOfBirth, specialization);
    }

    @Override
    public String toString() {
        return "Psychiatrist{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", middleName='" + getMiddleName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", specialization='" + getSpecialization() + '\'' +
                '}';
    }
}
