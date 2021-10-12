package ex44;


import com.google.gson.annotations.SerializedName;

public class Products {
    //Fields for name, price, and quantity of each object
    @SerializedName("name")
    String mName;
    @SerializedName("price")
    double mPrice;
    @SerializedName("quantity")
    int mQuantity;

    //Set all input values when called to the fields
        //Products(inputs) {set to fields}
    public Products(String name, double price, int quantity) {
        mName = name;
        mPrice = price;
        mQuantity = quantity;
    }

}
