package dynamic_inh;

public class Patient implements UnregisteredPatient, RegisteredPatient {

    // Base class attributes
    private String firstName;
    private String lastName;
    private PatientType type;
    // Subclass attributes
    private String phoneNumber; // Non-registered patient
    private Integer patientId;  // Registered patient
    private String password;    // Registered patient

    public Patient(String firstName, String lastName, PatientType type, String phoneNumber, Integer patientId, String password) throws Exception {
        setFirstName(firstName);
        setLastName(lastName);
        setType(type);
        if (isRegistered()) {
            setPatientId(patientId);
            setPassword(password);
        } else {
            setPhoneNumber(phoneNumber);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        if (firstName == null || firstName.isEmpty()) {
            throw new Exception("First name can not be null and empty.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        if (lastName == null || lastName.isEmpty()) {
            throw new Exception("Last name can not be null and empty.");
        }
        this.lastName = lastName;
    }

    public PatientType getType() {
        return type;
    }

    private void setType(PatientType type) throws Exception {
        if (type == null) {
            throw new Exception("Type of patient cannot be null");
        }
        this.type = type;
    }

    public boolean isRegistered() {
        return type.equals(PatientType.REGISTERED);
    }

    public void registerPatient(Integer patientId, String password) throws Exception {
        if (isRegistered()) {
            return;
        }
        resetPhoneNumber();
        setType(PatientType.REGISTERED);
        setPatientId(patientId);
        setPassword(password);
    }

    private void resetPhoneNumber() {
        this.phoneNumber = null;
    }

    private void resetAccount() {
        this.patientId = null;
        this.password = null;
    }

    public void unregisterPatient(String phoneNumber) throws Exception {
        if (!isRegistered()) {
            return;
        }
        resetAccount();
        setType(PatientType.UNREGISTERED);
        setPhoneNumber(phoneNumber);
    }
    @Override
    public String getPassword() throws Exception {
        if (!isRegistered()) {
            throw new Exception("This parameter is not appropriate for the patient type.");
        }
        return password;
    }
    @Override
    public void setPassword(String password) throws Exception {
        if (!isRegistered()) {
            throw new Exception("This parameter is not appropriate for the patient type.");
        }
        if (password == null || password.isEmpty()) {
            throw new Exception("Password can not be null and empty.");
        }
        this.password = password;
    }
    @Override
    public Integer getPatientId() throws Exception {
        if (!isRegistered()) {
            throw new Exception("This parameter is not appropriate for the patient type.");
        }
        return patientId;
    }
    @Override
    public void setPatientId(Integer patientId) throws Exception {
        if (!isRegistered()) {
            throw new Exception("This parameter is not appropriate for the patient type.");
        }
        if (patientId < 0) {
            throw new Exception("Validation error for clientId! Id cannot be negative");
        }
        this.patientId = patientId;
    }
    @Override
    public String getPhoneNumber() throws Exception {
        if (isRegistered()) {
            throw new Exception("This parameter is not appropriate for the patient type.");
        }
        return phoneNumber;
    }
    @Override
    public void setPhoneNumber(String phoneNumber) throws Exception {
        if (isRegistered()) {
            throw new Exception("This parameter is not appropriate for the given clientType.");
        }
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new Exception("Phone number cannot be null nor empty.");
        }
        if (!phoneNumber.matches("[0-9]{9}")) {
            throw new Exception("Not a valid phone number.");
        }
        this.phoneNumber = phoneNumber;
    }
}