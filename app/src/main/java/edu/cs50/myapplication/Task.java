package edu.cs50.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface Task {

        @Query("SELECT * FROM ENTITY ORDER BY Priorty")
        LiveData<List<TaskEntity>> loadEntity();

        @Insert
        void insert(TaskEntity entity);

        @Update(onConflict = OnConflictStrategy.REPLACE)
        void update(TaskEntity entity);

        @Delete
        void delete(TaskEntity entity);

        @Query("SELECT * FROM ENTITY WHERE ID = :id")
          LiveData<TaskEntity> loadTask(int id);

    }
