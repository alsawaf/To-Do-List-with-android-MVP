package com.example.android.todolist;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by win8 on 1/26/2018.
 */

public class TaskAdapter extends ArrayAdapter<Task> {




    public TaskAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Task> TasksArrayList) {

        super(context, 0, TasksArrayList);

    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //creaing an object of convertview the item view passed to this function as a parameter
        View ListItem = convertView;

        if(ListItem==null){

            ListItem = LayoutInflater.from(getContext()).inflate(R.layout.item_view,parent,false);

        }
        // holding the current object in the arraylist in a variable to ge the data out of it
        Task CurrentTask = getItem(position);

        TextView TaskName = (TextView)ListItem.findViewById(R.id.TaskNameTextView);
        TaskName.setText(CurrentTask.GetName());

        TextView TaskDesc = (TextView)ListItem.findViewById(R.id.TaskDescTextView);
        TaskDesc.setText(CurrentTask.GetDesc());

        return ListItem;
    }
}
