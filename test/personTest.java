import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class personTest {

    private Person p1;
    private Person p2;

    @BeforeEach
    void setUp() {
        p1 = new Person("John", "Doe", "000001", "Mr.", 1990);
        p2 = new Person("Jane", "Smith", "000002", "Dr.", 1985);
    }

    @Test
    void testConstructor() {
        assertEquals("John", p1.getFirstName());
        assertEquals("Doe", p1.getLastName());
        assertEquals("000001", p1.getID());
        assertEquals("Mr.", p1.getTitle());
        assertEquals(1990, p1.getYOB());
    }

    @Test
    void testOverloadedConstructor() {
        Person p3 = new Person("Alex", "Jones", "000003");
        assertEquals("Alex", p3.getFirstName());
        assertEquals("Jones", p3.getLastName());
        assertEquals("000003", p3.getID());
        assertEquals("", p3.getTitle());
        assertEquals(2000, p3.getYOB());
    }

    @Test
    void testSetFirstName() {
        p1.setFirstName("Johnny");
        assertEquals("Johnny", p1.getFirstName());
    }

    @Test
    void testSetLastName() {
        p1.setLastName("Smith");
        assertEquals("Smith", p1.getLastName());
    }

    @Test
    void testSetTitle() {
        p1.setTitle("Prof.");
        assertEquals("Prof.", p1.getTitle());
    }

    @Test
    void testSetYOB() {
        p1.setYOB(1995);
        assertEquals(1995, p1.getYOB());
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", p1.fullName());
    }

    @Test
    void testFormalName() {
        assertEquals("Mr. John Doe", p1.formalName());
    }

    @Test
    void testGetAgeCurrentYear() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String expectedAge = String.valueOf(currentYear - 1990);
        assertEquals(expectedAge, p1.getAge());
    }

    @Test
    void testGetAgeSpecifiedYear() {
        assertEquals("20", p1.getAge(2010));
    }

    @Test
    void testToCSV() {
        assertEquals("000001, John, Doe, Mr., 1990", p1.toCSV());
    }

    @Test
    void testToJSON() {
        String expectedJSON = "{\"ID\":\"000001\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"title\":\"Mr.\",\"YOB\":1990}";
        assertEquals(expectedJSON, p1.toJSON());
    }

    @Test
    void testToXML() {
        String expectedXML = "<Person><ID>000001</ID><firstName>John</firstName><lastName>Doe</lastName><title>Mr.</title><YOB>1990</YOB></Person>";
        assertEquals(expectedXML, p1.toXML());
    }

    @Test
    void testEquals() {
        Person pDuplicate = new Person("John", "Doe", "000001", "Mr.", 1990);
        assertEquals(p1, pDuplicate);
        assertNotEquals(p1, p2);
    }
}