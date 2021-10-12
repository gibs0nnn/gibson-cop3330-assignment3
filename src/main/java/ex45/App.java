package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 45 Solution
 *  Copyright 2021 Nathaniel Gibson
 */

import java.io.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        //String read/write directories
        String readDir = "src/main/java/ex45/exercise45_input.txt";
        //ArrayList file - store input file
        ArrayList<String> file = getFile(readDir);
        //ArrayList to hold the file with switched words
        ArrayList<String> newFile = switchWords("utilize", "use", file);
        String writeDir = "src/main/java/ex45/exercise45_output.txt";
        //writeFile call to create output with words switched
        writeFile(newFile, writeDir);

    }

    //Method getFile, return array list of the file
    public static ArrayList<String> getFile(String dir) throws IOException {
            FileReader fr = new FileReader(dir);
            BufferedReader reader = new BufferedReader(fr);
            ArrayList<String> file = new ArrayList<String>();
            //while(not null) run through file
            while(true) {
                String currentLine = reader.readLine();
                //stop reading when EOF is reached
                if(currentLine == null) {
                    break;
                }
                //else{not null, add the current line}
                file.add(currentLine);
            }
            return file;

    }

    //Creates a new array list with the desired word swapped with the original in the file
    public static ArrayList<String> switchWords(String original, String change, ArrayList<String> file) {
        //ArrayList newFile to hold swapped word file
        ArrayList<String> newFile = new ArrayList<String>();
        //for(size of file)
        for(int i = 0; i < file.size(); i++) {
            //use .replace on newFile to change every instance of the word
            newFile.add(file.get(i).replace(original, change));
        }
        return newFile;
    }

    //Writes an array list to a text file
    public static void writeFile(ArrayList<String> file, String dir) throws IOException {
        //BufferedWriter - write new swapped list
        BufferedWriter writer = new BufferedWriter(new FileWriter(dir));
        //for(size of arraylist) - insert each line
        for(int i = 0; i < file.size(); i++) {
            writer.write(file.get(i) + "\n");
        }
        //close writer
        writer.close();
    }
}
