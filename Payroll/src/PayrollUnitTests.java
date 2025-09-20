import static org.junit.Assert.*;
import org.junit.Test;

public class PayrollUnitTests {

    @Test
    public void testHourlyEmployeeMethods() {
        HourlyEmployee emp = new HourlyEmployee("John", "Doe", 20);
        
        // Test constructor and getters
        assertEquals("John, Doe", emp.getEmployeeName());
        assertEquals(20, emp.getWage());
        
        // Test timeSheet methods
        emp.timeSheet(40);
        assertEquals(40, emp.getTimeSheet());
        
        // Test wage change
        emp.changeWage(25);
        assertEquals(25, emp.getWage());
        
        // Test paycheck calculation
        assertEquals(1000.0f, emp.getPaycheck(), 0.001f);
        
        // Test toString
        assertEquals("Hourly: 25; Id:1 - John, Doe", emp.toString());
    }

    @Test
    public void testSalariedEmployeeMethods() {
        SalariedEmployee emp = new SalariedEmployee("Jane", "Smith", 52000);
        
        // Test constructor and getters
        assertEquals("Jane, Smith", emp.getEmployeeName());
        assertEquals(52000, emp.getSalary());
        
        assertEquals(2000.0f, emp.getPaycheck(), 0.001f);
        
        // Test toString
        assertEquals("Salaried, Base : 52000; Id:2 - Jane, Smith", emp.toString());
    }
}