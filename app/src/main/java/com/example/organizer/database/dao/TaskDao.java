package com.example.organizer.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.organizer.entity.Task;
import com.example.organizer.entity.TaskWithCategory;

import java.util.List;

@Dao
public interface TaskDao {

    @Transaction
    @Query("SELECT * FROM tasks")
    LiveData<List<TaskWithCategory>> getAllTasksWithCategories();

    @Insert
    long insert(Task task);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);
}
