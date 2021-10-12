package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 42 Solution
 *  Copyright 2021 Nathaniel Gibson
 */

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        //Create an array list to store the contents of the input file
    ArrayList<String> userInfo = fileReader("src/main/java/ex42/exercise42_input.txt");
    //Write methods to organize and display the data. Call them here
    userInfo = organizeData(userInfo);
    displayData(userInfo);
    }

    //Collect information from the input file and store it in an array list
    public static ArrayList fileReader(String fileName) {
        ArrayList<String> userInfo = new ArrayList<String>();
        try {
            //Create file reader to collect input
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            boolean flag = true;
            //while loop until EOF is reached
            while(flag) {
                String currentLine = reader.readLine();
                //null is EOF. Handle exiting loop when reached
                if(currentLine == null) {
                    flag = false;
                    //If EOF not on the current line, add the line to array list
                } else {
                    userInfo.add(currentLine);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    //Organize the information of the array list when given first/last name and salary
    public static ArrayList<String> organizeData(ArrayList<String> data) {
        //Create variables to handle spaces and commas
        int spaces = 0;
        int commaCounter = 0;
        //Create array list to hold data when organized
        ArrayList<String> organizedData = new ArrayList<>();

        //Increment through each row
        for(int row = 0; row < data.size(); row+=1) {
            //Gives the current row as a string for sorting
            String currentUser = data.get(row);
            StringBuffer sbf = new StringBuffer(currentUser);
            //Increment through each character individually of each row
            for(int column = 0; column < currentUser.length(); column++) {
                //When comma is found, delete and replace with spaces necessary
                //If column, remove it and put the spacing at that index
                if(currentUser.charAt(column) == ',') {
                    String spaceReplace = getSpaces(spaces);
                    int commaIndex = sbf.indexOf(",");
                    sbf.deleteCharAt(commaIndex);
                    sbf.replace(commaIndex, commaIndex, spaceReplace);
                    commaCounter++;
                    spaces = 0;
                    if(commaCounter == 2) {
                        commaCounter = 0;
                        break;
                    }
                    //Determines how many spaces will be needed
                } else {
                    spaces++;
                }
            }
            //Add data to the array after it is arranged
            String updatedContact = sbf.toString();
            organizedData.add(updatedContact);
        }
        return organizedData;
    }
    //Subtracts a fixed value from the number of letters before comma to find # of spaces and create fixed column size
    public static String getSpaces(int letters) {
        //Subtract 11 from num of letters to ensure all spacing is even regardless of name length
        int numSpace = 11 - letters;
        String spaces = "";
        //Increment space string adding a new space for every iteration
        for(int i = 0; i < numSpace-1; i++) {
            spaces += " ";
        }
        return spaces;
    }

    //Takes the ArrayList of data as input and displays the sorted information in columns
    public static void displayData(ArrayList data) {
        //Set up formatting for the header
        System.out.println("Last      First     Salary\n--------------------------");
        //Print out the information as columns
        for(int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }
}
