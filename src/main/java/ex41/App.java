package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 41 Solution
 *  Copyright 2021 Nathaniel Gibson
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws IOException {
        //Create Strings to hold the directory for input/output
        String readName = "src/main/java/ex41/exercise41_input.txt";
        String writeName = "src/main/java/ex41/exercise41_output.txt";
        //Create an array list to hold the parsed information from the file
        ArrayList nameList = readFile(readName);
        //Create a method to generate a new file with the sorted information
        writeFile(writeName, nameList, nameList.size());

    }

    //Parses the text file and returns an array list containing its contents
    //Create method to read in the file and return as array list
    public static ArrayList readFile(String fileName) throws IOException {
        ArrayList names = new ArrayList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            boolean flag = true;
            //Loop that runs until the end of the file is reached
            while(flag) {
                String pickLine = reader.readLine();
                if(pickLine == null) {
                    flag = false;
                } else {
                    names.add(pickLine);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Return array list containing the contents of the file
        ArrayList sortedNames = sortNames(names);
        return sortedNames;
    }

    //Formats the data with proper heading and writes it to a text file
    public static void writeFile(String fileName, ArrayList names, int length) {
        try {
            //Create a writer that generates a file with the directory string
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            //Handle the formatting of the header of the file
            writer.write("Total of " + length + " names\n-----------------\n");
            for(int i = 0; i < length; i++) {
                writer.write((String)names.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Sorts the names in a passed array list and returns them alphabetically in an array list
    public static ArrayList sortNames(ArrayList names) {
        Collections.sort(names);
        return names;
    }
}
