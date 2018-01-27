package com.example.android.todolist.Presenters;

import android.content.Context;

import com.example.android.todolist.AddTaskActivity;
import com.example.android.todolist.Data.TasksHelper;

/**
 * Created by win8 on 1/21/2018.
 */

public class AddTaskPresenter {

    Context context;
    TasksHelper TasksHelper = new TasksHelper(context);

    public void PresenterInsertTask (String TaskName , String TaskDesc){

        TasksHelper.InsertTask(TaskName , TaskDesc);

    }

}
