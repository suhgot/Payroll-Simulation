import static org.junit.Assert.*;
import org.junit.Test;

public class PayrollUnitTests {
    @Test
    public void testSalariedEmployeeMethods() {
        SalariedEmployee emp1 = new SalariedEmployee("John", "Doe", 39013);
        SalariedEmployee emp2 = new SalariedEmployee("Jane", "Doe", 52000);
        
        // Test Employee methods
        assertEquals("Jane, Doe", emp2.getEmployeeName());
        assertEquals(2, emp2.getEmployeeNumber());
        emp1.changeEmployeeName("Data", "Structures");
        assertEquals("Data, Structures", emp1.getEmployeeName());
        
        // Test Salaried Employee Methods
        assertEquals(52000, emp2.getSalary());
        assertEquals(39013, emp1.getSalary());
        assertEquals(2000.0, emp2.getPaycheck(), 0.001);
        assertEquals(1500.5, emp1.getPaycheck(), 0.001);
        
        emp1.changeSalary(10000);
        assertEquals(10000, emp1.getSalary());
    }
    
    @Test
    public void testHourlyEmployeeMethods() {
        HourlyEmployee emp3 = new HourlyEmployee("John", "Doe", 20.0f);
        
        // Test Employee methods
        assertEquals("John, Doe", emp3.getEmployeeName());
        assertEquals(3, emp3.getEmployeeNumber());
        emp3.changeEmployeeName("Saugat", "Shah");
        assertEquals("Saugat, Shah", emp3.getEmployeeName());
        
        // Test Hourly Employee getter methods and set the wage for testing
        emp3.timeSheet(5.0f);
        assertEquals(5.0, emp3.getTimeSheet(), 0.001);
        assertEquals(20.0, emp3.getWage(), 0.001);
        assertEquals(100.0, emp3.getPaycheck(), 0.001);
        
        // Test setter
        emp3.changeWage(15.0f);
        assertEquals(15.0, emp3.getWage(), 0.001);
        
        // Test toString
        assertEquals("Hourly: $15.0; Id:3 - Saugat, Shah", emp3.toString());
    }
    
}