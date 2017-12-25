package com.example.roomexample.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.roomexample.db.AppDatabase;
import com.example.roomexample.db.User;

import java.util.List;

/**
 * Created by piyush on 25/12/17.
 */

public class DatabaseInitializer {
    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db, RoomQueryListener rql) {

        PopulateDbAsync task = new PopulateDbAsync(db,rql);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static User addUser(final AppDatabase db, User user) {
        db.userDao().insertAll(user);
        return user;
    }

    private static List<User> populateWithTestData(AppDatabase db) {
        User user = new User();
        user.setFirstName("Ajay");
        user.setLastName("Saini");
        user.setAge(25);
        addUser(db, user);

        List<User> userList = db.userDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());

        return userList;
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, List<User>> {

        private final AppDatabase mDb;
        private RoomQueryListener roomQueryListener;
        PopulateDbAsync(AppDatabase db, RoomQueryListener rql) {
            mDb = db;
            roomQueryListener = rql;
        }
        @Override
        protected List<User> doInBackground(final Void... params) {
            return populateWithTestData(mDb);
        }


        @Override
        protected void onPostExecute(List<User> userList) {
            super.onPostExecute(userList);
            roomQueryListener.onSuccess(userList);
        }



    }
}

