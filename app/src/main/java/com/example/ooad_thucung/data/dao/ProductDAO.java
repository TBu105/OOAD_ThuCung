package com.example.ooad_thucung.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ooad_thucung.data.model.Product;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    void insert(Product product);

    @Query("SELECT * FROM product WHERE productName = :productName")
    Product findProductByName(String productName);

    @Delete
    void delete(Product product);
}
