package com.example.ooad_thucung;

public class Admin {
    public String getNameMN() {
        return nameMN;
    }

    public void setNameMN(String nameMN) {
        this.nameMN = nameMN;
    }

    public int getImgMN() {
        return imgMN;
    }

    public void setImgMN(int imgMN) {
        this.imgMN = imgMN;
    }

    public Admin(String nameMN, int imgMN) {
        this.nameMN = nameMN;
        this.imgMN = imgMN;
    }

    public String nameMN;
    public int imgMN;
}
