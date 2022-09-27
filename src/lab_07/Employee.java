package lab_07;

public class Employee {

    private static int ID;
    private String empCode;
    private String name;
    private EmployeeType type;

    public Employee() {
    }

    public Employee(EmployeeType type, String name) {
        generateEmployeeID();
        this.type = type;
        this.name = name;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public String generateEmployeeID(){
        ++ID;
        empCode = String.valueOf(ID);
        int idLength = empCode.length();
        int loop = 1;
        int maxDigitsEmpID = 5;
        while (loop <= maxDigitsEmpID - idLength){
            empCode = "0" + empCode;
            ++loop;
        }
        empCode = "E" + empCode;
        return empCode;
    }

}
