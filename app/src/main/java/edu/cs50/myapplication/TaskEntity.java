package edu.cs50.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;
@Entity(tableName = "entity")
public class TaskEntity  {


    @PrimaryKey(autoGenerate = true)
    private int id;
    private String detiales;
    private int Priorty;
    private Date date;

    @Ignore
    public TaskEntity(String detiales, int priorty, Date date) {
        this.detiales = detiales;
        Priorty = priorty;
        this.date = date;
    }

    public TaskEntity(int id, String detiales, int priorty, Date date) {
        this.id = id;
        this.detiales = detiales;
        Priorty = priorty;
        this.date = date;
    }

    public TaskEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetiales() {
        return detiales;
    }

    public void setDetiales(String detiales) {
        this.detiales = detiales;
    }

    public int getPriorty() {
        return Priorty;
    }

    public void setPriorty(int priorty) {
        Priorty = priorty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
