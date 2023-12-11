package com.example.ooad_thucung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class AdminAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Admin> adminList;

    public AdminAdapter(Context context, int layout_admin, ArrayList<Admin> adminArrayList) {
        this.context = context;
        this.layout = layout_admin;
        this.adminList = adminArrayList;
    }


    @Override
    public int getCount() {
        return adminList.size();
    }

    @Override
    public Object getItem(int position) {
        return adminList.get(position);
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

        TextView tvAdminMN = convertView.findViewById(R.id.tvName);
        ImageView imgAdminMN = convertView.findViewById(R.id.imgAdminMN);

        if (adminList != null && adminList.size() > position) {
            Admin admin = adminList.get(position);
            if (admin != null) {
                tvAdminMN.setText(admin.getNameMN());
                imgAdminMN.setImageResource(admin.getImgMN());
            }
        }

        return convertView;
    }

}
