package com.example.ooad_thucung;

public class ProductMN {
    public String productName;
    public int imgProduct;

    public ProductMN(String productName, int imgProduct) {
        this.productName = productName;
        this.imgProduct = imgProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(int imgProduct) {
        this.imgProduct = imgProduct;
    }
}
