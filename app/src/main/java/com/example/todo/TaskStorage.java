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
    public static TaskStorage getInstance() {
        return taskStorage;
    }
    private TaskStorage(){
        tasks = new ArrayList<>();
        for(int i = 1; i <= 150; i++){
            Task task = new Task();
            task.setName("Pilne zadanie numer "+i);
            task.setDone(i%3 == 0);
            tasks.add(task);
        }
    }
    public List<Task> getTasks() {
        return tasks;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Task getTask(UUID id){
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst().orElse(null);
    }
}
