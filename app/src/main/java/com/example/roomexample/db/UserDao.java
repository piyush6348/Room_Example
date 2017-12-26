package com.example.roomexample.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by piyush on 25/12/17.
 */

// Database Object for CRUD operations
    // Create a data access object using an interface.
    // This class is annotated with @Dao annotation.
    // Room will generate an implementation of defined methods.
    // There are four annotations @Query, @Insert, @Update, @Delete to perform CRUD operations.
    // @Query annotation is used to perform read operation on database.
    @Dao
public interface UserDao {

    @Query("Select * from Users")
    LiveData<List<User>> getAll();

    @Query("Select * from Users where first_name LIKE :firstName and last_name LIKE :lastName")
    User findByName(String firstName, String lastName);

    @Query("Select COUNT(*) from Users")
    int countUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete (User user);
}
