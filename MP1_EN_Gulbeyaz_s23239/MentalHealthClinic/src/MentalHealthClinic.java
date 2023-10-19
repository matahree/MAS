//import java.sql.Time;
//import java.util.*;
//import java.util.Collections;
//
//public class MentalHealthClinic {
////    private List<Patient> patients;
////    private List<MentalHealthProfessional> professionals;
////    private List<Appointment> appointments;
////    private List<Room> rooms;
////
////    public MentalHealthClinic() {
////        this.patients = new ArrayList<>();
////        this.professionals = new ArrayList<>();
////        this.appointments = new ArrayList<>();
////        this.rooms = new ArrayList<>();
////    }
////
////
////    public void addPatient(Patient patient) {
////        if (patient != null) {
////            patients.add(patient);
////        }
////    }
////
////    public void removePatient(Patient patient) {
////        patients.remove(patient);
////    }
////
////    public void addProfessional(MentalHealthProfessional professional) {
////        if (professional != null) {
////            professionals.add(professional);
////        }
////    }
////
////    public void removeProfessional(MentalHealthProfessional professional) {
////        professionals.remove(professional);
////    }
////
////    public void addAppointment(Appointment appointment) {
////        if (appointment != null) {
////            appointments.add(appointment);
////        }
////    }
////
////    public void removeAppointment(Appointment appointment) {
////        appointments.remove(appointment);
////    }
////
////    public void addRoom(Room room) {
////        if (room != null) {
////            rooms.add(room);
////        }
////    }
////
////    public void removeRoom(Room room) {
////        rooms.remove(room);
////    }
//
//
//    public static void main(String[] args) {
//        MentalHealthClinic clinic = new MentalHealthClinic();
////          classExtentTest(clinic);
////          classExtentPersistenceTest();
////          complexAttributeTest(clinic);
////          optionalAttributeTest(clinic);
////          mandatoryAttributeTest(clinic);
////          multiValueAttributeTest(clinic);
////          classAttributeTest();
////          derivedAttributeTest();
////          classMethodsTest();
////          methodOverridingTest(clinic);
////          methodConstructorOverloadingTest(clinic);
//    }
//
//    public static void classExtentTest(MentalHealthClinic clinic) {
//
////        System.out.println("Testing class extent...");
////
////        // Creating a Patient
////        int patientId = 1;
////        String firstName = "John";
////        String middleName = "Michael";
////        String lastName = "Doe";
////        Date dateOfBirth = new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime();
////        MedicalHistory medicalHistory = new MedicalHistory(patientId, "");
////        Patient patient = new Patient(patientId, firstName, middleName, lastName, dateOfBirth, medicalHistory);
////
////        // Creating a Therapist
////        int therapistId = 1;
////        String therapistFirstName = "Jane";
////        String therapistMiddleName = "Alex";
////        String therapistLastName = "Smith";
////        Date therapistDateOfBirth = new GregorianCalendar(1985, Calendar.FEBRUARY, 10).getTime();
////        String specialization = "Psychotherapy";
////        List<String> therapyTypes = new ArrayList<>();
////        therapyTypes.add("CBT"); // Adding a therapy type
////        Therapist therapist = new Therapist(therapistId, therapistFirstName,therapistMiddleName, therapistLastName, therapistDateOfBirth, specialization, therapyTypes);
////
////        // Creating an Appointment
////        int appointmentId = 1;
////        Time startTime = Time.valueOf("10:00:00");
////        Time endTime = Time.valueOf("11:00:00");
////        Date startDate = new GregorianCalendar(2023, Calendar.APRIL, 5).getTime();
////        Date endDate = startDate;
////        String status = "Scheduled";
////        Appointment appointment = new Appointment(appointmentId, startTime, endTime, startDate, endDate, status, patient, therapist);
////
////        // Adding the Patient, Therapist, and Appointment to the clinic
////        clinic.addPatient(patient);
////        clinic.addProfessional(therapist);
////        clinic.addAppointment(appointment);
////
////        // Displaying the created objects to verify the class extent, optional and mandatory attributes, complex attributes
////        System.out.println("Patient: " + patient);
////        System.out.println("Therapist: " + therapist);
////        System.out.println("Appointment: " + appointment);
////    }
//
//
////
////    public static void classExtentPersistenceTest() {
////        System.out.println("Testing class extend persistence...");
////
////        // Create some objects
////        Patient patient1 = new Patient(1, "John", "A.", "Doe", new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime(), new MedicalHistory(1, "Depression"));
////        Patient patient2 = new Patient(2, "Jane", "B.", "Smith", new GregorianCalendar(1985, Calendar.FEBRUARY, 10).getTime(), new MedicalHistory(2, "Anxiety"));
////
////        ArrayList<Patient> patients = new ArrayList<>();
////        patients.add(patient1);
////        patients.add(patient2);
////
////
////
////        // Print the loaded extent
////        System.out.println("Loaded extent: " + loadedPatients);
////    }
//
//
////    public static void complexAttributeTest(MentalHealthClinic clinic) {
////        System.out.println("Testing complex attribute...");
////
////        // Create a patient
////        Date patientDateOfBirth = new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime();
////        String patientFirstName = "Alice";
////        String patientMiddleName = "M.";
////        String patientLastName = "Johnson";
////        int patientId = 2;
////
////        // Create a medical history for the patient
////        String medicalCondition = "Anxiety";
////        MedicalHistory medicalHistory = new MedicalHistory(patientId, medicalCondition);
////
////        // Create a patient with the medical history
////        Patient patient = new Patient(patientId, patientFirstName, patientMiddleName, patientLastName, patientDateOfBirth, medicalHistory);
////
////        // Add the patient to the clinic
////        clinic.addPatient(patient);
////
////        System.out.println("Patient: " + patient);
////        System.out.println("Medical history: " + patient.getMedicalHistory());
////    }
//
////
////    public List<Patient> getPatients() {
////        return patients;
////    }
////
////
////    public static void optionalAttributeTest(MentalHealthClinic clinic) {
////        System.out.println("Testing optional attribute...");
////
////        // Patient with middle name
////        int patientId1 = 1;
////        String patientFirstName1 = "John";
////        String patientMiddleName1 = "A.";
////        String patientLastName1 = "Doe";
////        Date patientDateOfBirth1 = new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime();
////        MedicalHistory medicalHistory1 = new MedicalHistory(patientId1, "Depression");
////        Patient patient1 = new Patient(patientId1, patientFirstName1, patientMiddleName1, patientLastName1, patientDateOfBirth1, medicalHistory1);
////
////        // Patient without middle name
////        int patientId2 = 2;
////        String patientFirstName2 = "Jane";
////        String patientLastName2 = "Smith";
////        Date patientDateOfBirth2 = new GregorianCalendar(1985, Calendar.FEBRUARY, 10).getTime();
////        MedicalHistory medicalHistory2 = new MedicalHistory(patientId2, "Anxiety");
////        Patient patient2 = new Patient(patientId2, patientFirstName2, null, patientLastName2, patientDateOfBirth2, medicalHistory2);
////
////        clinic.addPatient(patient1);
////        clinic.addPatient(patient2);
////
////        System.out.println("Patient with middle name: " + patient1);
////        System.out.println("Patient without middle name: " + patient2);
////    }
////
////    public static void mandatoryAttributeTest(MentalHealthClinic clinic) {
////        System.out.println("Testing mandatory attributes...");
////
////        try {
////            // Attempt to create a patient without a first name
////            Patient patient = new Patient(1, null, "A.", "Doe", new Date(), new MedicalHistory(1, "Depression"));
////            System.out.println("Created a patient without a first name: " + patient);
////        } catch (IllegalArgumentException e) {
////            System.out.println("Error: Cannot create a patient without a first name");
////        }
////    }
////
////
////    public static void multiValueAttributeTest(MentalHealthClinic clinic) {
////        System.out.println("Testing multi-value attribute...");
////
////        // Create a therapist with multiple therapy types
////        int therapistId = 1;
////        String therapistFirstName = "John";
////        String therapistMiddleName = "A.";
////        String therapistLastName = "Doe";
////        Date therapistDateOfBirth = new Date();
////        String specialization = "Psychotherapy";
////        List<String> therapyTypes = Arrays.asList("CBT", "DBT", "EMDR");
////
////        Therapist therapist = new Therapist(therapistId, therapistFirstName, therapistMiddleName, therapistLastName, therapistDateOfBirth, specialization, therapyTypes);
////        System.out.println("Therapist with multiple therapy types: " + therapist);
////        System.out.println("Therapy types: " + therapist.getTherapyTypes());
////    }
////
////
////
////    public static void classAttributeTest() {
////        System.out.println("Testing class attribute...");
////
////        Therapist therapist1 = new Therapist(1, "John","A.", "Doe", new Date(), "Psychology", Arrays.asList("CBT", "Psychotherapy"));
////        Therapist therapist2 = new Therapist(2, "Jane","B.", "Smith", new Date(), "Psychology", Arrays.asList("CBT", "Psychotherapy"));
////        MedicalHistory medicalHistory1 = new MedicalHistory(1, "Depression");
////        Patient patient1 = new Patient(1, "Alice", "Johnson","Smith", new Date(), medicalHistory1);
////
////        therapist1.conductTherapySession(patient1);
////        therapist1.conductTherapySession(patient1);
////        therapist2.conductTherapySession(patient1);
////
////        System.out.println("Total therapy sessions conducted: " + Therapist.getTotalTherapySessions());
////        System.out.println("Therapist 1 therapy sessions conducted: " + therapist1.getTherapySessionsConducted());
////        System.out.println("Therapist 2 therapy sessions conducted: " + therapist2.getTherapySessionsConducted());
////    }
////
////    public static void derivedAttributeTest() {
////        System.out.println("Testing derived attributes...");
////
////        Patient patient1 = new Patient(1, "John", "A.", "Doe", new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime(), new MedicalHistory(1, "Depression"));
////        Patient patient2 = new Patient(2, "Jane", "B.", "Smith", new GregorianCalendar(1985, Calendar.FEBRUARY, 10).getTime(), new MedicalHistory(2, "Anxiety"));
////
////        System.out.println("Patient 1 age: " + patient1.getAge());
////        System.out.println("Patient 2 age: " + patient2.getAge());
////    }
////
////
////
////    public static void classMethodsTest() {
////        System.out.println("Testing class methods...");
////
////        Therapist therapist1 = new Therapist(1, "John", "A.", "Doe", new GregorianCalendar(1980, Calendar.MARCH, 1).getTime(), "Psychotherapy", Arrays.asList("CBT", "DBT"));
////        Therapist therapist2 = new Therapist(2, "Jane", "B.", "Smith", new GregorianCalendar(1985, Calendar.FEBRUARY, 10).getTime(), "Psychiatry", Arrays.asList("CBT"));
////
////        int therapistCount = Therapist.countTherapists();
////        System.out.println("Total number of therapists: " + therapistCount);
////    }
//
//
//    // In this test, I createD a MentalHealthProfessional and a Therapist with the same information,
//    // but when calling the getDescription method, the output will be different because the Therapist class overrides the getDescription method.
//    // its showing how the same method can have different behavior in the subclass.
//
////    public static void methodOverridingTest(MentalHealthClinic clinic) {
////        System.out.println("Testing method overriding...");
////
////        MentalHealthProfessional mhp = new MentalHealthProfessional(1, "John", "A.", "Doe", new GregorianCalendar(1980, Calendar.JANUARY, 1).getTime(), "Psychotherapy");
////        Therapist therapist1 = new Therapist(1, "John", "A.", "Doe", new GregorianCalendar(1980, Calendar.JANUARY, 1).getTime(), "Psychotherapy", Arrays.asList("CBT", "DBT"));
////
////        System.out.println("MentalHealthProfessional description: " + mhp.getDescription());
////        System.out.println("Therapist description: " + therapist1.getDescription());
////    }
//
////    public static void methodConstructorOverloadingTest(MentalHealthClinic clinic) {
////        System.out.println("Testing constructor overloading...");
////
////        Therapist therapist1 = new Therapist(1, "John", "A.", "Doe", new GregorianCalendar(1980, Calendar.JANUARY, 1).getTime(), "Psychotherapy", Arrays.asList("CBT", "DBT"));
////        Therapist therapist2 = new Therapist(2, "Jane", "Smith", new GregorianCalendar(1985, Calendar.FEBRUARY, 10).getTime(), "Psychiatry");
////
////        System.out.println("Therapist with middle name and therapy types: " + therapist1);
////        System.out.println("Therapist without middle name and therapy types: " + therapist2);
////    }
////
////}
