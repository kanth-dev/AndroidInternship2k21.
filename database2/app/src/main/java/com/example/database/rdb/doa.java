package com.example.database.rdb;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface doa {
    @Insert
    void insert(rtable rtable);
    @Query("Select * from rtable")
    LiveData<List<rtable>>readAll();
    @Update
    void update(rtable rtable);
    @Delete
    void  delete(rtable rtable);

}
