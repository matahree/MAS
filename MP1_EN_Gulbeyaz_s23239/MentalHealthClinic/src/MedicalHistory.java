import java.io.Serializable;

public class MedicalHistory implements Serializable {
    private int id;
    private String notes;
    private String allergies;
    private String chronicConditions;

    public MedicalHistory(int id, String notes, String allergies, String chronicConditions) {
        setId(id);
        setNotes(notes);
        setAllergies(allergies);
        setChronicConditions(chronicConditions);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        if(notes == null || notes.isEmpty()){
            throw new IllegalArgumentException("Note can not be null and empty");
        }
        this.notes = notes;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        if(allergies == null || allergies.isEmpty()){
            throw new IllegalArgumentException("Allergies can not be null and empty");
        }
        this.allergies = allergies;
    }

    public String getChronicConditions() {
        return chronicConditions;
    }

    public void setChronicConditions(String chronicConditions) {
        if(chronicConditions == null || chronicConditions.isEmpty()){
            throw new IllegalArgumentException("Chronic conditions can not be null and empty");
        }
        this.chronicConditions = chronicConditions;
    }

    @Override
    public String toString() {
        return "MedicalHistory{id=" + id + ", notes='" + notes + "'}";
    }
}