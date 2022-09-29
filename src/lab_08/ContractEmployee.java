package lab_08;

public class ContractEmployee extends Employee {

    public ContractEmployee(){
        super.setSalary(4000);
    }

    public ContractEmployee(int salary){
        super.setSalary(salary);
    }

}
