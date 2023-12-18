package com.example.ooad_thucung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NamAdminActivity extends AppCompatActivity {
    Button btnBackAddSV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nam_admin);

        btnBackAddSV =(Button) findViewById(R.id.btnBackAddSV);

        addEvent();
    }
    public void addEvent() {
        btnBackAddSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Intent intent = getIntent();
        if (intent != null) {
            String data = intent.getStringExtra("key");
            // Xử lý dữ liệu nhận được tại đây
        }

    }


}