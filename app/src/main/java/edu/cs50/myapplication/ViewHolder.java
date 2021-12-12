package edu.cs50.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView task,day,priorty;
    List<TaskEntity> entities;
    Adapter.ItemClickListner listner;
    public ViewHolder(@NonNull View itemView,List<TaskEntity> entities,Adapter.ItemClickListner listner) {
        super(itemView);
        task=itemView.findViewById(R.id.Deteailes_TV);
        day=itemView.findViewById(R.id.day_tv);
        priorty=itemView.findViewById(R.id.priorty);
        itemView.setOnClickListener(this);
        this.entities=entities;
        this.listner=listner;
    }
    public void onBind(TaskEntity testOBJ)
    {
        String priortyString=""+testOBJ.getPriorty();
        String dateString=""+testOBJ.getDate();
        task.setText(testOBJ.getDetiales());
        priorty.setText(priortyString);
        day.setText(dateString);

    }

    @Override
    public void onClick(View view) {
        int itemID=entities.get(getAdapterPosition()).getId();
        listner.oItemClickListner(itemID);

    }
}
