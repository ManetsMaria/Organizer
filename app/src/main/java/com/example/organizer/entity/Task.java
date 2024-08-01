package com.example.organizer.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Objects;

import javax.annotation.Nullable;

@Entity(tableName = "tasks",
        foreignKeys = @ForeignKey(entity = Category.class,
                parentColumns = "id",
                childColumns = "categoryId",
                onDelete = ForeignKey.CASCADE))
public class Task {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private final String taskTitle;
    private boolean isDone;
    private final Long dateTime;
    private final Priority priority;

    //TODO make an index
    private long categoryId;

//    public Task(long categoryId, Priority priority, @Nullable Long dateTime,
//                boolean isDone, String taskTitle) {
//        this.categoryId = categoryId;
//        this.priority = priority;
//        this.dateTime = dateTime;
//        this.isDone = isDone;
//        this.taskTitle = taskTitle;
//    }

    public Task(Priority priority, @Nullable Long dateTime,
                boolean isDone, String taskTitle) {
        this.priority = priority;
        this.dateTime = dateTime;
        this.isDone = isDone;
        this.taskTitle = taskTitle;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getId() { return id; }
    public String getTaskTitle() { return taskTitle; }
    public boolean isDone() { return isDone; }
    public void setDone(boolean done) { isDone = done; }
    public Priority getPriority() { return priority; }
    public long getCategoryId() { return categoryId; }
    public Long getDateTime() { return dateTime; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && isDone == task.isDone && Objects.equals(taskTitle, task.taskTitle)
                && Objects.equals(dateTime, task.dateTime)
                && priority == task.priority && Objects.equals(categoryId, task.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskTitle, isDone, dateTime, priority, categoryId);
    }
}

