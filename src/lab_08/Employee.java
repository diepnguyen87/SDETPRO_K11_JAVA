package lab_08;

public class Employee {

    private int ID;
    private int salary;

    public Employee() {
    }

    public Employee(int ID, int salary) {
        this.ID = ID;
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
