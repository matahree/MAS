package composition;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Employee> employees;

    public Company(String name) {
        setName(name);
        employees = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {
        if (employee == null){
            throw new IllegalArgumentException("Employee can not be null");
        }
        if (employees.contains(employee)) {
            throw new IllegalArgumentException("This employee is already hired.");
        }
        employees.add(employee);
        employee.setCompany(this);
    }

    public void fireEmployee(Employee employee) {
        if (!this.employees.contains(employee)) {
            return;
        }
        this.employees.remove(employee);
        employee.setCompany(null);

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
}