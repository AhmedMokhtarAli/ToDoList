package edu.cs50.myapplication;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final int taskId;
    private final AppDataBase dataBase;

    public AddTaskViewModelFactory(int taskId, AppDataBase dataBase) {
        this.taskId = taskId;
        this.dataBase = dataBase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AddTaskViewModel(dataBase,taskId);
    }
}
