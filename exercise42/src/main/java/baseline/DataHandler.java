package baseline;

import java.util.HashMap;
import java.util.List;

public class DataHandler {
    private List<HashMap<String,String>> data;
    private final String LNAME = "Last";
    private final String FNAME = "First";
    private final String SAL = "Salary";

    public void getDataFromFile() {
        //store the data from each line in a hashmap by parsing from the file
        //then store each hashmap in a list
    }

    public void printDataToFileTabular() {
        //print the data to the file
        //either use string builder or formatting provided by file out if it exists

        //open file, print data

        //close file

    }

    private String buildTabularOutputString(HashMap<String,String> person) {
        //if no formatting exists for file writer or other iostream output object
        //build a formatted string with string builder for each hashmap
        return "";
    }
}
