package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    static DataHandler data = new DataHandler();
    @Test
    void testGetNameFromSecondProduct() {
        data.getDataFromJSON();
        String actual = "Thing";
        assertEquals(actual,data.getNameFromSecondProduct());
    }
}