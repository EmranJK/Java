import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for the abstract class Employee
 *
 * Note that we are testing via the AdminWorker class, but we are
 * only testing methods that reside in the Employee class
 *
 * @author Siobhan Drohan & Mairead Meagher
 * @version 03/20
 */

public class EmployeeTest {

    private AdminWorker empNormal1, empNormal2;
    private AdminWorker empTestValidation;

    /**
     * Method to set up data for testing.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        //todo: Add your own employee fields into the constructor call here
        empNormal1 = new AdminWorker("Jack", "Collins", "Jack@gmail.com", "0726752377","6187861a",20,10,5);
        empNormal2 = new AdminWorker( "James", "Russo", "James@gmail.com","0764588365","2489555m",40.5,10,0);
        empTestValidation = new AdminWorker("Johnqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", "Smithqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", "Johngmail.com","0771225455a","633",-1,5,0);
    }

    /**
     * Test method for Employee constructor
     */
    @Test
    public void testConstructor() {
        //test on valid data
        //todo: Validate your own employee fields in here
      /*989*/    assertEquals("Jack", empNormal1.getFirstName());
      /*989*/   assertEquals("Collins", empNormal1.getLastName());
      /*989*/   assertEquals("Jack@gmail.com", empNormal1.getEmail());
      /*989*/  assertEquals("0726752377",empNormal1.getPhoneNum());
        assertEquals(20, empNormal1.getHoursWorked(), 0.01);
        assertEquals(10, empNormal1.getHourRate(), 0.01);
      /*989*/  assertEquals("6187861a", empNormal1.getPpsNum());
      /*989*/  assertEquals(5, empNormal1.getBonus(), 0.01);

        //test on invalid data
        //todo: Test the invalid data that was passed to the Employee constructor here
      /*989*/  assertEquals(empTestValidation.getFirstName().substring(0,30),empTestValidation.getFirstName());
      /*989*/ assertEquals(empTestValidation.getLastName().substring(0,30),empTestValidation.getLastName());
      /*989*/  assertEquals("Invalid",empTestValidation.getEmail());
      /*989*/ assertEquals("Invalid",empTestValidation.getPhoneNum());
        assertEquals(0, empTestValidation.getHoursWorked(), 0.01);
        assertEquals(9.80, empTestValidation.getHourRate(), 0.01);
      /*989*/  assertEquals("Invalid", empTestValidation.getPpsNum());
      /*989*/  assertEquals(0,empTestValidation.getBonus(), 0.01);
    }

    /**
     * Test method for getSalary(), testing for employees with and without overtime.
     */
    @Test
    public void testGetSalary(){
        //employee under NORMAL_WORKING_WEEKS hours
        assertEquals(200, empNormal1.getSalary(), 0.01 );
        //employee with overtime + fixed bonus
        assertEquals(415, empNormal2.getSalary(), 0.01 );
        empNormal1.setHourRate(0);
        assertEquals(200, empNormal1.getSalary(), 0.01 );
        empNormal1.setHourRate(20);
        assertEquals(400, empNormal1.getSalary(), 0.01 );
        empNormal1.setHoursWorked(40.5);
        empNormal1.setHourRate(20);
        assertEquals(830, empNormal1.getSalary(), 0.01);
    }

    /**
     * Test method for getters and setters.
     */
    @Test
    public void testSettersGetters() {
        //todo: add tests for the setters and getters for your Employee fields
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

    /**
     * Test method for getOverTime (= hourly-rate*2 * (the number of hours overtime))
     */
    @Test
    public void getOverTime() {
        assertEquals(0, empNormal1.getOverTime(), 0.01);
        assertEquals(20, empNormal2.getOverTime(), 0.01);
        empNormal2.setHourRate(20);
        assertEquals(40, empNormal2.getOverTime(), 0.01);
    }

    /**
     * Test method for toString - checks that all data fields are present.
     */
    @Test
    public void testToString() {
        assertTrue(empNormal1.toString().contains("Hours Worked"));
        assertTrue(empNormal1.toString().contains("20"));
        assertTrue(empNormal1.toString().contains("per hour"));
        assertTrue(empNormal1.toString().contains("10"));
    }
}