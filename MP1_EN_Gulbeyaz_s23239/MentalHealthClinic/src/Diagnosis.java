import java.io.Serializable;
import java.util.Date;

public class Diagnosis implements Serializable {
    private int id;
    private String description;
    private Date dateDiagnosed;
    private MentalHealthProfessional diagnosedBy;

    public Diagnosis(int id, String description, Date dateDiagnosed, MentalHealthProfessional diagnosedBy) {
        setId(id);
        setDescription(description);
        setDateDiagnosed(dateDiagnosed);
        setDiagnosedBy(diagnosedBy);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = description;
    }

    public Date getDateDiagnosed() {
        return dateDiagnosed;
    }

    public void setDateDiagnosed(Date dateDiagnosed) {
        if (dateDiagnosed == null) {
            throw new IllegalArgumentException("Date diagnosed cannot be null");
        }
        this.dateDiagnosed = dateDiagnosed;
    }

    public MentalHealthProfessional getDiagnosedBy() {
        return diagnosedBy;
    }

    public void setDiagnosedBy(MentalHealthProfessional diagnosedBy) {
        if (diagnosedBy == null) {
            throw new IllegalArgumentException("Diagnosed by cannot be null");
        }
        this.diagnosedBy = diagnosedBy;
    }
}

