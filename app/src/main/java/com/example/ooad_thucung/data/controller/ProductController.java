package com.example.ooad_thucung.data.controller;

import android.content.Context;
import android.util.Log;

import com.example.ooad_thucung.data.database.AppDatabase;
import com.example.ooad_thucung.data.model.Product;
import com.example.ooad_thucung.data.model.User;

import java.util.List;
import java.util.NoSuchElementException;


public class ProductController {
    private Context context;

    public ProductController(Context context) {
        this.context = context;
    }

    public Boolean createProduct(Product product) {
        Product checkProduct = getProductByProductName(product.getProductName());

        if (checkProduct != null) {
            return false;
        }

        AppDatabase.getInstance(context).productDAO().insert(product);
        Log.d("insert", "insert product successfully");

        return true;
    }

    public Product getProductByProductName(String productName) {
        Product product = AppDatabase.getInstance(context).productDAO().findProductByName(productName);

        return product;
    }

    public boolean deleteProduct(String productName) {
        Product product = AppDatabase.getInstance(context).productDAO().findProductByName(productName);

        if(product == null) {
            return false;
        }

        AppDatabase.getInstance(context).productDAO().delete(product);
        Log.d("delete", "delete successfully");
        return true;
    }

    public List<Product> getAllProduct() {

        return AppDatabase.getInstance(context).productDAO().getAllProuduct();
    }
}
