package baseline;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class DataHandler {
    //I haven't done any reading yet so...
    ArrayList<String> data = new ArrayList<>();
    FileReader in = null;

    public void getDataFromFile() {
        //get a line from file and store it in data as a string
        // (loop until end of file, as long as it is similar to C)
        try {
            in = new FileReader("data/exercise41_input.txt");
            //actually read data and store it in list now
            int c;
            StringBuilder string = new StringBuilder();
            while ((c = in.read())!= -1) {
                if (c!=10)
                    string.append((char)c);
                else {
                    data.add(String.valueOf(string));
                    string.delete(0,string.length());
                }
            }
            data.add(String.valueOf(string));
            //close file
            in.close();
        } catch (Exception e){
            System.out.println("File not found.");
            System.exit(0);
        }
    }
    public void displayNumberOfNames() {
        //print the number of elements in the list data
        System.out.println("Total of " + data.size() +" names");
    }
    public void displayData() {
        //loops through list and displays the data
        for (String item : data) {
            System.out.println(item);
        }
    }
    public void sortDataAlphabetically() {
        //sort the data so that it is in numerical order
        Collections.sort(data);
    }
}
