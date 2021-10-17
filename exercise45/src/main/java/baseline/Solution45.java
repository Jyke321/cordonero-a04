package baseline;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Jacob Cordonero
 */

import java.util.Scanner;

public class Solution45 {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //create object that stores text file to a stringBuilder object
        DataHandler data = new DataHandler();
        data.getDataFromTextFile();
        //prompt for the output file name
        System.out.print("Please enter a name for the file: ");
        String input = in.nextLine();
        //output the modified string to the file
        data.generateOutputFile(input);
    }
}
