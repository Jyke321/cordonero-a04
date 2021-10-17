package baseline;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DataHandler {
    private static final Scanner input = new Scanner(System.in);
    private Data data;
    private int productIndex;

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
    private boolean doesProductExist(String searchKey) {
        //determines whether string exists in data
        for (int i=0; i<data.products.length; i++) {
            if(data.products[i].name.compareTo(searchKey)==0) {
                productIndex = i;
                return true;
            }
        }
        return false;
    }
    private void displayProduct() {
        //format the price as money
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        //displays the product information
        System.out.println("Name: " + data.products[productIndex].name);
        System.out.println("Price: " + df.format(data.products[productIndex].price));
        System.out.println("Quantity: " + data.products[productIndex].quantity);
    }
    public void findProduct() {
        //prompts the user for product name
        boolean foundProduct = false;
        while (!foundProduct) {
            System.out.print("What is the product name? ");
            String searchKey = input.nextLine();
            //if product exists in data, display product
            if (doesProductExist(searchKey)) {
                foundProduct = true;
                displayProduct();
            } else {
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        }
    }
}
