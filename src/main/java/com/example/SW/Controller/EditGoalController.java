package com.example.SW.Controller;

import javafx.application.Application;
import javafx.stage.Stage;


import com.example.SW.Model.Goal;
import com.example.SW.Util.GoalsSession;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditGoalController {

    @FXML private TextField nameField;
    @FXML private TextField targetField;
    @FXML private DatePicker dateField;

    private int index;
    private Goal goal;

    GoalsSession goalsSession = GoalsSession.getInstance();

    public void setGoal(int index, Goal goal) {
        this.index = index;
        this.goal = goal;

        nameField.setText(goal.getName());
        targetField.setText(String.valueOf(goal.getTarget()));
        dateField.setValue(goal.getDate());
    }

    @FXML
    private void handleSave() {
        goal.setName(nameField.getText());
        goal.setTarget(Double.parseDouble(targetField.getText()));
        goal.setDate(dateField.getValue());

        goalsSession.updateGoals(index, goal);

        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
}
