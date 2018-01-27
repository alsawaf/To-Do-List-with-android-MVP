package com.example.android.todolist.Data;

import android.provider.BaseColumns;

/**
 * Created by win8 on 1/19/2018.
 */
// this class is final because it will not be extended
public final class TasksContractClass {

    public static final class Tasks implements BaseColumns{

        public final static String TABLE_NAME = "ToDoList";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_TASK_NAME = "TaskName";
        public final static String COLUMN_TASK_DESC = "TaskDesc";
        public final static String COLUMN_TASK_STATUS = "TaskStatus";

    }

}
