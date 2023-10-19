package subset.NEWone;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Patient {

    private String name;
    private String lastName;
    private final Set<MedicalRecord> accessibleMedicalRecords = new HashSet<>();
    private final Set<MedicalRecord> importantMedicalRecords = new HashSet<>();

    public Patient(String name, String lastName) {
        setName(name);
        setLastName(lastName);
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty or null");
        }
        this.lastName = lastName;
    }

    public Set<MedicalRecord> getAccessibleMedicalRecords() {
        return Collections.unmodifiableSet(accessibleMedicalRecords);
    }

    public Set<MedicalRecord> getImportantMedicalRecords() {
        return Collections.unmodifiableSet(importantMedicalRecords);
    }

    public void grantAccessToMedicalRecord(MedicalRecord medicalRecord) {
        if (medicalRecord == null) {
            throw new IllegalArgumentException("Medical record cannot be null");
        }
        if (!accessibleMedicalRecords.contains(medicalRecord)) {
            accessibleMedicalRecords.add(medicalRecord);
            medicalRecord.addAccessedFor(this);
        }
    }

    public void revokeAccessToMedicalRecord(MedicalRecord medicalRecord) {
        if (medicalRecord == null) {
            throw new IllegalArgumentException("Medical record cannot be null");
        }
        if (importantMedicalRecords.contains(medicalRecord)) {
            unmarkAsImportant(medicalRecord);
        }
        if (accessibleMedicalRecords.contains(medicalRecord)) {
            accessibleMedicalRecords.remove(medicalRecord);
            medicalRecord.removeAccessedBy(this);
        }
    }

    public void markAsImportant(MedicalRecord medicalRecord) {
        if (medicalRecord == null) {
            throw new IllegalArgumentException("Medical record cannot be null");
        }
        if (!accessibleMedicalRecords.contains(medicalRecord)) {
            throw new IllegalArgumentException("Cannot mark an inaccessible medical record as important");
        }
        if (!importantMedicalRecords.contains(medicalRecord)) {
            importantMedicalRecords.add(medicalRecord);
            medicalRecord.markAsImportantFor(this);
        }
    }

    public void unmarkAsImportant(MedicalRecord medicalRecord) {
        if (medicalRecord == null) {
            throw new IllegalArgumentException("Medical record cannot be null");
        }
        if (importantMedicalRecords.contains(medicalRecord)) {
            importantMedicalRecords.remove(medicalRecord);
            medicalRecord.unmarkAsImportantFor(this);
        }
    }

}
