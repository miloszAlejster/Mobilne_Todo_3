package com.example.todo;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private Date date;
    private boolean done;

    public Task(){
        id = UUID.randomUUID();
        date = new Date();
    }
    public void setName(CharSequence s){
        name = s.toString();
    }
    public Date getDate(){
        return date;
    }
    public String getName(){
        return name;
    }
    public boolean isDone(){ return done; }
    public UUID getId() { return id; }
    public void setDone(Boolean checkStatus){
        done = checkStatus;
    }
}
