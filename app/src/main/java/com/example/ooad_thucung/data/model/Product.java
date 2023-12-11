package com.example.ooad_thucung.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product")
public class Product {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "productName")
    private String productName;

    @ColumnInfo(name = "sex")
    private String sex;

    @NonNull
    @ColumnInfo(name = "productPrice")
    private int productPrice;

    @NonNull
    @ColumnInfo(name = "origin")
    private String origin;

    @ColumnInfo(name = "age")
    private String age;

    @NonNull
    @ColumnInfo(name = "weight")
    private String weight;

    @ColumnInfo(name = "type")
    private String type;

    @NonNull
    @ColumnInfo(name = "categorytype")
    private String categorytype;

    public Product(@NonNull String productName, String sex, int productPrice, @NonNull String origin, String age, @NonNull String weight, String type, @NonNull String categorytype) {
        this.productName = productName;
        this.sex = sex;
        this.productPrice = productPrice;
        this.origin = origin;
        this.age = age;
        this.weight = weight;
        this.type = type;
        this.categorytype = categorytype;
    }

    @NonNull
    public String getProductName() {
        return productName;
    }

    public void setProductName(@NonNull String productName) {
        this.productName = productName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @NonNull
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(@NonNull String origin) {
        this.origin = origin;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @NonNull
    public String getWeight() {
        return weight;
    }

    public void setWeight(@NonNull String weight) {
        this.weight = weight;
    }

    @NonNull
    public String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }

    @NonNull
    public String getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(@NonNull String categorytype) {
        this.categorytype = categorytype;
    }
}
