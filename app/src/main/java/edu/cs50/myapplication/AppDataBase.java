package edu.cs50.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {TaskEntity.class},version = 1,exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDataBase extends RoomDatabase {
    private static final String LOG_TAG=AppDataBase.class.getSimpleName();
    private static final Object LOCK=new Object();
    private static final String DATA_BASE_NAME="todolist";
    private static AppDataBase sInstence;

    public static AppDataBase getInstance(Context context)
    {
        if(sInstence==null) {
            Log.d(LOG_TAG, "creating database");
            synchronized (LOCK) {
                sInstence = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, AppDataBase.DATA_BASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG,"database is created");
        return sInstence;
    }
    public abstract Task tadkDao();
}
