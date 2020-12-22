package com.possenti.task.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class Task {
    @Id
    private Long id;
    private String name;
    private String description;
    private LocalDate data;

    public Task() {
    }

    public Task(Long id, String name, String description, LocalDate data) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.data = data;
    }

    public Task(String name, String description, LocalDate data) {
        this.name = name;
        this.description = description;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", data=" + data +
                '}';
    }
}
