package com.example.ooad_thucung.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "userphonenumber")
    private String userphonenumber;

    @ColumnInfo(name = "password")
    private String password;

    // Constructors
    public User() {
        // Default constructor required by Room
    }

    public User(String userphonenumber, String password) {
        this.userphonenumber = userphonenumber;
        this.password = password;
    }

    public String getUserphonenumber() {
        return userphonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setUserphonenumber(String userphonenumber) {
        this.userphonenumber = userphonenumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
