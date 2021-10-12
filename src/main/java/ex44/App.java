package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 44 Solution
 *  Copyright 2021 Nathaniel Gibson
 */

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws FileNotFoundException {
        //.json file to pass in for parsing
        String file = "src/main/java/ex44/exercise44_input.json";

        //ProductAsset object to hold the converted file
        ProductAssets myProducts = deserializeProducts(file);
        //checkNames(object) - ask for names until one is in the object
        checkNames(myProducts);

    }

    //Assigns the .json file data to an object that stores its data appropriately
    public static ProductAssets deserializeProducts(String file) throws FileNotFoundException {
        //Reader(read .json file)
        Gson gson = new Gson();
        Reader reader = new FileReader(file);
        //Product class() to hold the json file with gson
        ProductAssets products = gson.fromJson(reader, ProductAssets.class);
        return products;
    }

    //Compares a user-given name to the 'products' object to see if the name is in the file
    public static void checkNames(ProductAssets products) {
        //Scanner to prompt user for product name
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        //while(infinite) until correct product name entered
        while(running) {
            System.out.print("What is the product name? ");
            String input = scanner.next();
            //If(name entered matches the array) - Display its contents and exit program
            for(int i = 0; i < products.returnArrayLength(); i++) {
                if(input.contentEquals(products.returnName(i))) {
                    System.out.println("Name: " + products.returnName(i));
                    System.out.println("Price: " + products.returnPrice(i));
                    System.out.println("Quantity: " + products.returnQuantity(i));
                    System.exit(0);
                }
            }
            //else { sout(name was not found) }
            System.out.println("Sorry, that product was not found in our inventory.");
        }
    }
}
