package baseline;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHandler {
    private final ArrayList<HashMap<String,String>> data = new ArrayList<>();
    private static final String L_NAME = "Last";
    private static final String F_NAME = "First";
    private static final String SAL = "Salary";

    public void getDataFromFile() {
        //store the data from each line in a hashmap by parsing from the file
        //then store each hashmap in a list

        try (FileReader in = new FileReader("data/exercise42_input.txt")) {
            int c;
            StringBuilder string = new StringBuilder();
            //the item on the line, 1 for lName, 2 for fName, and 3 for salary
            int lineItem = 1;
            //make new map
            HashMap<String,String> person = new HashMap<>();
            while ((c = in.read())!=-1) {
                //first string is lName, next is fName, last is salary
                if (c==10 || c== 44) {
                    switch (lineItem) {
                        case 1 -> {
                            //add string to person's lName
                            person.put(L_NAME, String.valueOf(string));
                            //delete string to make room for next one
                            string.delete(0, string.length());
                            lineItem++;
                        }
                        case 2 -> {
                            //add string to person's fName
                            person.put(F_NAME, String.valueOf(string));
                            //delete string to make room for next one
                            string.delete(0, string.length());
                            lineItem++;
                        }
                        case 3 -> {
                            //delete new line character
                            string.deleteCharAt(string.length() - 1);
                            //add string to person's salary
                            person.put(SAL, String.valueOf(string));
                            //delete string to make room for next one
                            string.delete(0, string.length());
                            data.add(person);
                            //reset person
                            person = new HashMap<>();
                            //reset line item
                            lineItem = 1;
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + lineItem);
                    }
                } else {
                    string.append((char)c);
                }
            }
            //need to add last person at end of file
            //add string to person's salary
            person.put(SAL,String.valueOf(string));
            data.add(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayDataFromFileTabular() {
        //print table header
        System.out.println("Last      First     Salary\n" +
                "--------------------------");
        //print the data from the file
        //loop and print formatted strings
        for (HashMap<String,String> map:data) {
            System.out.printf("%-9s %-9s %-9s%n",map.get(L_NAME),map.get(F_NAME),map.get(SAL));
        }
    }
    public ArrayList<HashMap<String,String>> returnArrayListWithData() {
        return data;
    }
}
