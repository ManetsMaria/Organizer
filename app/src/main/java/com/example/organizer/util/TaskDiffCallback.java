package com.example.organizer.util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.organizer.entity.TaskWithCategory;

public class TaskDiffCallback extends DiffUtil.ItemCallback<TaskWithCategory> {
    @Override
    public boolean areItemsTheSame(@NonNull TaskWithCategory oldTask, @NonNull TaskWithCategory newTask) {
        return oldTask.getTask().getId() == newTask.getTask().getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull TaskWithCategory oldTask, @NonNull TaskWithCategory newTask) {
        return oldTask.equals(newTask);
    }
}

