import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminWorkerTest {

    AdminWorker worker1, worker2, badWorker;


    @Before
    public void setUp() throws Exception {
    worker1 = new AdminWorker("Jack", "Collins", "Jack@gmail.com", "0726752377","6187861a",20,10,5);
    worker2 = new AdminWorker("James", "Russo", "James@gmail.com","0764588365","2489555m",40.5,10,0);
    badWorker = new AdminWorker("Johnqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", "Smithqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", "Johngmail.com","0771225455a","633",-1,5,0);
    }

    @Test
    public void testConstructor() {
        assertEquals("Jack@gmail.com", worker1.getEmail());
        assertEquals("Jack", worker1.getFirstName());
        assertEquals("Collins", worker1.getLastName());
        assertEquals("0726752377", worker1.getPhoneNum());
        assertEquals("6187861a", worker1.getPpsNum());
        assertEquals(20, worker1.getHoursWorked(), 0.1);
        assertEquals(10, worker1.getHourRate(), 0.1);
        assertEquals(5, worker1.getBonus(), 0.1);
        ////////////////////////////////////////


        assertEquals("Invalid", badWorker.getEmail());
        assertEquals(badWorker.getFirstName().substring(0,30),badWorker.getFirstName());
        assertEquals(badWorker.getLastName().substring(0,30),badWorker.getLastName());
        assertEquals("Invalid", badWorker.getPhoneNum());
        assertEquals("Invalid", badWorker.getPpsNum());
        assertEquals(0, badWorker.getHoursWorked(),0.1);
        assertEquals(9.8, badWorker.getHourRate(),0.1);
        assertEquals(0, badWorker.getBonus(),0.1);


    }

    @Test
    public void setBonus() {
        worker1.setBonus(6);
        assertEquals(6, worker1.getBonus(), 0.1);
        worker1.setBonus(-4);
        assertEquals(6, worker1.getBonus(), 0.1);
    }

    @Test
    public void calculateSalary() {
        assertEquals(205, worker1.calculateSalary(),0.1);
        assertEquals(0,badWorker.calculateSalary(),0.1);

    }
}