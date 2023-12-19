package com.example.ooad_thucung;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ooad_thucung.data.controller.ProductAdapter;
import com.example.ooad_thucung.data.controller.ProductController;
import com.example.ooad_thucung.data.model.Product;

import java.util.List;

public class HomePage extends AppCompatActivity {

    ProductController productController = new ProductController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        createProduct();

        // Get all products
        List<Product> products = productController.getAllProduct();
        Log.d("producttag", products.toString());


// Create an instance of the custom ArrayAdapter
        ProductAdapter adapter = new ProductAdapter(this, products);

// Get a reference to the ListView, and attach the adapter to the ListView
        ListView listView = (ListView) findViewById(R.id.lvItems);
        listView.setAdapter(adapter);

    }

    private Boolean createProduct() {
        String productName = "Alaska";
        String sex = "female";
        int productPrice = 230;
        String origin = "usa";
        String age = "2 months";
        String weight = "0.3 kg";
        String type = "poodle";
        String categorytype = "dog";

        Product product = new Product(productName, sex, productPrice, origin, age, weight, type, categorytype);

        return productController.createProduct(product);
    }

}