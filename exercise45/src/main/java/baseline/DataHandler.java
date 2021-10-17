package baseline;

import java.io.*;

public class DataHandler {
    private StringBuilder data = new StringBuilder();
    private final String[] replace = {"utilize","use"};

    public void getDataFromTextFile() {
        //get data from file into data stringBuilder
        try(FileReader in = new FileReader("data/exercise45_input.txt")) {
            int c;
            while((c = in.read())!=-1) {
                data.append(Character.toChars(c));
            }
            data = new StringBuilder(data.toString().replace("\\n", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void replaceUtilizeWithUseInDataString() {
        data = new StringBuilder(data.toString().replace(replace[0], replace[1]));
    }
    public void generateOutputFile(String fileName) {
        //modify string
        replaceUtilizeWithUseInDataString();
        //use user input filename to make generate a file
        try(FileWriter out = new FileWriter("data/" + fileName + ".txt")) {
            out.write(data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String returnStringData(){
        return data.toString();
    }
}
