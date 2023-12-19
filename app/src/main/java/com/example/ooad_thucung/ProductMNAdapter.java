package com.example.ooad_thucung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ooad_thucung.data.controller.ProductController;
import com.example.ooad_thucung.data.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMNAdapter extends BaseAdapter {
    Context context;
    Button btnDelete;
    int layout;
    List<Product> productList;
    ProductController productController ;


    public ProductMNAdapter(Context context, int layout_product, ArrayList<Product> productArrayList) {
        this.context = context;
        this.layout = layout_product;
        this.productList= productArrayList;
    }


    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;
        productController = new ProductController(context);
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.layout_product, parent, false);
        }
        Product currentProduct = productList.get(position);

        TextView productName = listItem.findViewById(R.id.tvProductName);
        productName.setText(currentProduct.getProductName());

        btnDelete = (Button) listItem.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xác định sản phẩm được chọn để xóa
                Product productToDelete = productList.get(position);

                // Xóa sản phẩm từ cơ sở dữ liệu
                boolean isDeleted = productController.deleteProduct(productToDelete.getProductName());

                if (isDeleted) {
                    productList.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(context, "Đã xóa sản phẩm", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Không thể xóa sản phẩm", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return listItem;
    }
}
