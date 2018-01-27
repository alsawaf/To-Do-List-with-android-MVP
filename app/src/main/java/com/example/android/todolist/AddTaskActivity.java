package com.example.android.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.todolist.Presenters.AddTaskPresenter;

public class AddTaskActivity extends AppCompatActivity {

    AddTaskPresenter PresenterObject;
    Button AddTaskButton;
    Button CancelButton;
    EditText TaskName;
    EditText TaskDesc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        AddTaskButton = (Button)findViewById(R.id.AddTaskButton);
        CancelButton = (Button)findViewById(R.id.CancelButton);
        TaskName = (EditText)findViewById(R.id.TaskNameEditText);
        TaskDesc = (EditText)findViewById(R.id.TaskDescEditText);
        PresenterObject = new AddTaskPresenter();


        AddTaskButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PresenterObject.PresenterInsertTask(TaskName.getText().toString() , TaskDesc.getText().toString());
                Intent i = new Intent(AddTaskActivity.this , MainActivity.class);
                startActivity(i);
            }
        });

        CancelButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddTaskActivity.this , MainActivity.class);
                startActivity(i);
            }
        });
    }

}
