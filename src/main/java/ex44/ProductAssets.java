package ex44;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductAssets {
    //String field for name
    private String name;
    //Product Object array field for holding the item information
    private Products[] products;

    //ProductAssets(inputs) {assign to fields}
    public ProductAssets(String name, Products[] products) {
        this.name = name;
        this.products = products;
    }

    //Method to display the information of products
    public void displayProducts() {
        //For() loop to handle the length of the object
        for(int i = 0; i < products.length; i++) {
            //Print the infomation of each object
            System.out.println("Product at index " + i + " is " + products[i].mName);
            System.out.println("Price of product at index " + i + " is " + products[i].mPrice);
            System.out.println("Quantity of product at index " + i + " is " + products[i].mQuantity);
            System.out.println("\n");
        }
    }
    //Create methods to return the individual values held in each of the array objects
        //Length, name, price, quantity should all have return methods
    public int returnArrayLength() {
        return products.length;
    }

    public  String returnName(int i) {
        return (String) products[i].mName;
    }
    public double returnPrice(int i) {
        return (double) products[i].mPrice;
    }
    public int returnQuantity(int i) {
        return (int) products[i].mQuantity;
    }



}
