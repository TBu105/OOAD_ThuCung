package com.example.ooad_thucung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ooad_thucung.data.controller.ProductAdapter;
import com.example.ooad_thucung.data.controller.ProductController;
import com.example.ooad_thucung.data.model.Product;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AddProduct extends AppCompatActivity {

    Spinner spinnerSpecies;
    Spinner spinnerGender;
    EditText edtName, edtPrice, edtQuantity, edtOrigin, edtAge, edtWeight;
    Button btnSave, btnCancel;
    List<String> listSpecies = new ArrayList<>();
    List<String> listGender = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    ProductMNAdapter adapter;
    ProductController productController = new ProductController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        addControl();
        addEvent();
    }

    public void addControl(){
        spinnerSpecies = (Spinner) findViewById(R.id.spinnerSpecies);
        spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
        edtAge = (EditText) findViewById(R.id.edtAge);
        edtPrice = (EditText) findViewById(R.id.edtPrice);
        edtName = (EditText) findViewById(R.id.edtName);
        edtQuantity = (EditText) findViewById(R.id.edtQuantity);
        edtOrigin = (EditText) findViewById(R.id.edtOrigin);
        edtWeight = (EditText) findViewById(R.id.edtWeight);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnSave = (Button) findViewById(R.id.btnSave);
    }

    public void addEvent(){
        spinnerSpecies.setAdapter(adapter);
        listSpecies.add("cat");
        listSpecies.add("dog");
        listSpecies.add("bird");
        listSpecies.add("other");
        listGender.add("Male");
        listGender.add("Female");
        ArrayAdapter<String>adapterSp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,listSpecies);
        spinnerSpecies.setAdapter(adapterSp);
        ArrayAdapter<String>adapterGe = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,listGender);
        spinnerGender.setAdapter(adapterGe);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = edtName.getText().toString().trim();
                String sex = spinnerGender.toString().trim();
                int productPrice = edtPrice.getText().length();
                String origin = edtOrigin.getText().toString().trim();
                String age = edtAge.getText().toString().trim();
                String weight = edtWeight.getText().toString().trim();
                String type = "type";
                String categorytype = spinnerSpecies.toString().trim();

                if (!productName.isEmpty()) {
                    Product newProduct = new Product(productName, sex,productPrice,origin,age,weight,type,categorytype);
                    boolean isAdded = productController.createProduct(newProduct);

                    if (isAdded) {
                        Intent intent = new Intent(getApplicationContext(),ProductManagement.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Sản phẩm đã tồn tại!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập tên sản phẩm!", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),ProductManagement.class);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ProductManagement.class);
                startActivity(intent);
            }
        });
    }

}
