package com.example.database.rdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {rtable.class},version = 1,exportSchema = false)
public abstract class databaseroom extends RoomDatabase {
    public abstract doa dao();
    public static databaseroom databaseroom;
    public synchronized databaseroom getDatabaseroom(Context context){
        if (databaseroom != null) {
            databaseroom= Room.databaseBuilder(context ,databaseroom.class,"myroom").allowMainThreadQueries().build();


        }
        return databaseroom;
    }
}