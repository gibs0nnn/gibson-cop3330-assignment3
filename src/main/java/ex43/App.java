package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 43 Solution
 *  Copyright 2021 Nathaniel Gibson
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Scans user input for the information to contain in their site

        //Handle taking input in main
        Scanner scanner = new Scanner(System.in);
        System.out.print("Site Name: ");
        String name = scanner.next();
        System.out.print("Author: ");
        String author = scanner.next();
        System.out.print("Do you want to create a folder for JavaScript? ");
        String jsResp = scanner.next();
        boolean js;
        if(jsResp.contentEquals("y")) {
            js = true;
            System.out.println("java created");
        } else {
            js = false;
            System.out.println("no java");
        }
        System.out.print("Do you want to create a folder for CSS? ");
        String csResp = scanner.next();
        boolean cs;
        if(csResp.contentEquals("y")) {
            cs = true;
            System.out.println("CSS created");
        } else {
            cs = false;
            System.out.println("No CSS");
        }
        createWebsite(name, author, js, cs);
    }

    //Generates the folders and html file to contain in the users website based on their input
    public static void createWebsite(String name, String author, boolean JS, boolean CSS) {

        //Create website folder and user website directory
        //Take directory strings to call whenever appropriate
        File website = new File("src/main/java/ex43/website");
        website.mkdir();
        File userSite = new File("src/main/java/ex43/website/" + name);
        userSite.mkdir();
        System.out.println("Created " + userSite.getAbsolutePath());

        //Create index path inside each website
        File index = new File(userSite.getAbsolutePath() + "/index.html");
        try {
            //Make new file to handle the html
            index.createNewFile();
            System.out.println("Created " + index.getAbsolutePath());

            //Send it to directory with output stream
            FileOutputStream indexStream = new FileOutputStream(index);
            PrintWriter output = new PrintWriter(indexStream);
            //Pull from a boilerplate to get the meta and author tag
            output.println("<!DOCTYPE html>\n<html lang=\"en\">\n\t<head>");
            output.println("\t\t<meta charset=\"UTF-8\" />\n\t\t<meta author=\"" + author + "\"/>");
            output.println("\t\t<title>" + name + "</title>\n\t</head>\n</html>");
            //Close stream so it actually writes
            output.close();
            indexStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Creates Java/CSS Folders if desired
        //Take boolean values, if true create packages for Java || CSS
        if(JS) {
            File java = new File(userSite.getAbsolutePath() + "/js/");
            java.mkdir();
            System.out.println("Created " + java.getAbsolutePath());
        }
        if(CSS) {
            File css = new File(userSite.getAbsolutePath() + "/css/");
            css.mkdir();
            System.out.println("Created " + css.getAbsolutePath());
        }
    }
}
