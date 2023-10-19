package multi_inheritance;

import java.time.LocalDate;

public class Therapist extends MentalHealthProfessional {

    private String therapyType;

    public Therapist(String certificationNumber, LocalDate certificationDate, String therapyType) {
        super(certificationNumber, certificationDate);
        setTherapyType(therapyType);
    }

    public String getTherapyType() {
        return therapyType;
    }

    public void setTherapyType(String therapyType) {
        if(therapyType == null || therapyType.isEmpty()){
            throw new IllegalArgumentException("Therapy type can not be null and empty!");
        }
        this.therapyType = therapyType;
    }


}
