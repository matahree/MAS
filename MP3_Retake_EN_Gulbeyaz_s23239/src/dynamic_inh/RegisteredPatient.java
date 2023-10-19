package dynamic_inh;

public interface RegisteredPatient {
    Integer getPatientId() throws Exception;
    void setPatientId(Integer patientId) throws Exception;
    String getPassword() throws Exception;
    void setPassword(String password) throws Exception;
}