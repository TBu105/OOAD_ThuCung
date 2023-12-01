package com.example.ooad_thucung.data.controller;

import android.content.Context;
import android.util.Log;

import com.example.ooad_thucung.data.database.AppDatabase;
import com.example.ooad_thucung.data.model.Product;
import com.example.ooad_thucung.data.model.User;

import java.util.NoSuchElementException;


public class ProductController {
    private Context context;

    public ProductController(Context context) {
        this.context = context;
    }

    public void createProduct(Product product) {
        AppDatabase.getInstance(context).productDAO().insert(product);
        Log.d("insert", "insert successfully");
    }

    public Product getProductByProductName(String productName) {
        Product product = AppDatabase.getInstance(context).productDAO().findProductByName(productName);

        if(product == null) {
            throw new NoSuchElementException("There is no product with this name");
        }

        return product;
    }

    public void deleteProduct(String productName) {
        Product product = AppDatabase.getInstance(context).productDAO().findProductByName(productName);

        if(product == null) {
            throw new NoSuchElementException("There is no product with this name");
        }

        AppDatabase.getInstance(context).productDAO().delete(product);
        Log.d("delete", "delete successfully");
    }

}
