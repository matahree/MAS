import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Therapist extends MentalHealthProfessional implements Serializable {
    private List<String> therapyType = new ArrayList<>();

    public Therapist(int id, String firstName, String middleName, String lastName, LocalDate dateOfBirth, String specialization, String therapyType ) {
        super(id, firstName, middleName, lastName, dateOfBirth, specialization);
        addTherapyType(therapyType);

    }

    public Therapist(int id, String firstName, String lastName, LocalDate dateOfBirth, String specialization) {
        super(id, firstName, null, lastName, dateOfBirth, specialization);

    }

    // we don't need setting
    public List<String> getTherapyTypes() {
        return Collections.unmodifiableList(therapyType);       // return the copy
    }

    public void addTherapyType(String therapyType){
        if(therapyType == null || therapyType.isEmpty()){
            throw new IllegalArgumentException("Therapy type can not be null or empty.");
        }
        this.therapyType.add(therapyType);
    }

    public void removeTherapyType(String therapyType){
        if(this.therapyType.size() < 2){
            throw new IllegalArgumentException("Can not remove the last therapy type");
        }
        this.therapyType.remove(therapyType);
    }



    @Override
    public String getDescription() {
        return "I am a therapist specialized in " + getSpecialization() + " and I provide the following therapy types: " + getTherapyTypes();
    }

    @Override
    public String toString() {
        return "Therapist{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", middleName='" + getMiddleName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", specialization='" + getSpecialization() + '\'' +
                ", therapyTypes=" + getTherapyTypes() +
                '}';
    }

}
