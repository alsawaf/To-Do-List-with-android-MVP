package com.example.android.todolist;

/**
 * Created by win8 on 1/20/2018.
 */

public class Task {

    private String TaskName ;
    private String TaskDesc ;
    private boolean TaskStatus;



    public Task(String TaskName , String TaskDesc){

        this.TaskName = TaskName;
        this.TaskDesc = TaskDesc;
        this.TaskStatus = false;

    }

    public void SetName (String TaskName){

        this.TaskName = TaskName ;

    }

    public String GetName(){

        return this.TaskName;

    }

    public void SetDesc (String TaskDesc){

        this.TaskDesc = TaskDesc ;

    }

    public String GetDesc(){

        return this.TaskDesc;

    }

    public void SetStatus (boolean TaskStatus){

        this.TaskStatus = TaskStatus ;

    }

    public boolean GetStatus(){

        return this.TaskStatus;

    }


}
