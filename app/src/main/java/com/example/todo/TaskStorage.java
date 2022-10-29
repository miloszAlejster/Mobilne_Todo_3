package com.example.todo;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();
    private final List<Task> tasks;
    private TaskStorage(){
        tasks = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            Task task = new Task();
            task.setName("Pilne zadanie numer "+i);
            task.setDone(i % 3 == 0);
            tasks.add(task);
        }
    }
    public static TaskStorage getInstance() {
        return taskStorage;
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public Task getTask(UUID id){
        Task result = null;
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId().equals(id)) {
                result = tasks.get(i);
                break;
            }
        }
        return result;
    }
}
