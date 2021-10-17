package baseline;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    @Test
    void testGetInputFromFile() {
        HashMap<String,Integer> expected = new HashMap<>();
        expected.put("badger",7);
        expected.put("mushroom",2);
        expected.put("snake",1);
        DataHandler test = new DataHandler();
        test.getInputFromTxtFile();
        assertEquals(expected,test.returnDataFromHashMap());
    }
    @Test
    void testOutputHistogramAsGreatestToLeast() throws IOException {
        Path expected = Path.of("src/test/resources/output.txt");
        DataHandler test = new DataHandler();
        test.getInputFromTxtFile();
        test.outputHistogramAsGreatestToLeast();
        Path actual = Path.of("data/output.txt");
        assertEquals(-1, Files.mismatch(expected,actual));
    }
    @AfterEach
    void deleteTestFiles() throws IOException {
        Files.deleteIfExists(Path.of("data/output.txt"));
    }
}