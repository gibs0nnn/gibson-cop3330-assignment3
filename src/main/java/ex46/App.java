package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 46 Solution
 *  Copyright 2021 Nathaniel Gibson
 */

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        //String fileDir take the directory of the file
        String fileDir = "src/main/java/ex46/exercise46_input.txt";
        //HashMap with word as key and frequency count as value
        HashMap<String, Integer> frequency = new HashMap<>();
        //ArrayList hold the file as string input
        ArrayList<String> input = getFile(fileDir);
        //Make ArrayList of individual words based on ArrayList of file input
        ArrayList<String> wordArray = convWords(input);
        frequency = wordFreq(wordArray);
        printWordHash(frequency);
    }

    //Parses the text file into an array list
    public static ArrayList<String> getFile(String dir) throws IOException {
        //Create FileReader to take file as input
        FileReader fr = new FileReader(dir);
        BufferedReader reader = new BufferedReader(fr);
        //ArrayList to take file as input
        ArrayList<String> file = new ArrayList<>();
        //While(not EOF loop)
        while(true) {
            String line = reader.readLine();
            //if EOF break
            if(line == null) {
                break;
            }
            //Add line to file when not EOF
            file.add(line);
        }
        return file;
    }

    //Takes the array list of the file and breaks down the words into individual indexes
    public static ArrayList<String> convWords(ArrayList<String> file) {
        //ArrayList words for breaking lines into individual words
        ArrayList<String> words = new ArrayList<>();
        //For(length of file)
        for(int i = 0; i < file.size(); i++) {
            //String array that indexes after every space
            String[] lineWords =file.get(i).split(" ");
            //For(length of lines)
            for(int j = 0; j < lineWords.length; j++) {
                //Add each word from the array to the list
                String indWord = lineWords[j];
                words.add(indWord);
            }
        }
        return words;
    }

    //Checks every index of the word array list and creates a hashmap with the words and how many times they were used
    public static HashMap<String, Integer> wordFreq(ArrayList<String> wordFile) {
        //HashMap to get frequency of words
        HashMap<String, Integer> frequency = new HashMap<>();

        //For(size of file)
        for(int i = 0; i < wordFile.size(); i++) {
            //If it is in the map, increment its value
            //if(word already in map)
            if(frequency.containsKey(wordFile.get(i))) {
                //++ frequency value
                int instance = frequency.get(wordFile.get(i));
                frequency.put(wordFile.get(i), ++instance);
            } else {
                //else{add to the map}
                frequency.put(wordFile.get(i), 1);
            }
        }
        return frequency;
    }

    //Prints out the words and their usage count in descending order
    public static void printWordHash(HashMap<String, Integer> freq) {
        //List for organizing the HashMap
        //Comparator to organize values in descending order
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(freq.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //Creates an arraylist to hold the number of asterisks for representing each hashmap value
        ArrayList<String> ast = new ArrayList<>();
        //For(size of list)
        for(int i = 0; i < list.size(); i++) {
            //String for asterisk (empty)
            String astIns = "";
            //For(number held for the value in map)
            for(int j = 0; j < list.get(i).getValue(); j++) {
                //Add asterisk to string until size of value reached
                astIns += "*";
            }
            //Add asterisk string to ArrayList
            ast.add(astIns);
        }

        //For(size of list)
        for(int i = 0; i < list.size(); i++) {
            //Convert list instance to string
            String indConv = list.get(i).toString();
            //String to print spaces
            String spaces = spaceConv(indConv.length() + 1);
            //Print full output
            System.out.println(list.get(i).getKey() + ":" + spaces + ast.get(i));
        }
    }

    //Creates a string with only the spaces between the words and the usage asterisks
    public static String spaceConv(int length) {
        //String spaces with no spaces
        String spaces = "";
        //12 - length of word, how many spaces you need
        int spaceCount = 12 - length;
        //For(how many spaces needed)
        for(int i = 0; i < spaceCount; i++) {
            //Add space to string
            spaces += " ";
        }
        return spaces;
    }
}

