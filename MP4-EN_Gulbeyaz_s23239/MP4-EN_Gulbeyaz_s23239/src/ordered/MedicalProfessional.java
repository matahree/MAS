package ordered;

import java.util.*;

public class MedicalProfessional  {
    private String name;
    private int successfulTreatments;
    private int unsuccessfulTreatments;

    private static Set<MedicalProfessional> medicalProfessionals = new HashSet<MedicalProfessional>();

    public MedicalProfessional(String name, int successfulTreatments, int unsuccessfulTreatments) {
        setName(name);
        setSuccessfulTreatments(successfulTreatments);
        setUnsuccessfulTreatments(unsuccessfulTreatments);
        addToExtent();
    }

    private void addToExtent() {
        medicalProfessionals.add(this);
    }

    public static Set<MedicalProfessional> getExtent() {
        return new HashSet<>(medicalProfessionals);
    }


    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        this.name = name;
    }

    public int getSuccessfulTreatments() {
        return successfulTreatments;
    }

    public int getUnsuccessfulTreatments() {
        return unsuccessfulTreatments;
    }

    private void setSuccessfulTreatments(int successfulTreatments) {
        if (successfulTreatments < 0) {
            throw new IllegalArgumentException("Successful treatments cannot be negative");
        }
        this.successfulTreatments = successfulTreatments;
    }

    private void setUnsuccessfulTreatments(int unsuccessfulTreatments) {
        if (unsuccessfulTreatments < 0) {
            throw new IllegalArgumentException("Unsuccessful treatments cannot be negative");
        }
        this.unsuccessfulTreatments = unsuccessfulTreatments;
    }

    public double getSuccessRate() {
        int totalTreatments = successfulTreatments + unsuccessfulTreatments;
        if (totalTreatments == 0) {
            return 0.0;
        }
        return (double) successfulTreatments / totalTreatments;
    }

    //comparator
    public static List<MedicalProfessional> getProfessionalSuccessRates() {
        Set<MedicalProfessional> medicalProfessionals = MedicalProfessional.getExtent();
        List<MedicalProfessional> successRateRanking = new ArrayList<>(medicalProfessionals);
        Collections.sort(successRateRanking, Comparator.comparingDouble(MedicalProfessional::getSuccessRate).reversed());
        return Collections.unmodifiableList(successRateRanking);
    }


    @Override
    public String toString() {
        return getName() + ": Successful Treatments - " + successfulTreatments +
                " Unsuccessful Treatments - " + unsuccessfulTreatments +
                " Success Rate - " + getSuccessRate();
    }
}
