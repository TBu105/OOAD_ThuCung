package com.example.ooad_thucung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ooad_thucung.data.controller.UserController;
import com.example.ooad_thucung.data.model.User;

import java.util.NoSuchElementException;

public class LoginActivity extends AppCompatActivity {

    private UserController userController;

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userController = new UserController(this);

        edtUsername = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Tạo người dùng mặc định khi khởi động ứng dụng
        createUser();

        createAdmin();;
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy tên đăng nhập và mật khẩu từ EditText
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                // Kiểm tra đăng nhập và vai trò của người dùng
                boolean loginSuccess = logIn(username, password);

                if (loginSuccess) {
                    // Nếu đăng nhập thành công và không phải là 'user', chuyển đến MainActivity
                    if (!checkAdmin(username)) {
                        Intent intent = new Intent(LoginActivity.this, HomePage.class);
                        startActivity(intent);
                        finish(); // Đóng LoginActivity để không cho người dùng quay lại nếu đã đăng nhập
                    } else {
                        Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    // Hiển thị thông báo lỗi đăng nhập thất bại (có thể sử dụng Toast)
                    Toast.makeText(LoginActivity.this, "Login failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Hàm đăng nhập
    // Trả về true nếu đăng nhập thành công, false nếu thất bại
    private boolean logIn(String userInputPhoneNumber, String userInputPassword) {
        try {
            // Gọi hàm kiểm tra đăng nhập từ UserController
            return userController.checkLogin(userInputPhoneNumber, userInputPassword);
        } catch (NoSuchElementException e) {
            // Xử lý lỗi, có thể hiển thị thông báo hoặc ghi log
            e.printStackTrace();
            return false;
        }
    }


    // Hàm tạo người dùng mặc định
    private void createUser() {
        String defaultUserPhoneNumber = "user1@gmail.com";
        String defaultUserPassword = "matkhauuser";

        // Kiểm tra xem người dùng có sẵn không trước khi tạo
        User existingUser = userController.getUserByUserPhoneNumber(defaultUserPhoneNumber);
        if (existingUser == null) {
            // Tạo đối tượng User cho người dùng mặc định
            User defaultUser = new User(defaultUserPhoneNumber, defaultUserPassword);

            // Gọi hàm tạo người dùng từ đối tượng điều khiển người dùng và trả kết quả
            boolean createUserResult = userController.createUser(defaultUser);

            if (createUserResult) {
                // Hiển thị thông báo tạo người dùng mặc định thành công (có thể sử dụng Toast)
                Toast.makeText(this, "Default user created successfully.", Toast.LENGTH_SHORT).show();
            } else {
                // Hiển thị thông báo lỗi tạo người dùng mặc định (có thể sử dụng Toast)
                Toast.makeText(this, "Failed to create default user.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void createAdmin() {
        String adminPhoneNumber = "admin1@gmail.com";
        String adminPassword = "matkhauadmin";

        // Kiểm tra xem admin đã tồn tại chưa
        User existingAdmin = userController.getUserByUserPhoneNumber(adminPhoneNumber);
        if (existingAdmin == null) {
            // Tạo đối tượng User cho admin
            User adminUser = new User(adminPhoneNumber, adminPassword);

            // Gọi hàm tạo admin từ đối tượng điều khiển người dùng và kiểm tra kết quả
            boolean createAdminResult = userController.createAdmin(adminUser);

            if (createAdminResult) {
                // Hiển thị thông báo tạo admin thành công (có thể sử dụng Toast)
                Toast.makeText(this, "Admin created successfully.", Toast.LENGTH_SHORT).show();
            } else {
                // Hiển thị thông báo lỗi tạo admin (có thể sử dụng Toast)
                Toast.makeText(this, "Failed to create admin.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Thêm hàm checkAdmin
    private boolean checkAdmin(String username) {
        // Kiểm tra xem tên đăng nhập có chứa chuỗi 'admin' hay không
        return username.toLowerCase().contains("admin");
    }
}
