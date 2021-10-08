package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    @Test
    void testGetDataFromFile() {
        DataHandler data = new DataHandler();
        data.getDataFromFile();
        ArrayList<String> expectedData = new ArrayList<>(
                Arrays.asList("Ling, Mai","Johnson, Jim",
                        "Zarnecki, Sabrina","Jones, Chris",
                        "Jones, Aaron","Swift, Geoffrey","Xiong, Fong")
        );
        //so umm, I don't think the user should have access to the
        //data directly, so I'm gonna make an otherwise unneeded return
        //array list function... cool, cool
        //assertArrayEquals(new ArrayList[]{expectedData}, new ArrayList[]{data.returnArrayListOfDataAsList()});
        assertEquals(expectedData,data.returnArrayListOfDataAsList());
    }
    @Test
    void testSortDataAlphabetically() {
        DataHandler data = new DataHandler();
        data.getDataFromFile();
        data.sortDataAlphabetically();
        ArrayList<String> expectedData = new ArrayList<>(
                Arrays.asList("Johnson, Jim","Jones, Aaron",
                        "Jones, Chris","Ling, Mai",
                        "Swift, Geoffrey","Xiong, Fong","Zarnecki, Sabrina")
        );
        assertArrayEquals(new ArrayList[]{expectedData}, new ArrayList[]{data.returnArrayListOfDataAsList()});

    }



}