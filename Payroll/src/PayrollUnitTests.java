import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PayrollUnitTests {
	
	
	
	//INITIALIZATION
	public static SalariedEmployee salEmp = new SalariedEmployee("Saugat", "Shah", 10000.0f);
	public static HourlyEmployee hrEmp = new HourlyEmployee("Jane", "Doe", 20.0f);
	public static float error = .01f;
	
	
	
	//EMPLOYEE TESTS
	@Before
	public void testChangeEmployeeName() throws Exception {
		salEmp.changeEmployeeName("John", "Doe");
	}
	
	
	@Test
	public void testGetEmployeeName() throws Exception {
		assertEquals("Doe, John", salEmp.getEmployeeName());
	}
	
	@Test
	public void testGetEmployeeNumber() throws Exception {
		assertEquals(salEmp.getEmployeeNumber(), 1);
	}
	
	
	
	//SALARIED EMPLOYEE TESTS
	@Before
	public void testChangeSalary() throws Exception {
		salEmp.changeSalary(39013.00f);
	}
	
	
	@Test
	public void testGetSalary() throws Exception {
		assertEquals((float) 39013.00f, salEmp.getSalary(), error);
	}
	
	@Test
	public void testgetPaycheck() throws Exception {
		assertEquals((float) 1500.50, salEmp.getPaycheck(), error);
	}
	
	@Test
	public void testSalariedToString() throws Exception {
		assertEquals("Salaried, Base : $39013.00; Id:1 - Doe, John", salEmp.toString());
	}
	
	
	
	//HOURLY EMPLOYEE TESTS
	@Before
	public void testChangeWage() throws Exception {
		hrEmp.changeWage(17.50f);
	}
	@Before
	public void testSetTimeSheet() throws Exception {
		hrEmp.timeSheet(25.50f);
	}
	
	
	@Test
	public void testGetWage() throws Exception {
		assertEquals(17.50f, hrEmp.getWage(), error);
	}
	
	@Test
	public void testGetTimeSheet() throws Exception {
		assertEquals(25.50f, hrEmp.getTimeSheet(), error);
	}
	
	@Test
	public void testGetPaycheck() throws Exception {
		assertEquals(446.25f, hrEmp.getPaycheck(), error);
	}

	@Test
    public void testHourlyToString() throws Exception {
        assertEquals("Hourly: $17.50; Id:2 - Doe, Jane", hrEmp.toString());
    }

}