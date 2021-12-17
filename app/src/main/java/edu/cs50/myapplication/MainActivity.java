package edu.cs50.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.ItemClickListner{
    private static final String TAG =MainActivity.class.getSimpleName() ;
    RecyclerView recyclerView;
    Adapter adapter;
    AppDataBase dataBase;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter=new Adapter(this);
        dataBase=AppDataBase.getInstance(getApplicationContext());
        floatingActionButton=(FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,add_task1.class);
                startActivity(intent);
            }
        });



        recyclerView=(RecyclerView) findViewById(R.id.RV);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                AppExcutor.getInstance().getDiskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        int postion=viewHolder.getAdapterPosition();
                        List<TaskEntity> entities=adapter.getTaskList();
                        dataBase.tadkDao().delete(entities.get(postion));
                    }
                });
            }
        }).attachToRecyclerView(recyclerView);
        extracted();
    }
    private void extracted() {
        Log.d(TAG,"GEETING DATA FROM DATABASE");
        final LiveData<List<TaskEntity>> entities=dataBase.tadkDao().loadEntity();
        entities.observe(this, new Observer<List<TaskEntity>>() {
            @Override
            public void onChanged(List<TaskEntity> entitiesList) {
               Snackbar.make(recyclerView,"GEETING DATABASE UPDATE FROM LIVEDATA",Snackbar.LENGTH_SHORT).show();
                Log.d(TAG,"GEETING DATABASE UPDATE FROM LIVEDATA");
                adapter.setTaskList(entitiesList);
            }
        });
    }

    @Override
    public void oItemClickListner(int itemID) {
        Intent intent=new Intent(MainActivity.this,add_task1.class);
        intent.putExtra(add_task1.EXTRA_TASK_ID,itemID);
        startActivity(intent);
    }
}