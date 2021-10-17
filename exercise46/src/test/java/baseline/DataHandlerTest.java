package baseline;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    @Test
    void testOutputHistogramAsGreatestToLeast() throws IOException {
        Path actual = Path.of("src/test/resources/output.txt");
        DataHandler test = new DataHandler();
        test.getInputFromTxtFile();
        test.outputHistogramAsGreatestToLeast();
        Path expected = Path.of("data/output.txt");
        assertEquals(-1, Files.mismatch(actual,expected));
    }
    @AfterEach
    void deleteTestFiles() throws IOException {
        Files.deleteIfExists(Path.of("data/output.txt"));
    }
}