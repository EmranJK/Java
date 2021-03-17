
import java.util.Scanner;
import java.util.ArrayList;




public class Driver {




    private Scanner input = new Scanner(System.in);
    private ArrayList<Employee> employees;
    private EmployeeAPI empAPI;

    public Driver() {
        input = new Scanner(System.in);
        empAPI = new EmployeeAPI();
    }


    public static void main(String[] args) {
        System.out.println("hello");
        Driver app = new Driver();
        app.run();
    }


    private int mainMenu() {
        /**This method returns an integer value that the user types depending on which choice he is looking for.*/

        System.out.println("Company Menu");
        System.out.println("----------------");
        System.out.println("1) Add an employee (Manager)");
        System.out.println("2) Add an employee (Sales worker)");
        System.out.println("3) Add an employee (Admin worker)");
        System.out.println("4) Add an existing employee to a department");
        System.out.println("5) Delete an employee");
        System.out.println("----------------");
        System.out.println("6) Find the total of salaries owed to all employees");
        System.out.println("7) Find the average of salaries owed to all employees");
        System.out.println("8) Print the employee with the highest pay");
        System.out.println("----------------");
        System.out.println("9) List all employees in the company in ascending alphabetical order (first time)");
        System.out.println("10) List all employees in the company in ascending alphabetical order (second time)");
        System.out.println("11) List all employees in the company in ascending order (hourly rate)");
        System.out.println("----------------");
        System.out.println("12) Search the system for an employee by second name");
        System.out.println("13) Search the system for an employee within a given manager's department");
        System.out.println("----------------");
        System.out.println("14) Save to XML");
        System.out.println("15) Load from XML");
        System.out.println("----------------");
        System.out.println("0) Exit");
        System.out.println("==>>");
        int option = input.nextInt();
        input.nextLine();
        return option;
    }


    private void setup()
    {

    }

    private void run() {
        /**This method uses the input form the mainMenu method to execute the appropriate
         method for the choice that has been chosen by the user in the Menu*/


        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1:


                    try {
                        addManager();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 2:


                    try {
                        addSalesWorker();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 3:


                    try {
                        addAdminWorker();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 4:



                    try {
                        addEmpToManager();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 5:


                    try {
                        deleteEmployeeByName();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 6:


                    try {
                        System.out.println(empAPI.totalSalariesOwed());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 7:

                    try {
                        System.out.println(empAPI.averageSalaryOwed());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 8:


                    try {
                        System.out.println(empAPI.employeeWithHighestPay());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 9:


                    try {
                        System.out.println(empAPI.listEmployees());
                        empAPI.sortEmployeesByFirstName();
                        System.out.println(empAPI.listEmployees());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 10:


                    try {
                        System.out.println(empAPI.listEmployees());
                        empAPI.sortEmployeesBySecondName();
                        System.out.println(empAPI.listEmployees());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 11:


                    try {
                        System.out.println(empAPI.listEmployees());
                        empAPI.sortEmployeesByHourlyRate();
                        System.out.println(empAPI.listEmployees());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 12:


                    try {
                        searchBySecondName();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;
                case 13:


                    try {
                        searchByDept();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                    break;

                case 14:

                    try {
                        empAPI.save();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }


                    break;
                case 15:
                    try {
                        empAPI.load();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }


                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

//pause the program
            System.out.println("\nPress any key to continue...");
            input.nextLine(); //for the bug in Scanner
//display the main menu again
            option = mainMenu();
        }
//the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeAPI getEmpAPI() {
        return empAPI;
    }

    public void setEmpAPI(EmployeeAPI empAPI) {
        this.empAPI = empAPI;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "input=" + input +
                ", employees=" + employees +
                ", empAPI=" + empAPI +
                '}';
    }
//SR There is a lot of repetition in the following 3 methods, is there any way that you
    //could only have the employee questions written once, but called by each of the
    // 3 methods

    public void addManager()


    {

        System.out.println("First Name: ");
        String fName = input.next();

        System.out.println("Last Name: ");
        String lName = input.next();

        System.out.println("Email: ");
        String email = input.next();

        System.out.println("Phone: ");
        String phone = input.next();

        System.out.println("PPS Number: ");
        String pps = input.next();

        System.out.println("Hours Worked: ");
        double hW = input.nextDouble();

        System.out.println("Hours Rate: ");
        double hR = input.nextDouble();


        Employee employee = new Manager(fName, lName, email, phone, pps, hW, hR);
        empAPI.addEmployee(employee);
        System.out.println(empAPI.listEmployees());
    }


    public void addSalesWorker()


    {

        System.out.println("First Name: ");
        String fName = input.next();

        System.out.println("Last Name: ");
        String lName = input.next();

        System.out.println("Email: ");
        String email = input.next();

        System.out.println("Phone: ");
        String phone = input.next();

        System.out.println("PPS Number: ");
        String pps = input.next();

        System.out.println("Hours Worked: ");
        double hW = input.nextDouble();

        System.out.println("Hours Rate: ");
        double hR = input.nextDouble();

        System.out.println("Percentage: ");
        double percent = input.nextDouble();


        Employee employee = new SalesWorker(fName, lName, email, phone, pps, hW, hR, percent);
        empAPI.addEmployee(employee);

        System.out.println(empAPI.listEmployees());
    }


    public void addAdminWorker()

    {
        System.out.println("First Name: ");
        String fName = input.next();

        System.out.println("Last Name: ");
        String lName = input.next();

        System.out.println("Email: ");
        String email = input.next();

        System.out.println("Phone: ");
        String phone = input.next();

        System.out.println("PPS Number: ");
        String pps = input.next();

        System.out.println("Hours Worked: ");
        double hW = input.nextDouble();

        System.out.println("Hours Rate: ");
        double hR = input.nextDouble();

        System.out.println("Bonus: ");
        double bonus = input.nextDouble();



        Employee employee = new AdminWorker(fName, lName, email, phone, pps, hW, hR, bonus);
        empAPI.addEmployee(employee);
        System.out.println(empAPI.listEmployees());
    }

    public void addEmpToManager()

    {
        //SR: For this method you need to show the suer the list of employees and ask them to choose the index of
        //the employee you want to add to the department
        //Then show them the list of Managers and ask them to choose the manager
        //you should validate the users reponses
        // then call addEmployeeToDepartment in empAPI



        System.out.println(empAPI.listEmployees());
        System.out.println("enter the index of the employee of  your choice: ");
        int  index = input.nextInt();
        System.out.println(empAPI.listManagerEmployees());
        System.out.println("Enter the manager of your choice: ");
        int index2 = input.nextInt();
        empAPI.addEmployeeToDepartment(index, index2);
    }

    public void deleteEmployeeByName()

    {

        System.out.println("Type the name of the employee you want to delete: ");
        String del = input.next();
        empAPI.removeEmployee(del);
    }

    public void searchBySecondName()

    {
        System.out.println("Type the second name of the employee you are looking for: ");
        String search = input.next();
        System.out.println(empAPI.searchEmployees(search));
    }


    public void searchByDept() {

        System.out.println(empAPI.listManagerEmployees());
        System.out.println("Which manager do you want to see his/her employees: ");
        int index = input.nextInt();
        Manager  theManager = (Manager) empAPI.getEmployees().get(index);
        ArrayList <Employee> employees = theManager.getEmployeeArrayList();
        for (int i = 0; i < employees.size(); i++)
        {
            System.out.println(employees.get(i).toString());
        }



    }
}
