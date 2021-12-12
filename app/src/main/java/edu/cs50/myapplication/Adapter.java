package edu.cs50.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    List<TaskEntity> taskList;
    ItemClickListner listner;
    public interface ItemClickListner
    {
        void oItemClickListner(int itemID);
    }
    public void  setTaskList(List<TaskEntity> taskList) {
        this.taskList = taskList;
        notifyDataSetChanged();
    }
    public List<TaskEntity> getTaskList() {
        return taskList;
    }
    public Adapter(ItemClickListner listner) {
        this.listner = listner;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ViewHolder(view,taskList,listner);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         TaskEntity testObj= taskList.get(position);
        holder.onBind(testObj);
    }
    @Override
    public int getItemCount() {
        return getTaskList().size();
    }
}
