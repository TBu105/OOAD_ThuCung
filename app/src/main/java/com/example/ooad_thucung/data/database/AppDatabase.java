package com.example.ooad_thucung.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ooad_thucung.data.dao.ProductDAO;
import com.example.ooad_thucung.data.dao.UserDAO;
import com.example.ooad_thucung.data.model.Product;
import com.example.ooad_thucung.data.model.User;

@Database(entities = {User.class, Product.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "db_thucung")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract UserDAO userDAO();
    public abstract ProductDAO productDAO();
}
