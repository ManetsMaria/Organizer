package com.example.organizer.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.Objects;

public class TaskWithCategory {
    @Embedded
    private Task task;

    @Relation(
            parentColumn = "categoryId",
            entityColumn = "id",
            entity = Category.class
    )
    private Category category;

    public TaskWithCategory(Task task, Category category) {
        this.task = task;
        this.category = category;
    }

    public Task getTask() {
        return task;
    }

    public Category getCategory() {
        return category;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskWithCategory that = (TaskWithCategory) o;
        return Objects.equals(task, that.task) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, category);
    }
}
