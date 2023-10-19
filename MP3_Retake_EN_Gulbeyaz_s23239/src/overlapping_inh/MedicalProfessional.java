package overlapping_inh;
import java.util.EnumSet;
import java.util.Collections;

public class MedicalProfessional implements Doctor, Nurse {

    private EnumSet<MedicalProfessionalRole> roles;
    private int id;
    private double salary;
    private String specialization;
    private String shift;

    public MedicalProfessional(int id, double salary, EnumSet<MedicalProfessionalRole> roles,
                               String specialization, String shift) throws Exception {
        setId(id);
        setSalary(salary);
        setRoles(roles);
        if (isDoctor())
            setSpecialization(specialization);
        if (isNurse())
            setShift(shift);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if (id < 0) {
            throw new Exception("Id cannot be negative.");
        }
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws Exception {
        if (salary < 0) {
            throw new Exception("Salary cannot be negative.");
        }
        this.salary = salary;
    }

    public EnumSet<MedicalProfessionalRole> getRoles() {
        return (EnumSet<MedicalProfessionalRole>) Collections.unmodifiableSet(roles);
    }

    private void setRoles(EnumSet<MedicalProfessionalRole> roles) throws Exception {
        if (roles == null || roles.isEmpty()) {
            throw new Exception("Roles of medical professionals cannot be null and empty.");
        }
        this.roles = roles;
    }

    public boolean isDoctor() {
        return this.roles.contains(MedicalProfessionalRole.DOCTOR);
    }

    public boolean isNurse() {
        return this.roles.contains(MedicalProfessionalRole.NURSE);
    }

    @Override
    public String getSpecialization() {
        if (!isDoctor()) {
            throw new IllegalStateException("This parameter is not appropriate for the given role.");
        }
        return specialization;
    }

    @Override
    public void setSpecialization(String specialization) {
        if (!isDoctor()) {
            throw new IllegalStateException("This parameter is not appropriate for the given role.");
        }
        if (specialization == null) {
            throw new IllegalArgumentException("Specialization cannot be null.");
        }
        this.specialization = specialization;
    }

    @Override
    public String getShift() {
        if (!isNurse()) {
            throw new IllegalStateException("This parameter is not appropriate for the given role.");
        }
        return shift;
    }

    @Override
    public void setShift(String shift) {
        if (!isNurse()) {
            throw new IllegalStateException("This parameter is not appropriate for the given role.");
        }
        if (shift == null) {
            throw new IllegalArgumentException("Shift cannot be null.");
        }
        this.shift = shift;
    }
}
