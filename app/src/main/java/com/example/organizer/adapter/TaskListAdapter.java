package com.example.organizer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.organizer.R;
import com.example.organizer.entity.TaskWithCategory;
import com.example.organizer.util.DateTimeUtils;
import com.example.organizer.util.TaskDiffCallback;

import javax.inject.Inject;

public class TaskListAdapter extends ListAdapter<TaskWithCategory, TaskListAdapter.ItemViewHolder> {

    @Inject
    public TaskListAdapter() {
        super(new TaskDiffCallback());
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_card_view, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        TaskWithCategory current = getItem(position);
        holder.textViewMain.setText(current.getTask().getTaskTitle());
        holder.textViewSmall.setText(DateTimeUtils.showDate(current.getTask().getDateTime()));
        holder.done.setChecked(current.getTask().isDone());
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewMain;
        private final TextView textViewSmall;
        private final ToggleButton done;

        private ItemViewHolder(View itemView) {
            super(itemView);
            textViewMain = itemView.findViewById(R.id.tvMainText);
            textViewSmall = itemView.findViewById(R.id.tvSmallText);
            done = itemView.findViewById(R.id.doneButton);
        }
    }
}

