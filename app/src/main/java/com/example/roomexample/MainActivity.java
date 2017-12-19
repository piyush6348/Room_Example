package com.example.roomexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.roomexample.db.AppDatabase;
import com.example.roomexample.utils.DatabaseInitializer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseInitializer.populateAsync(AppDatabase.getDatabase(this));
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
