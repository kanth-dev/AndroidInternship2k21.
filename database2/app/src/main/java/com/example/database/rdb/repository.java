package com.example.database.rdb;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import java.util.List;

public class repository {
    RoomDatabase roomDatabase;
    LiveData<List<rtable>> list;
    public repository(Application application){
       roomDatabase = databaseroom.getroomDatabase(application);
        list=databaseroom.doa().readAll();


    }
    class InsertTask extends AsyncTask<rtable,Void,Void>{

        @Override
        protected Void doInBackground(com.example.database.rdb.rtable... rtables) {
            for (int i=0;i<rtables.length;i++){
                roomDatabase.
                }
            return null;
        }
    }
}
