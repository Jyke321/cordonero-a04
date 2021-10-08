package baseline;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jacob Cordonero
 */

public class Solution41 {
    public static void main(String[] args) {
        //get the data from the file
        DataHandler data = new DataHandler();
        data.getDataFromFile();
        //sort the data from the file by last name alphabetically
        data.sortDataAlphabetically();
        //print the data to the file
        data.printDataTotalNumberOfNamesAndDataToFile();
    }
}
