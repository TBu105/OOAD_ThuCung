package com.example.ooad_thucung.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ooad_thucung.data.model.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM user ORDER BY id DESC")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM user WHERE userphonenumber = :userphonenumber")
    User getUserByUserPhoneNumber(String userphonenumber);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
