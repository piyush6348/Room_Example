package com.example.roomexample;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.roomexample.adapter.UserAdapter;
import com.example.roomexample.db.AppDatabase;
import com.example.roomexample.db.User;
import com.example.roomexample.utils.DatabaseInitializer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends LifecycleActivity {

    private RecyclerView rvUsers;
    private UserViewModel userViewModel;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Every time onCreate runs a new user is added to db by this
        DatabaseInitializer.populateAsync(AppDatabase.getDatabase(this));

        setUpRV();

        setUpViewModel();

    }

    private void setUpViewModel() {
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        userViewModel.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> userList) {
                Log.e( "onChanged: ", "Db change detected");
                userAdapter.setUserList(userList);
            }
        });
    }

    private void setUpRV() {
        rvUsers = (RecyclerView) findViewById(R.id.rv_users);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(MainActivity.this,new ArrayList<User>());
        rvUsers.setAdapter(userAdapter);
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
