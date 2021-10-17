package baseline;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class DataHandler {
    private Data data;

    public void getDataFromJSON() {
        //parseDataFromJSON and store in data
        Gson gson = new Gson();
        try (Reader in = new FileReader("data/exercise44_input.json")){
            JsonReader json = new JsonReader(in);
            data = gson.fromJson(json, Data.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getNameFromSecondProduct(){
        return  data.products[1].name;
    }
    private boolean doesProductExist() {
        //determines whether string exists in data
        return false;
    }
    private void displayProduct() {
        //displays the product information

    }
    public void findProduct() {
        //prompts the user for product name

        //if product exists in data, display product

    }
}
