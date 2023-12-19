package com.example.ooad_thucung;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.ListView;
<<<<<<< HEAD

=======
import android.widget.Toast;

import com.example.ooad_thucung.data.controller.ProductAdapter;
>>>>>>> 278736e (Add and delete product)
import com.example.ooad_thucung.data.controller.ProductController;
import com.example.ooad_thucung.data.dao.ProductDAO;
import com.example.ooad_thucung.data.model.Product;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 278736e (Add and delete product)

public class ProductManagement extends AppCompatActivity {
    Button btnAdd, btnDelete;
    ImageView imgBack;
    ListView lvProduct;
    ProductMNAdapter adapter;
<<<<<<< HEAD
    ArrayList<ProductMN> productMNArrayList;
=======
    ProductController productController;
    //ArrayList<Product> productArrayList;
    ArrayList<Product> productList = new ArrayList<>();
>>>>>>> 278736e (Add and delete product)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_management);
        addControl();
        addEvent();

        lvProduct =(ListView) findViewById(R.id.lvProduct);
<<<<<<< HEAD
        productMNArrayList = new ArrayList<>();

        productMNArrayList.add(new ProductMN(Product.class.getName(),R.drawable.img_1));

        adapter = new ProductMNAdapter(this,R.layout.layout_product, productMNArrayList );
        lvProduct.setAdapter(adapter);
=======
        productController = new ProductController(this);
        //productArrayList = new ArrayList<>();
        //productArrayList.add(new Product(Product.class.getName(),));

        adapter = new ProductMNAdapter(this,R.layout.layout_product, productList );
        lvProduct.setAdapter(adapter);

        productList.clear();
        productList.addAll(productController.getAllProduct());
        adapter.notifyDataSetChanged();

>>>>>>> 278736e (Add and delete product)
    }

    public void addControl(){
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        imgBack = (ImageView) findViewById(R.id.imgBack);
    }

    public void addEvent(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddProduct.class);
                startActivity(intent);
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
                startActivity(intent);
            }
        });

<<<<<<< HEAD
=======

>>>>>>> 278736e (Add and delete product)
    }


}