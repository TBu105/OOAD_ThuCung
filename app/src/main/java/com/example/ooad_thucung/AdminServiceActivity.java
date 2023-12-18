package com.example.ooad_thucung;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminServiceActivity extends AppCompatActivity {

    Button btnEditSV, btnDeleteSV, btnEditSV2, getBtnDeleteSV2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_service);


        btnEditSV =(Button) findViewById(R.id.btnEditSV);
        btnDeleteSV =(Button) findViewById(R.id.btnDeleteSV);

        btnEditSV2 =(Button) findViewById(R.id.btnEditSV2);
        getBtnDeleteSV2 =(Button) findViewById(R.id.btnEditSV2);


        addEvent();
    }
    public void addEvent()
    {
        btnEditSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminServiceActivity.this, NamAdminActivity.class);
                startActivity(intent);
            }
        });

        btnEditSV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminServiceActivity.this, NamAdminActivity.class);
                startActivity(intent);
            }
        });

        btnDeleteSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo AlertDialog.Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminServiceActivity.this);

                // Thiết lập tiêu đề và thông điệp cho dialog
                builder.setTitle("DELETE")
                        .setMessage("This Service and all information will be removed");

                // Thiết lập nút Yes
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Xử lý xóa ở đây (nếu cần)
                        // Ví dụ: Xóa dữ liệu hoặc thực hiện hành động xóa nào đó
                        dialog.dismiss(); // Đóng dialog sau khi xác nhận Yes
                    }
                });

                // Thiết lập nút No
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Đóng dialog khi chọn No
                    }
                });

                // Tạo và hiển thị dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}