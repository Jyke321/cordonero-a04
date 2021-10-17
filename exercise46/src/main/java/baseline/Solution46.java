package baseline;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jacob Cordonero
 */

public class Solution46 {
    public static void main(String[] args) {
        //create an object that gets the data from the text file and stores it
        DataHandler data = new DataHandler();
        data.getInputFromTxtFile();
        //call a function from the object that displays the ordered output
        data.outputHistogramAsGreatestToLeast();
    }
}
