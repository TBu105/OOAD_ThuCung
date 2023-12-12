package com.example.ooad_thucung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AddProduct extends AppCompatActivity {

    Spinner spinnerSpecies;
    List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        addControl();
        addEvent();
    }

    public void addControl(){
        spinnerSpecies = (Spinner) findViewById(R.id.spinnerSpecies);
    }

    public void addEvent(){
        list.add("cat");
        list.add("dog");
        list.add("bird");
        list.add("other");
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list);
        spinnerSpecies.setAdapter(adapter);
    }
}