package baseline;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    static final String fileName = "output.txt";
    @Test
    void testGenerateOutputFile() throws IOException {
        Path expected = Files.createTempFile("test","file");
        Files.writeString(expected,"One should never use the word \"use\" in writing. Use \"use\" instead.\n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
                "uses an IDE to write her Java programs\".");
        DataHandler test = new DataHandler();
        test.getDataFromTextFile();
        test.generateOutputFile(fileName);
        Path actual = Paths.get("data/" + fileName);
        assertEquals(-1,Files.mismatch(expected,actual));
    }
    @AfterEach
    void clearDirectories() throws IOException {
        //delete file from generateOutputFile
        Files.delete(Path.of("data/" + fileName));
    }

}