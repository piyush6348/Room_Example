package com.example.roomexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.roomexample.adapter.UserAdapter;
import com.example.roomexample.db.AppDatabase;
import com.example.roomexample.db.User;
import com.example.roomexample.utils.DatabaseInitializer;
import com.example.roomexample.utils.RoomQueryListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUsers = (RecyclerView) findViewById(R.id.rv_users);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));

        DatabaseInitializer.populateAsync(AppDatabase.getDatabase(this),
                new RoomQueryListener() {
                    @Override
                    public void onSuccess(List<User> userList) {
                        UserAdapter userAdapter = new UserAdapter(MainActivity.this,userList);
                        rvUsers.setAdapter(userAdapter);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
