package com.example.ooad_thucung;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.ooad_thucung.data.controller.ProductController;
import com.example.ooad_thucung.data.dao.ProductDAO;
import com.example.ooad_thucung.data.model.Product;
import java.util.ArrayList;

public class ProductManagement extends AppCompatActivity {

    Button btnAdd, btnDelete;
    ListView lvProduct;
    ProductMNAdapter adapter;
    ArrayList<Product> productArrayList =  new ArrayList<>();
    ProductController productController = new ProductController(this);;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_management);
        addControl();
        addEvent();
        lvProduct =(ListView) findViewById(R.id.lvProduct);
        adapter = new ProductMNAdapter(this,R.layout.layout_product, productArrayList );
        lvProduct.setAdapter(adapter);

        productArrayList.clear();
        productArrayList.addAll(productController.getAllProduct());
        if(adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void addControl(){
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
    }

    public void addEvent() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddProduct.class);
                startActivity(intent);
            }
        });

    }
    private Boolean createProduct() {
        String productName = "Test36";
        String sex = "Malefef";
        int productPrice = 230;
        String origin = "VN";
        String age = "5 months";
        String weight = "0.8 kg";
        String type = "Cats";
        String categorytype = "dog";

        Product product = new Product(productName, sex, productPrice, origin, age, weight, type, categorytype);

        return productController.createProduct(product);
    }
}