package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class DataHandler {
    //user input variables
    private String siteName;
    private String author;
    private Boolean js;  //act as flag for y/n
    private Boolean css; //act as flag for y/n

    private static final Scanner in = new Scanner(System.in);

    public void getUserInput() {
        //prompt user for input and set the appropriate variables
        System.out.print("Site name: ");
        siteName = in.nextLine();
        System.out.print("Author: ");
        author = in.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        js = getBoolFromUserInput(in.nextLine());
        System.out.print("Do you want a folder for CSS? ");
        css = getBoolFromUserInput(in.nextLine());
    }

    private Boolean getBoolFromUserInput(String input) {
        return input.charAt(0) == 'Y' || input.charAt(0) == 'y';
    }

    /*
    Created ./website/awesomeco
    Created ./website/awesomeco/index.html
    Created ./website/awesomeco/js/
    Created ./website/awesomeco/css/
     */
    public void generateUserFiles() {
        //create constant instead of duplicated literal
        final String CREATED = "Created .";
        //uses the data to make the website directory
        String websiteDirectoryName = ("/website/" + siteName);
        File websiteFile = new File("data" + websiteDirectoryName);
        websiteFile.mkdirs();
        System.out.println(CREATED + websiteDirectoryName);
        //uses the data to make the index.html
        try (Formatter out = new Formatter(websiteFile + "/index.html")) {
            out.format("<!DOCTYPE html>%n" +
                    "<html>%n" +
                    "   <head>%n" +
                    "      <title>%s</title>%n" +
                    "      <meta name = \"author\" content = \"%s\">%n" +
                    "   </head>%n" +
                    "</html>",siteName,author);
            System.out.println(CREATED + websiteDirectoryName + "/index.html");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //make the js file is asked for
        if (Boolean.TRUE.equals(js)) {
            File javaScriptFolder = new File(websiteFile + "/js/");
            javaScriptFolder.mkdirs();
            System.out.println(CREATED + websiteDirectoryName + "/js/");
        }
        //make the css file if asked for
        if (Boolean.TRUE.equals(css)) {
            File cssFolder = new File(websiteFile + "/css/");
            cssFolder.mkdirs();
            System.out.println(CREATED + websiteDirectoryName + "/css/");
        }
    }
}
