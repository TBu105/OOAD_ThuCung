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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    UserController userController = new UserController(this);
    ProductController productController = new ProductController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Hàm tạo người dùng
//        đăng ký thành công trả về true, thất bại false
//        createUser();

//        Hàm đăng nhập
//        đăng nhập thành công trả về true, thất bại false
//        boolean checkUser = authUser();

//        Log.d("TAG", String.valueOf(checkUser));

//        Hàm lấy thông tin người dùng với số điện thoại của người đó
//        Giá trị trả về một user nếu có, hoặc null nếu không có user
//        User userWithPhone = getUserByUserPhoneNumber();

//        Hàm tạo sản phẩm
//        Tạo thành công trả true, thất bại false
//        createProduct();

//        Hàm lấy sản phẩm theo tên
//        Trả về null nếu không có sp trong db, và product nếu có
//        Product requestProduct = getProductByProductName();
//
//        Hàm xóa sản phẩm theo tên
//        Nếu xóa thành công true, ngược lại false
//        Boolean deleteProduct = deleteProductByProductName();

//        Hàm lấy danh sách sản phẩm
//        trả về danh sách sản phẩm, hoặc trả về danh sách rỗng
//        List<Product> allProducts = getAllProduct();
//        Log.d("check", allProducts.toString());
    }

    private Boolean createUser() {
        String userPhoneNumber = "0942806400";
        String userPassword = "matkhau";

        User customer = new User(userPhoneNumber, userPassword);

        return userController.createUser(customer);
    }

    private boolean authUser() {
        String userPhoneNumber = "0942806400";
        String userPassword = "matkhau";

        return userController.checkLogin(userPhoneNumber, userPassword);
    }

    private User getUserByUserPhoneNumber() {
        String userPhoneNumber = "0942806400";

        return userController.getUserByUserPhoneNumber(userPhoneNumber);
    }

    private Boolean createProduct() {
        String productName = "de thuong";
        String sex = "female";
        int productPrice = 230;
        String origin = "usa";
        String age = "2 months";
        String weight = "0.3 kg";
        String type = "poodle";
        String categorytype = "dog";

        Product product = new Product(productName, sex, productPrice, origin, age, weight, type, categorytype);

        return productController.createProduct(product);
    }

    private Product getProductByProductName() {
        String productName = "poodle";

        return productController.getProductByProductName(productName);
    }

    private boolean deleteProductByProductName() {
        String productName = "de thuong";

        return productController.deleteProduct(productName);
    }

    private List<Product> getAllProduct() {

        return productController.getAllProduct();
    }
}