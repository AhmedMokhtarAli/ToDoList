package edu.cs50.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class AddTaskViewModel extends ViewModel {
    private LiveData<TaskEntity> task;

    public AddTaskViewModel(AppDataBase dataBase,int taskId) {
        task =dataBase.tadkDao().loadTask(taskId);
    }

    public LiveData<TaskEntity> getTask() {
        return task;
    }
}
