package baseline;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    @Test
    void testGenerateUserFiles() throws IOException {
        DataHandler test = new DataHandler("awesomeco","Max Power", true, true);
        String indexHTMLFilePath = "data/website/awesomeco/index.html";
        Path actual = Paths.get("src/test/resources/test.html");
        test.generateUserFiles();
        Path generatedFile = Paths.get(indexHTMLFilePath);

        long mismatch = Files.mismatch(actual,generatedFile);
        assertEquals(-1,mismatch);
    }
    @Test
    void testIfCssFolderCreated() {
        DataHandler test = new DataHandler("awesomeco","Max Power", true, true);
        test.generateUserFiles();
        assertTrue(Files.isDirectory(Path.of("data/website/awesomeco/css")));
    }
    @Test
    void testIfJsFolderCreated() {
        DataHandler test = new DataHandler("awesomeco","Max Power", true, true);
        test.generateUserFiles();
        assertTrue(Files.isDirectory(Path.of("data/website/awesomeco/js")));
    }
    @Test
    void testIfCssFolderNotCreated() {
        DataHandler test = new DataHandler("awesomeco","Max Power", false, false);
        test.generateUserFiles();
        assertFalse(Files.isDirectory(Path.of("data/website/awesomeco/css")));
    }
    @Test
    void testIfJsFolderNotCreated() {
        DataHandler test = new DataHandler("awesomeco","Max Power", false, false);
        test.generateUserFiles();
        assertFalse(Files.isDirectory(Path.of("data/website/awesomeco/js")));
    }
    @AfterEach
    void destruct() throws IOException {
        Files.deleteIfExists(Path.of("data/website/awesomeco/index.html"));
        Files.deleteIfExists(Path.of("data/website/awesomeco/css"));
        Files.deleteIfExists(Path.of("data/website/awesomeco/js"));
        //I'll have to learn how to delete directories quicker one day
        Files.deleteIfExists(Path.of("data/website/awesomeco"));
        Files.deleteIfExists(Path.of("data/website"));
    }
}