import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;


public class EmployeeAPITest {

    AdminWorker empNormal1, empTestValidation, empNormal3, empNormal4, empNormal5, empNormal6;
    Manager empNormal2;
    EmployeeAPI api;

    @Before
    public void setUp() throws Exception {
        empNormal1 = new AdminWorker("Jack", "Collins", "Jack@gmail.com", "0726752377","6187861a",20,10,5);
        empNormal2 = new Manager("Jack", "notCollin", "Jack@gmail.com", "0726752377","6187861a",20,10);
        empNormal3 = new AdminWorker("Sack", "Rollins", "Jack@gmail.com", "0726752377","6187861a",30,5,15);
        empNormal4 = new AdminWorker("Lack", "Freeman", "Jack@gmail.com", "0726752377","6187861a",10,7,13);
        empNormal5 = new AdminWorker("Pack", "Smith", "Jack@gmail.com", "0726752377","6187861a",17,9,7);
        empNormal6 = new AdminWorker("Pack", "Smith", "Jack@gmail.com", "0726752377","6187861a",35,8,7);

        empTestValidation = new AdminWorker("Johnqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", "Smithqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", "Johngmail.com","0771225455a","633",-1,5,0);
        api = new EmployeeAPI();
    }

    @Test
    public void testGettersSetters() {
        assertEquals(20, empNormal1.getHoursWorked(), 0.01);
        empNormal1.setHoursWorked(40);
        assertEquals(40, empNormal1.getHoursWorked(), 0.01);
        empNormal1.setHoursWorked(-1);
        assertEquals(40, empNormal1.getHoursWorked(), 0.01);
        empNormal1.setHourRate(40);
        assertEquals(40, empNormal1.getHourRate(), 0.01);
        empNormal1.setHourRate(9.79);
        //ensure no change when invalid data used
        assertEquals(40, empNormal1.getHourRate(), 0.01);
        empNormal1.setPpsNum("573");
        assertEquals("6187861a", empNormal1.getPpsNum());
        empNormal1.setFirstName("Jackuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        assertEquals("Jack", empNormal1.getFirstName());
        empNormal1.setLastName("Collinsyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        assertEquals("Collins", empNormal1.getLastName());
        empNormal1.setEmail("Jackgmail.com");
        assertEquals("Jack@gmail.com", empNormal1.getEmail());
        empNormal1.setPhoneNum("0726752377asd");
        assertEquals("0726752377", empNormal1.getPhoneNum());
        empNormal1.setBonus(-5);
        assertEquals(5,empNormal1.getBonus(),0.1);

    }

    @Test
    public void testConstructor() {
        /*989*/    assertEquals("Jack", empNormal1.getFirstName());
        /*989*/   assertEquals("Collins", empNormal1.getLastName());
        /*989*/   assertEquals("Jack@gmail.com", empNormal1.getEmail());
        /*989*/  assertEquals("0726752377",empNormal1.getPhoneNum());
        assertEquals(20, empNormal1.getHoursWorked(), 0.01);
        assertEquals(10, empNormal1.getHourRate(), 0.01);
        /*989*/  assertEquals("6187861a", empNormal1.getPpsNum());
        /*989*/  assertEquals(5, empNormal1.getBonus(), 0.01);

        ////////////////////////////////////////////////////////

        /*989*/  assertEquals(empTestValidation.getFirstName().substring(0,30),empTestValidation.getFirstName());
        /*989*/ assertEquals(empTestValidation.getLastName().substring(0,30),empTestValidation.getLastName());
        /*989*/  assertEquals("Invalid",empTestValidation.getEmail());
        /*989*/ assertEquals("Invalid",empTestValidation.getPhoneNum());
        assertEquals(0, empTestValidation.getHoursWorked(), 0.01);
        assertEquals(9.80, empTestValidation.getHourRate(), 0.01);
        /*989*/  assertEquals("Invalid", empTestValidation.getPpsNum());
        /*989*/  assertEquals(0,empTestValidation.getBonus(), 0.01);

    }

    @Test
    public void addEmployee() {
      assertEquals(0 , api.getEmployees().size());
       api.addEmployee(empNormal1);
       assertEquals(1, api.getEmployees().size());
    }

    @Test
    public void addEmployeeToDepartment() {
        empNormal2.add(empNormal1);
        assertEquals(1, empNormal2.getEmployeeArrayList().size());
    }

    @Test
    public void getEmployee() {
        assertNull(api.getEmployee(10));
        api.addEmployee(empNormal1);
        assertNotNull(api.getEmployee(0));
    }

    @Test
    public void removeEmployee() {
        api.addEmployee(empNormal1);
        assertEquals(1 , api.getEmployees().size());
        api.removeEmployee("notCollins");
        assertEquals(1, api.getEmployees().size());
        api.removeEmployee("Collins");
        assertEquals(0, api.getEmployees().size());
    }

    @Test
    public void testRemoveEmployee() {
        api.addEmployee(empNormal1);
        assertEquals(1 , api.getEmployees().size());
        api.removeEmployee(0);
        assertEquals(0, api.getEmployees().size());
    }

    @Test
  /*989*/  public void numberOfEmployees() {
        assertEquals(0,api.getEmployees().size());
        api.addEmployee(empNormal1);
        assertEquals(1,api.getEmployees().size());
    }

    @Test
    /*989*/  public void listEmployees() {
        assertEquals("No employees stored", api.listEmployees());
        api.addEmployee(empNormal1);
        assertEquals("0: " + empNormal1.toString() + "\n", api.listEmployees());
    }

    @Test
    /*989*/    public void listManagerEmployees() {
        assertEquals("No employees stored", api.listManagerEmployees());
        api.addEmployee(empNormal1);
        api.addEmployee(empNormal2);
        assertEquals("1: " + empNormal2.toString() + "\n", api.listManagerEmployees());
    }

    @Test
    /*989*/    public void testListManagerEmployees() {
        assertEquals("No Employees", api.listManagerEmployees(empNormal2));
        empNormal2.add(empNormal1);
        assertEquals("0: " + empNormal1.toString() + "\n",api.listManagerEmployees(empNormal2));
    }

    @Test
    /*989*/  public void searchEmployees() {
        assertEquals(null, api.searchEmployees(empNormal1.getLastName()));
        api.addEmployee(empNormal1);
        api.addEmployee(empNormal2);
        assertEquals("[" + empNormal1 +  "]", api.searchEmployees(empNormal1.getLastName()).toString());
    }

    @Test
    /*989*/  public void totalSalariesOwed() {
        assertEquals(0, api.totalSalariesOwed(), 0.1);
        api.addEmployee(empNormal1);
        api.addEmployee(empNormal2);
        assertEquals(400, api.totalSalariesOwed(), 0.1);
    }

    @Test
    /*989*/  public void averageSalaryOwed() {
        assertEquals(0, api.averageSalaryOwed(), 0.1);
        api.addEmployee(empNormal1);
        api.addEmployee(empNormal2);

        assertEquals(200, api.averageSalaryOwed(), 0.1);
    }

    @Test
    /*989*/    public void sortEmployeesByFirstName() {
        api.addEmployee(empNormal1); //1. Jack
        api.addEmployee(empNormal3); //4. Sack
        api.addEmployee(empNormal4); //2. Lack
        api.addEmployee(empNormal5); //3. Pack
        api.sortEmployeesByFirstName();
        assertEquals(empNormal1, api.getEmployee(0));
        assertEquals(empNormal4, api.getEmployee(1));
        assertEquals(empNormal5, api.getEmployee(2));
        assertEquals(empNormal3, api.getEmployee(3));
    }

    @Test
    /*989*/   public void sortEmployeesBySecondName() {
        api.addEmployee(empNormal1); //1. Collins
        api.addEmployee(empNormal3); //3. Rollins
        api.addEmployee(empNormal4); //2. Freeman
        api.addEmployee(empNormal5); //4. Smith
        api.sortEmployeesBySecondName();
        assertEquals(empNormal1, api.getEmployee(0));
        assertEquals(empNormal4, api.getEmployee(1));
        assertEquals(empNormal3, api.getEmployee(2));
        assertEquals(empNormal5, api.getEmployee(3));
    }

    @Test
    /*989*/   public void sortEmployeesByHourlyRate() {
        api.addEmployee(empNormal1); //1. 10
        api.addEmployee(empNormal3); //3. 5
        api.addEmployee(empNormal4); //2. 7
        api.addEmployee(empNormal5); //4. 9
        api.sortEmployeesByHourlyRate();
        assertEquals(empNormal3, api.getEmployee(0));
        assertEquals(empNormal4, api.getEmployee(1));
        assertEquals(empNormal5, api.getEmployee(2));
        assertEquals(empNormal1, api.getEmployee(3));
    }

    @Test
    /*989*/   public void employeeWithHighestPay() {

//hoursWorked * hoursRate + bonus

        api.addEmployee(empNormal3); //2. 30 * 5 + 15 = 165
        api.addEmployee(empNormal4); //4. 10 * 7 + 13 = 83
        api.addEmployee(empNormal6); //1. 35 * 8 + 7 = 287
        api.addEmployee(empNormal5); //3. 17 * 9 + 7 = 160

        assertEquals(empNormal6, api.employeeWithHighestPay());

    }
        @Test
        public void testSaveLoad() throws Exception {
            assertEquals(0, api.getEmployees().size());
            this.api.save();
            EmployeeAPI api2 = new EmployeeAPI();
            api2.load();
            assertEquals(api.getEmployees().size(), api2.getEmployees().size());
            api.addEmployee(empNormal1);
            api.addEmployee(empNormal2);
            assertEquals(2, api.getEmployees().size());
            api.save();
            EmployeeAPI api3 = new EmployeeAPI();
            api3.load();
            assertEquals(empNormal1.getFirstName(), api3.getEmployee(0).getFirstName());
        }

    }
