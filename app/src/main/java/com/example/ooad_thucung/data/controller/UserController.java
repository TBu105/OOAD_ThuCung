package com.example.ooad_thucung.data.controller;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ooad_thucung.data.dao.UserDAO;
import com.example.ooad_thucung.data.database.AppDatabase;
import com.example.ooad_thucung.data.model.User;

import java.util.List;
import java.util.NoSuchElementException;

import at.favre.lib.crypto.bcrypt.BCrypt;


public class UserController {
    private Context context;

    public UserController(Context context) {
        this.context = context;
    }

    public Boolean createUser(User user) {
        User checkUserExist = getUserByUserPhoneNumber(user.getUserphonenumber());

        if (checkUserExist != null) {
            return false;
        }

        String hashedPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(hashedPassword);

        AppDatabase.getInstance(context).userDAO().insert(user);

        Log.d("insert", "insert successfully");
        return true;
    }

    public User getUserByUserPhoneNumber(String userPhoneNumber) {
        User user = AppDatabase.getInstance(context).userDAO().getUserByUserPhoneNumber(userPhoneNumber);

        return user;
    }

    public boolean checkLogin(String userInputPhoneNumber, String userInputPassword) {
        User checkUserExist = AppDatabase.getInstance(context).userDAO().getUserByUserPhoneNumber(userInputPhoneNumber);

        if (checkUserExist == null) {
            throw new NoSuchElementException("There is no user exist with this phone number");
        }

        String password = checkUserExist.getPassword();

        boolean passwordMatches = BCrypt.verifyer().verify(userInputPassword.toCharArray(), password).verified;

        if (!passwordMatches) {
            throw new NoSuchElementException("User Phone Number or Password not match");
        }

        return passwordMatches;
    }

    public Boolean createAdmin(User admin) {
        // Kiểm tra xem người dùng với số điện thoại này đã tồn tại chưa
        User checkAdminExist = getUserByUserPhoneNumber(admin.getUserphonenumber());

        if (checkAdminExist != null) {
            return false;
        }

        // Băm mật khẩu trước khi lưu vào cơ sở dữ liệu
        String hashedPassword = BCrypt.withDefaults().hashToString(12, admin.getPassword().toCharArray());
        admin.setPassword(hashedPassword);

        // Lưu người dùng vào cơ sở dữ liệu
        AppDatabase.getInstance(context).userDAO().insert(admin);

        Log.d("insert", "insert admin successfully");
        return true;
    }
}
