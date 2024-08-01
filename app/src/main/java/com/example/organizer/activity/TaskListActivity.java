package com.example.organizer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.organizer.R;
import com.example.organizer.adapter.TaskListAdapter;
import com.example.organizer.database.repository.CategoryRepository;
import com.example.organizer.database.repository.TaskWithCategoryRepository;
import com.example.organizer.entity.Category;
import com.example.organizer.entity.Priority;
import com.example.organizer.entity.Task;
import com.example.organizer.entity.TaskWithCategory;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TaskListActivity extends AppCompatActivity {

    @Inject
    TaskListAdapter adapter;

    @Inject
    TaskWithCategoryRepository taskWithCategoryRepository;

    @Inject
    CategoryRepository categoryRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.task_list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Category category = new Category("CAT");
        Task task = new Task(Priority.LOW, System.currentTimeMillis(), true, "Bla-bla-bla");
        taskWithCategoryRepository.insert(new TaskWithCategory(task, category));

        taskWithCategoryRepository.getAllTasks().observe(this, tasks -> {
            adapter.submitList(tasks);
        });

        //TODO move listener insert
        ImageButton imageButton = findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EditTaskActivity.class);
                startActivity(i);
            }
        });
    }
}