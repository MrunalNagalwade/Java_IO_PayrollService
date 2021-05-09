package inputoutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService
    {
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }
    private List<EmployeePayrollData> employeePayrollList;
    public EmployeePayrollService()
    {

    }
    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList)
    {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData>employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmpployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
    }

    private void readEmpployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee ID");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee name");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id,name,salary));
    }
    void writeEmployeePayrollData(IOService ioService)
    {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("\n Writing Employee Payroll Roaster to Console \n" + employeePayrollList);
        else  if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOServices().writeData(employeePayrollList);
    }
}
