package lab_08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {

    private int getTotalSalary(List<Employee> fulltimeList) {
        int totalSalary = 0;
        for (Employee employee : fulltimeList) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public static void main(String[] args) {
        EmployeeController empController = new EmployeeController();

        int fullTimeEmployeeTotal = empController.getNumOfEmployeeByKeyboard("full time");
        int contractEmployeeTotal = empController.getNumOfEmployeeByKeyboard("contract");

        List<Employee> fulltimeList = empController.createFullTimeEmployee(fullTimeEmployeeTotal);
        List<Employee> contractList = empController.createContractEmployee(contractEmployeeTotal);

        int totalSalaryFulltime = empController.getTotalSalary(fulltimeList);
        int totalSalaryContract = empController.getTotalSalary(contractList);
        int totalSalary = totalSalaryFulltime + totalSalaryContract;

        System.out.println("Total Salary: " + totalSalary);
    }

    public int getNumOfEmployeeByKeyboard(String empType) {
        System.out.printf("Num of %s employee: ", empType);
        Scanner scanner = new Scanner(System.in);
        int numOfEmployee = scanner.nextInt();
        return numOfEmployee;
    }

    public List<Employee> createFullTimeEmployee(int fullTimeEmployeeTotal) {
        List<Employee> empList = new ArrayList<>();

        for (int index = 0; index < fullTimeEmployeeTotal; index++) {
            Employee emp = new FullTimeEmployee();
            empList.add(emp);
        }
        return empList;
    }

    private List<Employee> createContractEmployee(int contractEmployeeTotal) {
        List<Employee> empList = new ArrayList<>();

        for (int index = 0; index < contractEmployeeTotal; index++) {
            Employee emp = new ContractEmployee();
            empList.add(emp);
        }
        return empList;
    }

}
