package lab_07;

import java.util.ArrayList;
import java.util.List;

public class HumanResources {


    public static void main(String[] args) {

        EmployeeType fullTime = new EmployeeType(EmpType.FULLTIME, 5000);
        EmployeeType contract = new EmployeeType(EmpType.CONTRACT, 4000);

        List<Employee> fulltimeList = recruitEmployee(fullTime, 10);
        List<Employee> contractList = recruitEmployee(contract, 2);
        List<Employee> empList = new ArrayList<>();
        empList.addAll(fulltimeList);
        empList.addAll(contractList);
        int totalSalary = calculateSalary(empList);
        System.out.println("Total Salary: " + totalSalary);
    }

    public static List<Employee> recruitEmployee(EmployeeType employeeType, int numEmployee){
        List<Employee> empList = new ArrayList<>();
        for (int i = 0; i < numEmployee; i++) {
            Employee emp = new Employee(employeeType, "Employee " + (i+1));
            System.out.printf("Employee name: %s - %s\n", emp.getName(), emp.getType().getName() );
            empList.add(emp);
        }
        return empList;
    }

    public static int calculateSalary(List<Employee> empList){
        int totalSalary = 0;
        for (Employee employee : empList) {
            totalSalary += employee.getType().getSalary();
        }
        return totalSalary;
    }
}

