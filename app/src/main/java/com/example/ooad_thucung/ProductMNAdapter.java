package com.example.ooad_thucung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ooad_thucung.data.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMNAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<ProductMN> productList;

    public ProductMNAdapter(Context context, int layout_product, ArrayList<ProductMN> productArrayList) {
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
    }
}
