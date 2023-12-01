package com.example.ooad_thucung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.ooad_thucung.data.controller.ProductController;
import com.example.ooad_thucung.data.controller.UserController;
import com.example.ooad_thucung.data.database.AppDatabase;
import com.example.ooad_thucung.data.model.Product;
import com.example.ooad_thucung.data.model.User;

public class MainActivity extends AppCompatActivity {

    UserController userController = new UserController(this);
    ProductController productController = new ProductController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Hàm tạo người dùng
//        createUser();

//        Hàm đăng nhập
//        boolean checkUser = authUser();
//        Log.d("wind", String.valueOf(checkUser));


//        Hàm lấy thông tin người dùng với số điện thoại của người đó
//        User userWithPhone = getUserByUserPhoneNumber();

//        Hàm tạo sản phẩm
//        createProduct();

//        Hàm lấy sản phẩm theo tên
//        Product requestProduct = getProductByProductName();
//
//        Hàm xóa sản phẩm theo tên
//        deleteProductByProductName();

    }

    private void createUser() {
        String userPhoneNumber = "0942806400";
        String userPassword = "matkhau";

        User user = new User(userPhoneNumber, userPassword);

        userController.createUser(user);
    }

    private boolean authUser() {
        String userPhoneNumber = "0942806400";
        String userPassword = "matkhau";

        boolean userExist = userController.checkLogin(userPhoneNumber, userPassword);

        return userExist;
    }

    private User getUserByUserPhoneNumber() {
        String userPhoneNumber = "0942806400";

        User user = userController.getUserByUserPhoneNumber(userPhoneNumber);

        return user;
    }

    private void createProduct() {
        String productName = "de thuong";
        String sex = "female";
        int productPrice = 230;
        String origin = "usa";
        String age = "2 months";
        String weight = "0.3 kg";
        String type = "poodle";
        String categorytype = "dog";

        Product product = new Product(productName, sex, productPrice, origin, age, weight, type, categorytype);

        productController.createProduct(product);
    }

    private Product getProductByProductName() {
        String productName = "poodle";
        Product product = productController.getProductByProductName(productName);

        return product;
    }

    private void deleteProductByProductName() {
        String productName = "de thuong";

        productController.deleteProduct(productName);
    }
}