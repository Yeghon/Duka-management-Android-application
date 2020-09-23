package com.android.myduka.model;

/**
 * @author yeghon on 12/10/19
 * @project Myduka
 */
public class MyDukaProducts {
//    protected String name;
    public String productName, productPrice, productStock;

    public MyDukaProducts(String productName, String productPrice, String productStock) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
}