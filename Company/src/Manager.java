import java.util.ArrayList;

public class Manager extends Employee {

private ArrayList <Employee> employeeArrayList;

    public Manager(String firstName, String lastName, String email,
                   String phoneNum, String ppsNum, double hoursWorked, double hourRate) {
        super(firstName, lastName, email, phoneNum, ppsNum, hoursWorked, hourRate);

        this.employeeArrayList = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }

    @Override
    public double calculateSalary() {

        double bonus = 0;
        for (int i = 0; i < employeeArrayList.size(); i++) {
           bonus += employeeArrayList.get(i).calculateSalary() / 100.00;

        }
        return getSalary() + bonus;
    }


    //Method 1

    void add(Employee employee)
    {
        employeeArrayList.add(employee);
    }
    //Method 2
    boolean remove(int num)
    {
        if (Utilities.validIndex(num, employeeArrayList)) {
            employeeArrayList.remove(num);
            return true;
        }
        else
            return false;
    }
    //Method 3

    int employeesNum()
        {
          return employeeArrayList.size();
        }
}
