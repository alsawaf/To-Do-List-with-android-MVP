package com.example.android.todolist.Presenters;

import android.content.Context;

import com.example.android.todolist.Data.TasksHelper;
import com.example.android.todolist.Task;

import java.util.ArrayList;

/**
 * Created by win8 on 1/24/2018.
 */

public class DoneTasksPresenter {

    Context context;
    //fix Context parameter
   TasksHelper TasksHelper = new TasksHelper(context );

    public ArrayList<Task> PresernterGetDoneTasks(){

        return TasksHelper.GetDoneTasks();

    }
}
