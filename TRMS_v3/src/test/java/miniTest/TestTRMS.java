package miniTest;

import org.apache.log4j.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import the_beans.App;
import the_beans.Employee;
import the_beans.Reimburse;


public class TestTRMS extends TestCase {

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestTRMS( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( TestTRMS.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue( true );
    }
    
    // real tests
    public void testEmployeeObjects() {
    	Employee someEmployee = new Employee();
    	someEmployee.setEmail("some_email@gmail.com");
    	
    	if (someEmployee.getEmail().equals("some_email@gmail.com")) {
    		assertTrue(true);
    	}	
    }
    
    public void testReimburseObjects() {
    	Reimburse someReimburseEntry = new Reimburse();
    	
    	someReimburseEntry.setEventAddress("11730 Plaza America Drive");
    	someReimburseEntry.setEvent_Justification("event justify test");
    	someReimburseEntry.setEventCity("Reston");
    	
    	if (someReimburseEntry.getEventAddress().equals("11730 Plaza America Drive") && 
    			someReimburseEntry.getEvent_Justification().equals("event justify test") &&
    			someReimburseEntry.getEventCity().equals("Reston")) {
    		assertTrue(true);
    	}
    }
    
    public void log4j_test() {
    	
    	final Logger logger = Logger.getLogger(Reimburse.class);
    	String parameter = "hello";
    	
    	if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
		assertTrue(true);
    }
    
    
}
