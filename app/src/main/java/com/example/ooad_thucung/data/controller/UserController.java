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

    public void createUser(User user) {
        String hashedPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(hashedPassword);

        AppDatabase.getInstance(context).userDAO().insert(user);
        Log.d("insert", "insert successfully");
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
}
