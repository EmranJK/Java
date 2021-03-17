import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    AdminWorker worker1, badWorker1 ,badWorker2;

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void validPps() {
        assertTrue(Utilities.validPps("6187861a"));
        assertFalse(Utilities.validPps("633"));
        assertFalse(Utilities.validPps("633a"));


    }
}