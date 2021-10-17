package baseline;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    static final String fileName = "output";
    @Test
    void testGenerateOutputFile() throws IOException {
        Path expected = Paths.get("src/test/resources/testActual.txt");
        DataHandler test = new DataHandler();
        test.getDataFromTextFile();
        test.generateOutputFile(fileName);
        Path actual = Paths.get("data/" + fileName + ".txt");
        assertEquals(-1,Files.mismatch(expected,actual));
    }
    @Test
    void testReturnDataAsString() {
        String expected = """
                One should never utilize the word "utilize" in writing. Use "use" instead.
                For example, "She uses an IDE to write her Java programs" instead of "She
                utilizes an IDE to write her Java programs".""";
        DataHandler test = new DataHandler();
        test.getDataFromTextFile();
        assertEquals(expected,test.returnStringData());
    }
    @AfterEach
    void clearDirectories() throws IOException {
        //delete file from generateOutputFile
        Files.delete(Path.of("data/" + fileName + ".txt"));
    }
}