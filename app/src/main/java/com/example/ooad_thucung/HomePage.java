package com.example.ooad_thucung;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ooad_thucung.data.controller.ProductAdapter;
import com.example.ooad_thucung.data.controller.ProductController;
import com.example.ooad_thucung.data.model.Product;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    Button btnCat,btnDog;

    ProductController productController = new ProductController(this);

    List<Product> allProducts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        createProduct();

        // Get all products
        allProducts = productController.getAllProduct();

        // Initially show all products
        updateListView(allProducts);

        btnCat = (Button) findViewById(R.id.btnCat);
        btnDog = (Button) findViewById(R.id.btnDog);

        addEvent();
    }

    public void addEvent(){
        btnDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Product> catProducts = filterProductsByCategory("dog");
                updateListView(catProducts);

            }
        });
        // Button for filtering cat products
        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Product> catProducts = filterProductsByCategory("cat");
                updateListView(catProducts);
            }
        });
    }

    // Method to filter products by categorytype
    private List<Product> filterProductsByCategory(String categoryType) {
        List<Product> filteredList = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getCategorytype().equals(categoryType)) {
                filteredList.add(product);
            }
        }
        return filteredList;
    }

    // Method to update the ListView with given products
    private void updateListView(List<Product> products) {
        ProductAdapter adapter = new ProductAdapter(this, products);
        ListView listView = findViewById(R.id.lvItems);
        listView.setAdapter(adapter);
    }

    private Boolean createProduct() {
        String productName = "Test36";
        String sex = "Malefeegergf";
        int productPrice = 230;
        String origin = "VN";
        String age = "5 months";
        String weight = "0.8 kg";
        String type = "Cats";
        String categorytype = "cat";

        Product product = new Product(productName, sex, productPrice, origin, age, weight, type, categorytype);

        return productController.createProduct(product);
    }

}