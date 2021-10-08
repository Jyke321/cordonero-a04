package baseline;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jacob Cordonero
 */

public class Solution42 {
    public static void main(String[] args) {
        //get data from file
        DataHandler data = new DataHandler();
        data.getDataFromFile();
        //so, apparently I am very bad at reading...
        //display the data in tabular format to the console
        data.displayDataFromFileTabular();
    }
}
