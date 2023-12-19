package com.example.ooad_thucung.data.controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ooad_thucung.R;
import com.example.ooad_thucung.data.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {


    Context context;
    List<Product> lsHangGio = new ArrayList<>();

    LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> lsHangGio) {
        this.context = context;
        this.lsHangGio = lsHangGio;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lsHangGio.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.home_page_layout, null);


        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
        TextView tvSex = (TextView) convertView.findViewById(R.id.tvSex);
        TextView tvOrigin = (TextView) convertView.findViewById(R.id.tvOrigin);
        TextView tvWeight = (TextView) convertView.findViewById(R.id.tvWeight);
//        TextView tvType = (TextView) convertView.findViewById(R.id.tvType);
        TextView tvAge = (TextView) convertView.findViewById(R.id.tvAge);


        Log.d("TEst", lsHangGio.get(position).getProductName());

        // Populate the data into the template view using the data object
        tvName.setText(lsHangGio.get(position).getProductName());
        tvPrice.setText("Price: " + String.valueOf(lsHangGio.get(position).getProductPrice()));
        tvSex.setText(lsHangGio.get(position).getSex());
        tvOrigin.setText("Origin: "+ lsHangGio.get(position).getOrigin());
        tvWeight.setText("Weight: " + lsHangGio.get(position).getWeight());
//        tvType.setText(lsHangGio.get(position).getType());
        tvAge.setText("Age: "+ lsHangGio.get(position).getAge());


        return convertView;

    }
}

