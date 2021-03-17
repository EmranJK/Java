import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EmployeeAPI {

    private ArrayList <Employee> employees = new ArrayList<Employee>();

    public EmployeeAPI()
    { }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    void addEmployee(Employee employee)
    {
        /**
         *  This method adds the Employee employee that the user wants to add to the employees arrayList.
         */

       employees.add(employee);
    }

    public boolean addEmployeeToDepartment(int emp, int man)
    {
        /**
         *  This method checks if the employee man is a Manager.
         *  If yes then it casts this employee to a Manager and then adds to it the employee emp and returns true.
         *  If the employee man is not a Manager then false is returned.
         */

            if (employees.get(man) instanceof Manager)
            {
                ((Manager) employees.get(man)).add(employees.get(emp));
                return true;
            }
            return false;
    }



    public Employee getEmployee(int gEmployee)


    {
        /**
         *  This method checks if the index of the employee required by the user is valid within the arrayList of employees.
         *  If it is then it returns it.
         *  If not then it returns null
         */

        //SR. this isn't the correct validation, you should use the Utilities class
        //see removeEmployee
        if (Utilities.validIndex(gEmployee, employees))
       return employees.get(gEmployee);
        else
            return null;
    }

    public Employee removeEmployee(String rEmployee)

    {
        /**
         *  This method checks if the last name of the employee required by the user is valid.
         *  For each employee, if one of the employees have the same String value as rEmployee which is storing the last name required by the user,
         *  then it will return this last name.
         *  If not then it will return null.
         */

        for (int i=0; i<employees.size(); i++)
        {//SR Can't use == for strings
           if (employees.get(i).getLastName().equals(rEmployee))
               employees.remove(i);
        }

        return null;
    }

    public Employee removeEmployee(int rEmployee2)
    {

        /**
         *   This method checks if the the index of the employee that the user wants to remove is valid within the arrayList of employees.
         *   If yes then it removes whatever employee that has this index.
         *   If no then it returns null.
         */

        if (Utilities.validIndex(rEmployee2, employees))
           return employees.remove(rEmployee2);
        else
            return null;
    }

    public int numberOfEmployees()
    {
        /**
         *  This method returns the number of employees in the arrayList of employees
         */

        return employees.size();
    }

    public String listEmployees()
    {

        /**
         *  This method initialise a variable of type String called employeeDetail and give it a value of an empty String.
         *  Then it checks if the arrayList of employees is not empty.
         *  If yes then it generates a for loop.
         *  In the for loop, i is an int that has the value of 0 but it keeps increasing by 1 every time it ascends through the elements of employees arrayList.
         *  The i is the used get every employee in the employees arrayList by their indexes.
         *  All of the employees listed are stored in the empty String of employeeDetail.
         *  Once this is done, employeeDetail is returned and it contains all the employees of the arrayList of employees.
         *  If the arrayList of employees is empty then "No employees stored" statement is returned.
         */

        String employeeDetail = "";
        if (!employees.isEmpty()) {

            for (int i = 0; i < employees.size(); i++){
                employeeDetail += i+ ": " + employees.get(i).toString() + "\n";
            }
        return employeeDetail;
    }
        else
            return "No employees stored";
    }



    /**//**/  public String listManagerEmployees(Manager manager)
    {

        /**
         *  This method initialise an arrayList of employees called emps and it gives it a value of manager.getEmployeeArrayList().
         *  Then it initialise an empty String called employeeDetail.
         *  After that it checks if the arrayList of emps is not empty.
         *  If yes then it generates af for loop similar to the one in listEmployees method to list all the employees inside the arrayList of emps.
         *  After that all the listed employees are added to the empty String of employeeDetail.
         *  Once this is done, employeeDetail is returned and it contains all the employees of the arrayList of emps.
         *  If the arrayList of emps is empty then "No Employees" statement is returned.
         */

            ArrayList<Employee> emps = manager.getEmployeeArrayList();
        String employeeDetail = "";
        if (!emps.isEmpty()) {
            for (int i = 0; i < emps.size(); i++) {
                employeeDetail += i + ": " + emps.get(i).toString() + "\n";
            }
                return employeeDetail;
            }

        else
            return "No Employees";

    }

    public String listManagerEmployees()
    {
        /**
         *  This method initialise an empty String called employeeDetail.
         *  After that it checks if the employees of arrayList is not empty.
         *  If yes then it generates af for loop similar to the one in listEmployees method to list all the employees inside the arrayList of employees.
         *  For each employee, if there are employees of type Manager then they will be stored in the empty String of employeeDetail.
         *  Once this is done, employeeDetail is returned and it contains all the employees of type Manager of the arrayList of employees.
         *  If the arrayList of employees is empty then "No employees stored" statement is returned.
         */

        String employeeDetail = "";
        if (!employees.isEmpty()) {

            for (int i = 0; i < employees.size(); i++){
                if (employees.get(i) instanceof Manager)
                employeeDetail += i + ": " + employees.get(i).toString() + "\n";
            }
            return employeeDetail;
        }
        else
            return "No employees stored";



    }

  /**//**/  public ArrayList<Employee> searchEmployees(String search)
    {

        /**
         *  This method initialise an arrayList of type Employee called lastName as a new arrayList.
         *  Then it checks if the size of the arrayList of employees is bigger than 0 "Not empty".
         *  If yes then it generates af for loop similar to the one in listEmployees method to list all the employees inside the arrayList of employees.
         *  Then it checks each employee to see if there are any employee in the employees arrayList that has the same last name that the user is looking for.
         *  If it finds any employees that have the same last name as the last name that is required by the user then it will add this employee to the lastName arrayList.
         *  After the process is done, lastName arrayList is returned.
         *  If the arrayList of employees is empty then null is returned.
         */

        ArrayList<Employee>lastName = new ArrayList<Employee>();
        if (employees.size() > 0) {
            for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getLastName().equalsIgnoreCase(search)) {
               lastName.add(employees.get(i));


            }

            }

            return lastName;
        }
        return null;
    }

 /*1*/   public double totalSalariesOwed()
    {
        /**
         *  This method initialise a double with value of 0 called sal.
         *  Then it checks if the size of the arrayList of employees is bigger than 0 "Not empty".
         *  If yes then it generates af for loop similar to the one in listEmployees method to list all the employees inside the arrayList of employees.
         *  The double "sal" takes the value of the salary of the first employee, then the salary of the second employee is added to it, then the salary of the third etc...
         *  Once all the salaries are added up in sal then sal is returned.
         */

        double sal = 0;
        if (employees.size() > 0)
        for (int i = 0; i < employees.size(); i++)
        {
           sal += employees.get(i).getSalary();
        }
        return sal;
    }

  /*1*/  public double averageSalaryOwed() {

      /**
       *  This method initialise a double with value of 0 called sal.
       *  Then it checks if the size of the arrayList of employees is bigger than 0 "Not empty".
       *  If yes then it generates af for loop similar to the one in listEmployees method to list all the employees inside the arrayList of employees.
       *  The double "sal" takes the value of the salary of the first employee, then the salary of the second employee is added to it, then the salary of the third etc...
       *  Once all the salaries are added up in sal then sal divided by the number of salaries is returned.
       */


      double sal = 0;

      if (!employees.isEmpty()) {
          for (int i = 0; i < employees.size(); i++) {
              sal += employees.get(i).getSalary();
          }

          return sal / employees.size();
      }
        return 0;
  }



  /**//**/  public void sortEmployeesByFirstName()
    {

        /**
         *  This method generates af for loop similar to the one in listEmployees method to list all the employees inside the arrayList of employees.
         *  Then it generates another for loop inside the previous one which lists all the employees starting from the second one,
         *  as long as it is less than employees.size -i it increase by one each time it ascends.
         *  After that it compares the previous employee's first name to the current employees's first name,
         *  it also checks if the difference between the two is bigger than 0.
         *  If yes then it declares two variables of type Employee called swapJ and swapI.
         *  swap J holds the value of the current employee and swapI holds the value of the previous employee.
         *  After that a new value is set for the current employee which is the value of swapI.
         *  Also a new value is set for the previous employee which is the value of swapJ (i.e. previous and current employees switch values).
         */

        {
            for (int i = 0; i < employees.size(); i++)
                for (int j = 1; j < employees.size()-i; j++) {
                    if (employees.get(j-1).getFirstName().compareTo(employees.get(j).getFirstName()) > 0) {
                        Employee swapJ = employees.get(j);
                        Employee swapI = employees.get(j-1);
                        employees.set(j, swapI);
                        employees.set(j-1, swapJ);
                    }
                }
        }
    }



  /**//**/  public void sortEmployeesBySecondName()
    {

        /**
         *  This method generates af for loop similar to the one in listEmployees method to list all the employees inside the arrayList of employees.
         *  Then it generates another for loop inside the previous one which lists all the employees starting from the second one,
         *  as long as it is less than employees.size -i it increase by one each time it ascends.
         *  After that it compares the previous employee's second name to the current employees's second name,
         *  it also checks if the difference between the two is bigger than 0.
         *  If yes then it declares two variables of type Employee called swapJ and swapI.
         *  swap J holds the value of the current employee and swapI holds the value of the previous employee.
         *  After that a new value is set for the current employee which is the value of swapI.
         *  Also a new value is set for the previous employee which is the value of swapJ (i.e. previous and current employees switch values).
         */

        {
            for (int i = 0; i < employees.size(); i++)
                for (int j = 1; j < employees.size()-i; j++) {
                    if (employees.get(j-1).getLastName().compareTo(employees.get(j).getLastName()) > 0) {
                        Employee swapJ = employees.get(j);
                        Employee swapI = employees.get(j-1);
                        employees.set(j, swapI);
                        employees.set(j-1, swapJ);
                    }
                }
        }
    }

  /*  public void sortEmployeesByHourlyRate()
    {

        for (int i = 0; i < employees.size(); i++)
            for (int j = i+1; j < employees.size(); j++) {
                if (employees.get(i).getHourRate() > employees.get(j).getHourRate()) {
                    Employee swapJ = employees.get(j);
                    Employee swapI = employees.get(i);

                    Employee swap = swapI;
                    swapI = swapJ;
                    swapJ = swap;
                }
            }
    }*/


    public void sortEmployeesByHourlyRate()
    {

        /**
         *  This method generates af for loop similar to the one in listEmployees method to list all the employees inside the arrayList of employees.
         *  Then it generates another for loop inside the previous one which lists all the employees starting from the second one,
         *  as long as it is less than employees.size -i it increase by one each time it ascends.
         *  Then it checks if the previous employee's hourRate is bigger than the current employee's hourRate.
         *  If yes then it declares two variables of type Employee called swapJ and swapI.
         *  swap J holds the value of the current employee and swapI holds the value of the previous employee.
         *  After that a new value is set for the current employee which is the value of swapI.
         *  Also a new value is set for the previous employee which is the value of swapJ (i.e. previous and current employees switch values).
         */

        for (int i = 0; i < employees.size(); i++)
            for (int j = 1; j < employees.size()-i; j++) {
                if (employees.get(j-1).getHourRate() > employees.get(j).getHourRate()) {
                    Employee swapJ = employees.get(j);
                    Employee swapI = employees.get(j-1);
                    employees.set(j, swapI);
                    employees.set(j-1, swapJ);
                }
            }
    }

    /*1*/  public Employee employeeWithHighestPay()
    {
        /**
         *  This method sorts the employees by salary and returns the last employee in the arrayList after it was sorted by salary.
         *  This is because the last employee in this sorted list is the employee with the highest salary.
         */

     //  sortEmployeesByHourlyRate();
     //  return employees.get(employees.size()-1);

        /*
        double biggest = 0;
        if (!employees.isEmpty())
            for (int i = 0; i < employees.size(); i++)
                if (employees.get(i).getSalary() > biggest)
                    biggest = employees.get(i).getSalary();
                else
                    biggest = biggest;
            return employees.get()

         */

      /*989*/  for (int i = 0; i < employees.size(); i++)
            for (int j = 1; j < employees.size()-i; j++) {
                if (employees.get(j-1).getSalary() > employees.get(j).getSalary()) {
                    Employee swapJ = employees.get(j);
                    Employee swapI = employees.get(j-1);
                    employees.set(j, swapI);
                    employees.set(j-1, swapJ);
                }
            }
        return employees.get(employees.size()-1);


    }

  /*1*/  private void swapEmployees(ArrayList<Employee> employeeArrayList, int emp1, int emp2)
    {
        /**
         *  This method checks if the parameters emp1 and emp2 are valid indexes in the employeeArrayList arrayList.
         *  If yes then it initialise two employees, swap1 and swap 2.
         *  swap1 takes the value of employeeArrayList.get(emp1) and swap2 takes the value of employeeArrayList.get(emp2).
         *  After that another employee called swap is initialised and it takes the value of swap1.
         *  Then swap1 takes the value of swap2 and swap2 takes the value of swap which is the old value of swap1.
         *  This causes swap1 and swap2 to switch values.
         */

        if (Utilities.validIndex(emp1, employeeArrayList) && Utilities.validIndex(emp2, employeeArrayList))
        {
            Employee swap1 = employeeArrayList.get(emp1);
            Employee swap2 = employeeArrayList.get(emp2);

           Employee swap = swap1;
            swap1 = swap2;
            swap2 = swap;
        }
    }



    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("employees.xml"));
        employees = (ArrayList<Employee>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("employees.xml"));
        out.writeObject(employees);
        out.close();
    }
}
