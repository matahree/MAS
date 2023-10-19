import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Counselor extends MentalHealthProfessional implements Serializable {

    public Counselor(int id, String firstName, String middleName, String lastName, LocalDate dateOfBirth, String specialization) {
        super(id, firstName, middleName, lastName, dateOfBirth, specialization);
    }

    public String provideGuidance() {
        return "Providing guidance and support for the patient.";
    }
}
