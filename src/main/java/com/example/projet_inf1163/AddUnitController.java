package com.example.projet_inf1163;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddUnitController extends Application {
    @FXML
    private Button addButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AddUnitController.class.getResource("AddUnit.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.initModality(Modality.APPLICATION_MODAL);
        s.setTitle("Création d'unité");
        s.setScene(scene);
        s.show();
    }

    @FXML
    private void initialize(){

    }

    @FXML
    public void onAddButton(ActionEvent e) {
        // Add unit to json
        ((Stage)addButton.getScene().getWindow()).close();
    }
}
