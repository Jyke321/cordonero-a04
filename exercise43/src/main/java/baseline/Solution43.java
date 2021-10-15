package baseline;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jacob Cordonero
 */

public class Solution43 {
    public static void main(String[] args) {
        //get user input
        DataHandler websiteGenerator = new DataHandler();
        websiteGenerator.getUserInput();
        //create requested files following user specifications
        websiteGenerator.generateUserFiles();
    }
}
