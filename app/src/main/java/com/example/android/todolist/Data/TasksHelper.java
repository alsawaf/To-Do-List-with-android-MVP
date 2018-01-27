package com.example.android.todolist.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.todolist.Presenters.MainActivityPresenter;
import com.example.android.todolist.Task;

import java.util.ArrayList;

/**
 * Created by win8 on 1/19/2018.
 */

public class TasksHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ToDoList.db";
    private static final int DATABASE_VERSION = 1;

    public TasksHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "create table if not exists " + TasksContractClass.Tasks.TABLE_NAME + "( " +
                TasksContractClass.Tasks._ID + " NTEGER PRIMARY KEY AUTOINCREMENT, "
                + TasksContractClass.Tasks.COLUMN_TASK_NAME + " STRING NOT NULL "
                + TasksContractClass.Tasks.COLUMN_TASK_DESC + " TEXT "
                + TasksContractClass.Tasks.COLUMN_TASK_STATUS + " BOOLEAN DEFAULT FALSE );";

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if exsits " + TasksContractClass.Tasks.TABLE_NAME);

    }

    //creating a method to insert data into the DB  that takes TaskName, TaskDesc as parameters
    public void InsertTask(String TaskName, String TaskDesc) {

        //Create and/or open a database that will be used for reading and writing.
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();
        Values.put(TasksContractClass.Tasks.COLUMN_TASK_NAME, TaskName);
        Values.put(TasksContractClass.Tasks.COLUMN_TASK_DESC, TaskDesc);
        Values.put(TasksContractClass.Tasks.COLUMN_TASK_STATUS, false);
        db.insert(TasksContractClass.Tasks.TABLE_NAME, null, Values);

    }

    public ArrayList<Task> GetAllTasks() {

        ArrayList<Task> TasksArrayList = new ArrayList<Task>();
        //Create and/or open a database to be used for reading
        SQLiteDatabase db = this.getReadableDatabase();

        //Query method explnation
       /* query

        Cursor query (boolean distinct,
        String table,
        String[] columns,
        String selection,
        String[] selectionArgs,
        String groupBy,
        String having,
        String orderBy,
        String limit)

        Query the given URL, returning a Cursor over the result*/
        String[] selectionArgs = new String[]{"false"}; // valuse to be substituted with ? place holders
        Cursor c = db.query(
                TasksContractClass.Tasks.TABLE_NAME,
                null,
                TasksContractClass.Tasks.COLUMN_TASK_STATUS + "=?",
                selectionArgs,
                null,
                null,
                null
        );

        for (int i = 0; i <= c.getColumnCount(); i++) {

            if(i==0)
                c.moveToFirst();

            TasksArrayList.add(new Task(c.getString(0), c.getString(1)));

            c.moveToNext();
        }

        return TasksArrayList;
    }

    public ArrayList<Task> GetDoneTasks() {

        ArrayList<Task> DoneTasksArrayList = new ArrayList<Task>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] selectionArgs = new String[]{"true"}; // valuse to be substituted with ? place holders
        Cursor c = db.query(
                TasksContractClass.Tasks.TABLE_NAME,
                null,
                TasksContractClass.Tasks.COLUMN_TASK_STATUS + "=?",
                selectionArgs,
                null,
                null,
                null
        );

        for (int i = 0; i <= c.getColumnCount(); i++) {
            if(i==0)
                c.moveToFirst();

            DoneTasksArrayList.add(new Task(c.getString(0), c.getString(1)));

            c.moveToNext();
        }

        c.close();
        return DoneTasksArrayList;
    }
}