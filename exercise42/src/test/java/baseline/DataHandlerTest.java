package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    @Test
    void testGetDataFromFile() {
        DataHandler data = new DataHandler();
        data.getDataFromFile();
        //hashmap initializations
        HashMap<String,String> person1 = new HashMap<>();
        person1.put("Last","Ling");
        person1.put("First","Mai");
        person1.put("Salary","55900");
        HashMap<String,String> person2 = new HashMap<>();
        person2.put("Last","Johnson");
        person2.put("First","Jim");
        person2.put("Salary","56500");
        HashMap<String,String> person3 = new HashMap<>();
        person3.put("Last","Jones");
        person3.put("First","Aaron");
        person3.put("Salary","46000");
        HashMap<String,String> person4 = new HashMap<>();
        person4.put("Last","Jones");
        person4.put("First","Chris");
        person4.put("Salary","34500");
        HashMap<String,String> person5 = new HashMap<>();
        person5.put("Last","Swift");
        person5.put("First","Geoffrey");
        person5.put("Salary","14200");
        HashMap<String,String> person6 = new HashMap<>();
        person6.put("Last","Xiong");
        person6.put("First","Fong");
        person6.put("Salary","65000");
        HashMap<String,String> person7 = new HashMap<>();
        person7.put("Last","Zarnecki");
        person7.put("First","Sabrina");
        person7.put("Salary","51500");
        //array initialization
        ArrayList<HashMap<String,String>> expected = new ArrayList<>(Arrays.asList(person1,person2,person3,person4,person5,person6,person7));
        assertArrayEquals(new ArrayList[]{expected}, new ArrayList[]{data.returnArrayListWithData()});
    }
}