package edu.cs50.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private LiveData<List<TaskEntity>> tasks;
    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDataBase dataBase=AppDataBase.getInstance(this.getApplication());
        tasks =dataBase.tadkDao().loadEntity();
    }

    public  LiveData<List<TaskEntity>> getTasks() {
        return tasks;
    }
}
