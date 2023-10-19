import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MentalHealthProfessional extends Person implements Serializable {
    private String specialization;
    private List<Diagnosis> diagnosesMade;

    public MentalHealthProfessional(int id, String firstName, String middleName, String lastName, LocalDate dateOfBirth, String specialization) {
        super(id, firstName, middleName, lastName, dateOfBirth);
        setSpecialization(specialization);
        this.diagnosesMade = new ArrayList<>();
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be null or empty");
        }
        this.specialization = specialization;
    }

    public List<Diagnosis> getDiagnosesMade() {
        return new ArrayList<>(diagnosesMade);
    }

    public void addDiagnosis(Diagnosis diagnosis) {
        if (diagnosis == null) {
            throw new IllegalArgumentException("Diagnosis cannot be null");
        }
        if (diagnosesMade.contains(diagnosis)) {
            throw new IllegalStateException("Diagnosis already exists in the list");
        }
        this.diagnosesMade.add(diagnosis);
    }

    public void removeDiagnosis(Diagnosis diagnosis) {
        if (!diagnosesMade.contains(diagnosis)) {
            throw new IllegalStateException("Diagnosis does not exist in the list");
        }
        this.diagnosesMade.remove(diagnosis);
    }
    public String getDescription() {
        return "I am a mental health professional.";
    }
}
