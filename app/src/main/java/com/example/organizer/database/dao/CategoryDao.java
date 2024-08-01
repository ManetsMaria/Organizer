package com.example.organizer.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.organizer.entity.Category;

import java.util.List;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM categories")
    LiveData<List<Category>> getAllTasksWithCategories();

    //TODO if add more fields to category it will be more optimal to check if category exist than just replace
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Category task);

    @Update
    void update(Category task);

    @Delete
    void delete(Category task);
}
