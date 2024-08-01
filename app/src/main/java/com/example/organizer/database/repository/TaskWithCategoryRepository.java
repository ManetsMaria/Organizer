package com.example.organizer.database.repository;

import androidx.lifecycle.LiveData;

import com.example.organizer.database.dao.CategoryDao;
import com.example.organizer.database.dao.TaskDao;
import com.example.organizer.entity.TaskWithCategory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class TaskWithCategoryRepository {

    private final TaskDao taskDao;
    private final CategoryDao categoryDao;
    private final ExecutorService executorService;

    @Inject
    public TaskWithCategoryRepository(TaskDao taskDao, CategoryDao categoryDao) {
        this.taskDao = taskDao;
        this.categoryDao = categoryDao;
        this.executorService = Executors.newFixedThreadPool(2);
    }

    public LiveData<List<TaskWithCategory>> getAllTasks() {
        return taskDao.getAllTasksWithCategories();
    }

    public void insert(final TaskWithCategory taskWithCategory) {
        executorService.execute(() -> {
            long id = categoryDao.insert(taskWithCategory.getCategory());
            taskWithCategory.getCategory().setId(id);
            taskWithCategory.getTask().setCategoryId(id);
            taskDao.insert(taskWithCategory.getTask());
        });
    }

//    public void update(final Task task) {
//        executorService.execute(() -> taskDao.update(task));
//    }
//
//    public void delete(final Task task) {
//        executorService.execute(() -> taskDao.delete(task));
//    }
}

