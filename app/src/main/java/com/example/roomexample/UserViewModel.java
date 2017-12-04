package com.example.roomexample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.roomexample.db.AppDatabase;
import com.example.roomexample.db.User;

import java.util.List;

/**
 * Created by piyush on 26/12/17.
 */

public class UserViewModel extends AndroidViewModel {
    private LiveData<List<User>> userList;
    private AppDatabase appDatabase;

    public UserViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(application);
        userList = appDatabase.userDao().getAll();
    }
    public LiveData<List<User>> getUserList(){
        return userList;
    }
}
