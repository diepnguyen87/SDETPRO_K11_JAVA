package lab_07;

enum EmpType {
    FULLTIME,
    CONTRACT
}

public class EmployeeType {

    private String name;
    private int salary;

    public EmployeeType() {

    }

    public EmployeeType(EmpType empType, int salary) {
        this.name = empType.name();
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int empSalary) {
        this.salary = empSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
