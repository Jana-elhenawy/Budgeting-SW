package com.example.SW.Model;

import java.time.LocalDate;

public class Goal {
    private String name;
    private double target;
    private double current;
    private LocalDate date;
    private String status;

    public Goal (String goalName, double targetAmount,LocalDate deadline){
        this.name = goalName;
        this.target = targetAmount;
        this.date = deadline;
        current = 0;
        status = "In Progress";
    }

    public String getName(){return name;}
    public double getTarget(){return target;}
    public double getCurrent(){return current;}
    public LocalDate getDate(){return date;}
    public String getStatus(){return status;}

    public void setName(String goalName){this.name = goalName;}
    public void setTarget(double targetAmount){this.target = targetAmount;}
    public void setCurrent(double currentAmount){this.current = currentAmount;}
    public void setDate(LocalDate deadline){this.date = deadline;}
    public void setStatus(String status){this.status = status;}

    @Override public String toString(){
     return name + "  " + target + "   " + date;
    }
}
