package lab_08;

public class FullTimeEmployee extends Employee{

    public FullTimeEmployee(){
        super.setSalary(5000);
    }

    public FullTimeEmployee(int salary){
        super.setSalary(salary);
    }

}
