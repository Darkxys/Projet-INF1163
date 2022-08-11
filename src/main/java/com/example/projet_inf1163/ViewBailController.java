package com.example.projet_inf1163;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewBailController extends Application {
    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("ViewBail.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Apperçu du bail");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
