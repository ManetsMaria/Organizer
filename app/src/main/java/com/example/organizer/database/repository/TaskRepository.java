package com.example.organizer.database.repository;

import com.example.organizer.database.dao.TaskDao;
import com.example.organizer.entity.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class TaskRepository {

    private final TaskDao taskDao;
    private final ExecutorService executorService;

    @Inject
    public TaskRepository(TaskDao taskDao) {
        this.taskDao = taskDao;
        this.executorService = Executors.newFixedThreadPool(2);
    }

    public void delete(final Task task) {
        executorService.execute(() -> taskDao.delete(task));
    }
}
