package com.example.roomexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BindingAdapter;
import android.widget.TextView;

/**
 * Created by piyush on 25/12/17.
 */

// Table in the database

    //Now, lets create an entity called User.
    // It defines a attributes of your table,
    // it is must to declare one field as primary key.
    // It has property to auto generate values.
    // Class is annotated with @Entity and name of the table.
    // To make field primary key,
    // you need to annotate a field with @PrimaryKey and property autoGenerate which assign automatic IDs.
    // Room will create a user table with defined attributes.

    @Entity(tableName = "Users")
public class User {

    //DatabaseColumns
    // Important to have one Primary Key in one Table
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "age")
    private int age;

    // Getters and Setters

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        view.setText(Integer.toString(value));
    }

}
