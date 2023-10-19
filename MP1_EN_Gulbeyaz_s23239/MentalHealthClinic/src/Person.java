import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person implements Serializable {
    private static Integer totalPersons = 0;
    private static List<Person> extent = new ArrayList<>();
    private static final String FILENAME = "extent.ser";

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person(int id, String firstName,  String lastName, LocalDate dateOfBirth) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);

        addToExtent();
    }

    public Person(int id, String firstName, String middleName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);

        addToExtent();
    }

    private void addToExtent() {
        extent.add(this);
    }
    // return new ArrayList<>(extent); returns a separate copy of the list,
    // which means that modifications made to the returned list will not affect the original extent.

    public static List<Person> getExtent() {
        return new ArrayList<>(extent);
    }



    public static void saveExtent() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(extent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadExtent() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            extent = (List<Person>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("First name can not be null or empty!");
        }
        this.firstName = firstName;
    }

    public String getMiddleName() {

        return middleName;
    }

    public void setMiddleName(String middleName) {

        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("Last name cannot be null and empty!");
        }
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if(dateOfBirth == null){
            throw new IllegalArgumentException("Date of birth can not be null");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dateOfBirth, currentDate);
        return age.getYears();
    }

    public static void totalPersons(Integer total) {
        if(total == null){
            throw new IllegalArgumentException("Number of total person can not be null");
        }
        if(total < 1){
            throw new IllegalArgumentException("There must be at least one person.");
        }
        totalPersons += total;
    }

    public static List<Person> filterAdults() {
        List<Person> result = new ArrayList<>();
        return extent.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(Collectors.toList());
    }

}
