package com.example.todo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private String date;
    private boolean done;
    private Category category;

    public Task(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy");
        date = simpleDateFormat.format(new Date());
        id = UUID.randomUUID();
        category = Category.HOME;
    }
    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public boolean isDone() {
        return done;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDone(boolean done) {this.done = done;}
    public void setCategory(Category category) {
        this.category = category;
    }
    public Category getCategory(){return category;}
}
