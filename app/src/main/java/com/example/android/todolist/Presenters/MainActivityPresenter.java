package com.example.android.todolist.Presenters;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.todolist.Data.TasksHelper;
import com.example.android.todolist.Task;

import java.util.ArrayList;

/**
 * Created by win8 on 1/20/2018.
 */

public class MainActivityPresenter {

    Context context;
    //fix Context Paramater
    TasksHelper TasksHelper = new TasksHelper(context);

    public ArrayList<Task> PresernterGetAllTasks(){

        return TasksHelper.GetAllTasks();

    }

}
