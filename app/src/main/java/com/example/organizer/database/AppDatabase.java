package com.example.organizer.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.organizer.database.dao.CategoryDao;
import com.example.organizer.database.dao.TaskDao;
import com.example.organizer.entity.Category;
import com.example.organizer.entity.Task;

@Database(entities = {Task.class, Category.class}, version = 1)
//TODO add schema
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao itemDao();
    public abstract CategoryDao categoryDao();
}

