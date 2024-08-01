package com.example.organizer.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.example.organizer.database.dao.CategoryDao;
import com.example.organizer.database.dao.TaskDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public AppDatabase provide(@ApplicationContext Context context) {
        // Log to confirm database creation
        Log.d("DatabaseModule", "Building database instance");
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "Organiser_task.db")
                .fallbackToDestructiveMigration()
                .build();
        Log.d("DatabaseModule", "Database instance created");
        return db;
    }

    @Provides
    @Singleton
    public TaskDao provideTaskDao(AppDatabase database) {
        return database.itemDao();
    }

    @Provides
    @Singleton
    public CategoryDao provideCategoryDao(AppDatabase database) {
        return database.categoryDao();
    }
}


