package edu.cs50.myapplication;
import java.util.Date;
public class test {
    private int priorty;
    private String Task;
    private Date date;

    public int getPriorty() {
        return priorty;
    }

    public void setPriorty(int priorty) {
        this.priorty = priorty;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public test(int priorty, String task, Date date) {
        this.priorty = priorty;
        Task = task;
        this.date = date;
    }
}
