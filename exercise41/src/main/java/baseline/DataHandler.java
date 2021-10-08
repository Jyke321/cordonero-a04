package baseline;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DataHandler {
    //I haven't done any reading yet so...
    private final ArrayList<String> data = new ArrayList<>();
    private FileWriter fileOut = null;

    public void getDataFromFile() {
        //get a line from file and store it in data as a string
        // (loop until end of file, as long as it is similar to C)
        try {
            FileReader in = new FileReader("data/exercise41_input.txt");
            //actually read data and store it in list now
            int c;
            StringBuilder string = new StringBuilder();
            while ((c = in.read())!= -1) {
                if (c==10) {
                    //delete new line character
                    string.deleteCharAt(string.length()-1);
                    //add string to list
                    data.add(String.valueOf(string));
                    //delete string to make room for next one
                    string.delete(0,string.length());
                }
                else {
                    string.append((char)c);
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
    private void printNumberOfNamesToFile(FileWriter fOut) {
        //print the number of elements in the list data
        try {
            fOut.write("Total of " + data.size() +" names\n");
            fOut.write("-----------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void printDataToFile(FileWriter fOut) {
        try {
            //loops through list and prints the data to data/exercise41_output.txt
            for (String item : data) {
                fOut.write("\n" + item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sortDataAlphabetically() {
        //sort the data so that it is in numerical order
        Collections.sort(data);
    }
    public ArrayList<String> returnArrayListOfDataAsList() {
        //extra function for testing the array, so I'm ignoring sonar lint here
        return data;
    }
    private FileWriter initializeFilePointer() {
        //open file to output to
        try {
            fileOut = new FileWriter("data/exercise41_output.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileOut;
    }
    //making a wrapper function... ugh
    public void printDataTotalNumberOfNamesAndDataToFile() {
        fileOut = initializeFilePointer();
        printNumberOfNamesToFile(fileOut);
        printDataToFile(fileOut);
        try {
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
