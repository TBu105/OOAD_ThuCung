package com.example.ooad_thucung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    GridView gvAdmin;
    ArrayList<Admin>adminArrayList;
    AdminAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        gvAdmin =(GridView) findViewById(R.id.gvAdmin);
        adminArrayList = new ArrayList<>();

        adminArrayList.add(new Admin("PRODUCT \nMANAGEMENT",R.drawable.productmn));
        adminArrayList.add(new Admin("SERVICE \nMANAGEMENT",R.drawable.servicemn));
        adminArrayList.add(new Admin("USER \nMANAGEMENT",R.drawable.usermn));
        adminArrayList.add(new Admin("APPOINTMENT \nSCHEDULE",R.drawable.apointmentmn));

        adapter = new AdminAdapter(this,R.layout.layout_admin, adminArrayList );
        gvAdmin.setAdapter(adapter);



    }
}