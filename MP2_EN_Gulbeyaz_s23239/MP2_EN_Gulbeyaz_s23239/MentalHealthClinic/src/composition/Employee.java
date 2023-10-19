package composition;

public class Employee {
    private String name;
    private Company company;
    private int age;

    public Employee(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setCompany(Company company) {
        if (this.company != null) {
            throw new IllegalStateException("This employee already belongs to a company.");
        }
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name can not be null and empty");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        if(age<0){
            throw new IllegalArgumentException("Age can not be negative!");
        }
        this.age = age;
    }
}