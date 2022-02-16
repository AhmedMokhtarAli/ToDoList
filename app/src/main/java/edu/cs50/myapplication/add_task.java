package edu.cs50.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import java.util.Date;

public class add_task extends AppCompatActivity {
    // Extra for the task ID to be received in the intent
    public static final String EXTRA_TASK_ID = "extraTaskId";
    // Extra for the task ID to be received after rotation
    public static final String INSTANCE_TASK_ID = "instanceTaskId";
    // Constants for priority
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_MEDIUM = 2;
    public static final int PRIORITY_LOW = 3;
    // Constant for default task id to be used when not in update mode
    private static final int DEFAULT_TASK_ID = -1;

    private int mTaskId = DEFAULT_TASK_ID;

    private static final String TAG=add_task.class.getSimpleName();
    private EditText editText;
    private RadioGroup radioGroup;
    private Button button;

    private AppDataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        initViews();

        dataBase=AppDataBase.getInstance(getApplicationContext());


        if(savedInstanceState!=null&&savedInstanceState.containsKey(INSTANCE_TASK_ID))
        {
            mTaskId=savedInstanceState.getInt(INSTANCE_TASK_ID,DEFAULT_TASK_ID);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(INSTANCE_TASK_ID,mTaskId);
        super.onSaveInstanceState(outState);
    }

    public void initViews()
    {
        editText=(EditText) findViewById(R.id.edit_text);
        radioGroup=findViewById(R.id.radioGroup);
        button=findViewById(R.id.button);
    }
    public void onSaveButtonClicked()
    {
        String descrepyion=editText.getText().toString();
        int priorty =getPriorty();
        Date date=new Date();

        TaskEntity entity=new TaskEntity(descrepyion,priorty,date);
        dataBase.tadkDao().insert(entity);
        finish();
    }

    private int getPriorty() {
        int priorty=1;
        int id=((RadioGroup)findViewById(R.id.radioGroup)).getCheckedRadioButtonId();
        switch(id){
            case R.id.radioButton:
                priorty=PRIORITY_HIGH;
                break;
            case R.id.radioButton2:
                priorty=PRIORITY_MEDIUM;
                break;
            case R.id.radioButton3:
                priorty=PRIORITY_LOW;
        }
        return priorty;
    }
}