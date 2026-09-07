import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product p1;
    private Product p2;

    @BeforeEach
    void setUp() {
        p1 = new Product("Widget", "A useful widget", "000001", 19.99);
        p2 = new Product("Gadget", "A handy gadget", "000002", 49.50);
    }

    @Test
    void testConstructor() {
        assertEquals("Widget", p1.getName());
        assertEquals("A useful widget", p1.getDescription());
        assertEquals("000001", p1.getID());
        assertEquals(19.99, p1.getCost());
    }

    @Test
    void testOverloadedConstructor() {
        Product p3 = new Product("Thingamajig", "000003", 9.99);
        assertEquals("Thingamajig", p3.getName());
        assertEquals("", p3.getDescription());
        assertEquals("000003", p3.getID());
        assertEquals(9.99, p3.getCost());
    }

    @Test
    void testSetName() {
        p1.setName("Super Widget");
        assertEquals("Super Widget", p1.getName());
    }

    @Test
    void testSetDescription() {
        p1.setDescription("An upgraded useful widget");
        assertEquals("An upgraded useful widget", p1.getDescription());
    }

    @Test
    void testSetCost() {
        p1.setCost(24.99);
        assertEquals(24.99, p1.getCost());
    }

    @Test
    void testToCSV() {
        assertEquals("Widget, A useful widget, 000001, 19.99", p1.toCSV());
    }

    @Test
    void testToJSON() {
        String expectedJSON = "{\"name\":\"Widget\",\"description\":\"A useful widget\",\"ID\":\"000001\",\"cost\":19.99}";
        assertEquals(expectedJSON, p1.toJSON());
    }

    @Test
    void testToXML() {
        String expectedXML = "<Product><name>Widget</name><description>A useful widget</description><ID>000001</ID><cost>19.99</cost></Product>";
        assertEquals(expectedXML, p1.toXML());
    }

    @Test
    void testEquals() {
        Product pDuplicate = new Product("Widget", "A useful widget", "000001", 19.99);
        assertEquals(p1, pDuplicate);
        assertNotEquals(p1, p2);
    }
}