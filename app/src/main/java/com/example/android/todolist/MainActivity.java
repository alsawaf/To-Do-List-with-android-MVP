package com.example.android.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.todolist.Presenters.MainActivityPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MainActivityPresenter Presenterobject;
    Button AddButton;
    Button CompletedButton;
    ListView TasksListView;
    ArrayList<Task> TasksArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddButton = (Button)findViewById(R.id.MoveToAddTaskActivity);
        CompletedButton = (Button)findViewById(R.id.CompletedTasksButton);


        TasksArray = Presenterobject.PresernterGetAllTasks();
        //creating an object of Taskadapter to make a bridge between UI component and Data Source
        TaskAdapter TaskAdapter = new TaskAdapter(this ,R.layout.item_view, TasksArray);

        //linking this Array Adapter with the ListView
        TasksListView.setAdapter(TaskAdapter);


        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , AddTaskActivity.class);
                startActivity(i);
            }
        });

        CompletedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , CompletedTasksActivity.class);
                startActivity(i);
            }
        });


    }


}
