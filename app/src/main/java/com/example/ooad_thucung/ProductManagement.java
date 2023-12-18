package com.example.ooad_thucung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ListView;

import com.example.ooad_thucung.data.controller.ProductController;
import com.example.ooad_thucung.data.dao.ProductDAO;
import com.example.ooad_thucung.data.model.Product;

import java.util.ArrayList;

public class ProductManagement extends AppCompatActivity {
    Button btnAdd;
    ListView lvProduct;
    ProductMNAdapter adapter;
    ArrayList<ProductMN> productMNArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_management);
        addControl();
        addEvent();

        lvProduct =(ListView) findViewById(R.id.lvProduct);
        productMNArrayList = new ArrayList<>();

        productMNArrayList.add(new ProductMN(Product.class.getName(),R.drawable.img_1));

        adapter = new ProductMNAdapter(this,R.layout.layout_product, productMNArrayList );
        lvProduct.setAdapter(adapter);
    }

    public void addControl(){
        btnAdd = (Button) findViewById(R.id.btnAdd);
    }

    public void addEvent(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddProduct.class);
                startActivity(intent);
            }
        });
    }


}