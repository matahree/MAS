import java.io.Serializable;
import java.util.*;

public class MedicalHistory implements Serializable {

    private String notes;
    private String allergies;
    private String chronicConditions;

    // QUALIFIER
    // it should be same type as patient Integer
    private Map<Integer, Patient> patients = new HashMap<>();

    public MedicalHistory(String notes, String allergies, String chronicConditions) {

        setNotes(notes);
        setAllergies(allergies);
        setChronicConditions(chronicConditions);
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

    public Map<Integer, Patient> getPatients() {
        return Collections.unmodifiableMap(patients);
    }

    public void setPatients(Map<Integer, Patient> patients) {
        if (patients == null) {
            throw new IllegalArgumentException("Patients map cannot be null.");
        }
        this.patients = patients;
    }

    public List<Patient> getPatientList(){
        return new ArrayList<>(patients.values());
    }

    public Patient findPatient(Integer patientId) {
        if (patientId == null) {
            throw new IllegalArgumentException("Patient ID cannot be null.");
        }
        return patients.get(patientId);
    }

    public void addPerson(Person p){
        if(p == null){
            throw new IllegalArgumentException("Person can not be null");
        }
        if(patients.containsKey(p.getId())){
            return;
        }
        patients.put(p.getId(), (Patient) p);
        p.setPatients(this);
    }
    public void removePerson(Person p){
        if(!patients.containsKey(p.getId())){
            return;
        }
        patients.remove(p.getId());
        p.setPatients(null);
    }
}