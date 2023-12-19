package com.example.ooad_thucung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
<<<<<<< HEAD
import android.widget.ImageView;
import android.widget.TextView;

=======
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ooad_thucung.data.controller.ProductController;
>>>>>>> 278736e (Add and delete product)
import com.example.ooad_thucung.data.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMNAdapter extends BaseAdapter {
    Context context;
    int layout;
<<<<<<< HEAD
    List<ProductMN> productList;

    public ProductMNAdapter(Context context, int layout_product, ArrayList<ProductMN> productArrayList) {
=======
    List<Product> productList;
    ProductController productController ;

    public ProductMNAdapter(Context context, int layout_product, ArrayList<Product> productArrayList) {
>>>>>>> 278736e (Add and delete product)
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
<<<<<<< HEAD
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layout, parent, false);
        }

        TextView tvProductName = convertView.findViewById(R.id.tvProductName);
        ImageView imgProduct = convertView.findViewById(R.id.imgProduct);

        if (productList != null && productList.size() > position) {
            ProductMN productMN = productList.get(position);
            if (productMN != null) {
                tvProductName.setText(productMN.getProductName());
                imgProduct.setImageResource(productMN.getImgProduct());
            }
        }

        return convertView;
=======
        View listItem = convertView;
        productController = new ProductController(context);
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.layout_product, parent, false);
        }

        Product currentProduct = productList.get(position);

        TextView productName = listItem.findViewById(R.id.tvProductName);
        ImageView imgProduct = (ImageView) listItem.findViewById(R.id.imgProduct) ;
        Button btnDelete = (Button) listItem.findViewById(R.id.btnDelete);
        productName.setText(currentProduct.getProductName());
        imgProduct.setImageResource(R.drawable.img_1);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

//        if (convertView == null) {
//            LayoutInflater inflater = LayoutInflater.from(context);
//            convertView = inflater.inflate(layout, parent, false);
//        }
//
//        TextView tvProductName = convertView.findViewById(R.id.tvProductName);
//        ImageView imgProduct = convertView.findViewById(R.id.imgProduct);
//
//        if (productList != null && productList.size() > position) {
//            Product product = productList.get(position);
//            if (product != null) {
//                tvProductName.setText(product.getProductName());
//                imgProduct.setImageResource(R.drawable.img_1);
//            }
//        }
//
//        return convertView;
>>>>>>> 278736e (Add and delete product)
    }
}
