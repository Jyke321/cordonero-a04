package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    @Test
    void testGetNameFromSecondProduct() {
        DataHandler data = new DataHandler();
        data.getDataFromJSON();
        String actual = "Thing";
        assertEquals(actual,data.getNameFromSecondProduct());
    }

}