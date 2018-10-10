package com.example.android.movieapponetestone;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.android.movieapponetestone.model.Popular;

import java.util.List;


@Dao
public interface FavDao {
    @Query("SELECT * FROM fav")
    LiveData<List<Popular>> loadAllTasks();

    @Insert
    void insertTask(Popular taskEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(Popular taskEntry);

    @Delete
    void deleteTask(Popular taskEntry);

    @Query("SELECT * FROM fav WHERE id = :id")
    LiveData<Popular> loadTaskById(int id);
}
