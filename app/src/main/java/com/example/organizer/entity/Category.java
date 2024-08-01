package com.example.organizer.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity (tableName = "categories")
public class Category {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private final String name;

    public void setId(long id) {
        this.id = id;
    }

    public Category(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
