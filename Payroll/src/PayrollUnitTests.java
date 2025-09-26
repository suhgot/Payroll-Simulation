import static org.junit.Assert.*;
import org.junit.Test;

public class PayrollUnitTests {
    @Test
    public void testHourlyEmployeeMethods() {
        HourlyEmployee emp = new HourlyEmployee("John", "Doe", (float) 20.0);
        
        // Test Employee methods
        assertEquals("John, Doe", emp.getEmployeeName());
        assertEquals(1, emp.getEmployeeNumber());
        emp.changeEmployeeName("Saugat", "Shah");
        assertEquals("Saugat, Shah", emp.getEmployeeName());
        
        //Test Hourly Employee getter methods and set the wage for testing
        emp.timeSheet((float) 5.0);
        assertEquals(5.0, emp.getTimeSheet(), .001);
        assertEquals(20.0, emp.getWage(), .001);
        assertEquals(100.0, emp.getPaycheck(), .001);
        
        //Test setter
        emp.changeWage((float) 15.0);
        assertEquals(15.0, emp.getWage(), .001);
        
        //Test toString
        assertEquals("Hourly: $15.0; Id:1 - Saugat, Shah", emp.toString());
        
    }
    
    @Test
    public void testSalariedEmployeeMethods() {
        SalariedEmployee emp1 = new SalariedEmployee("John", "Doe", 39013);
        SalariedEmployee emp2 = new SalariedEmployee("Jane", "Doe", 52000);
        
        
     // Test Employee methods
     assertEquals("Jane, Doe", emp2.getEmployeeName());
     assertEquals(2, emp2.getEmployeeNumber());
     emp1.changeEmployeeName("Data", "Structures");
     assertEquals("Data, Structures", emp1.getEmployeeName());
     
     
     //Test Salaried Employee Methods
     assertEquals(52000, emp2.getSalary());
     assertEquals(39013, emp1.getSalary());
     assertEquals(2000.0, emp2.getPaycheck(), .001);
     assertEquals(1500.5, emp1.getPaycheck(), .001);
    
     emp1.changeSalary(0);
     
        
        
    }
}