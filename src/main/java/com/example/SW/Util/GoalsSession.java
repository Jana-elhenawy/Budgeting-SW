package com.example.SW.Util;

import com.example.SW.Model.Goal;
import java.util.ArrayList;

public class GoalsSession {
    private ArrayList <Goal> goalsList = new ArrayList<>();

    public void addGoal (Goal goal){goalsList.add(goal);}
    public ArrayList<Goal> getGoals(){return goalsList;}
    public void updateGoals (int index, Goal goal){
        goalsList.set(index, goal);
    }

    private static GoalsSession instance;

    public static GoalsSession getInstance(){
        if(instance == null){
            instance = new GoalsSession();
        }
        return instance;
    }

}
