package baseline;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jacob Cordonero
 */

public class Solution44 {
    //I have no clue how json works and I feel as though researching that defeats the point of pseduocode
    //more realistically I probably just have no clue what the point of pseudo code is so oh well.
    public static void main(String[] args) {
        //call an object to store the json data
        DataHandler data = new DataHandler();
        data.getDataFromJSON();
        //either use a loop to call a function or just a call a self containted object method
        data.findProduct();
    }
}
