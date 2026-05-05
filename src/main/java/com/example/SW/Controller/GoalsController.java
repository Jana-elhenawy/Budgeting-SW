package com.example.SW.Controller;

import com.example.SW.Util.GoalsSession;
import com.example.SW.Util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class GoalsController {

    @FXML private ListView goalsList;
    @FXML private Button addButton;
    GoalsSession goalsSession = GoalsSession.getInstance();

    public void initialize(){goalsList.getItems().addAll(goalsSession.getGoals());}
    public void openAddGoal() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/SW/add-goal.fxml"));
        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setOnHiding(event -> refreshList());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshList(){
        goalsList.getItems().clear();
        goalsList.getItems().addAll(goalsSession.getGoals());
    }
    @FXML
    private void handleBackToDashboard() throws IOException, IOException {
        SceneManager.switchTo("dashboard.fxml");
    }
    @FXML
    public void handleEditGoal() {
        int selectedIndex = goalsList.getSelectionModel().getSelectedIndex();

        if (selectedIndex == -1) {
            return; // no selection
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/SW/edit-goal.fxml"));
            Parent root = loader.load();

            EditGoalController controller = loader.getController();
            controller.setGoal(selectedIndex, goalsSession.getGoals().get(selectedIndex));

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setOnHiding(event -> refreshList());
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


