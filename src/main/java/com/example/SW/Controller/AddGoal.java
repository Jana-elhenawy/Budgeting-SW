package com.example.SW.Controller;

import javafx.fxml.FXML;
import com.example.SW.Model.Goal;
import com.example.SW.Util.GoalsSession;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.time.LocalDate;

public class AddGoal {

    @FXML private TextField nameInput;
    @FXML private TextField amountInput;
    @FXML private DatePicker dateInput;
    @FXML private Button creationButton;

    GoalsSession goalsSession = GoalsSession.getInstance();
    public void createGoal(){
        String name = nameInput.getText();
        double amount = Double.parseDouble(amountInput.getText());
        LocalDate deadline = dateInput.getValue();
        Goal goal = new Goal(name, amount, deadline);
        goalsSession.addGoal(goal);
        Stage stage = (Stage) creationButton.getScene().getWindow();
        stage.close();
    }
}
