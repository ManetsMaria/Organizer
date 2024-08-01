package com.example.organizer.database.repository;

import androidx.lifecycle.LiveData;

import com.example.organizer.database.dao.CategoryDao;
import com.example.organizer.entity.Category;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class CategoryRepository {
    private final CategoryDao categoryDao;
    private final ExecutorService executorService;

    @Inject
    public CategoryRepository(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
        this.executorService = Executors.newFixedThreadPool(2);
    }

    public LiveData<List<Category>> getAllCategories() {
        return categoryDao.getAllTasksWithCategories();
    }

    public void insert(final Category category) {
        executorService.execute(() -> categoryDao.insert(category));
    }

    public void update(final Category category) {
        executorService.execute(() -> categoryDao.update(category));
    }

    public void delete(final Category category) {
        executorService.execute(() -> categoryDao.delete(category));
    }
}
