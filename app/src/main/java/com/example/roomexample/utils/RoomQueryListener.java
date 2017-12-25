package com.example.roomexample.utils;

import com.example.roomexample.db.User;

import java.util.List;

/**
 * Created by piyush on 25/12/17.
 */

public interface RoomQueryListener {
    void onSuccess(List<User> userList);
}
