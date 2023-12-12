package com.example.ooad_thucung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductManagement extends AppCompatActivity {
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_management);
        addControl();
        addEvent();
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