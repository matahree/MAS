package bag;

import java.util.HashSet;
import java.util.Set;

public class Medication {
    private String name;
    private String description;
    private Set<Prescription> prescriptions = new HashSet<>();

    public Medication(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = description;
    }

    public Set<Prescription> getPrescriptions() {
        return new HashSet<>(prescriptions);
    }

    public void addPrescription(Prescription prescription) {
        if (prescription == null) {
            throw new IllegalArgumentException("Prescription cannot be null");
        }

        if (prescriptions.contains(prescription)) {
            throw new IllegalArgumentException("Prescription already exists");
        }

        prescriptions.add(prescription);
        prescription.setMedication(this);
    }

    public void removePrescription(Prescription prescription) {
        if (prescription == null) {
            throw new IllegalArgumentException("Prescription cannot be null");
        }

        if (!prescriptions.contains(prescription)) {
            throw new IllegalArgumentException("Prescription does not exist");
        }

        prescriptions.remove(prescription);
        prescription.setMedication(null);
    }
}
