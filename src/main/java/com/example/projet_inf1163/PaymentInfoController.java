package com.example.projet_inf1163;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentInfoController extends Application {
    @FXML
    private Button btnReturn, btnCreate;

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("PaymentInfo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Informations payment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    protected void btnReturn_clicked(ActionEvent e) {
        ((Stage)btnReturn.getScene().getWindow()).close();
    }

    @FXML
    protected void btnCreate_clicked(ActionEvent e) {
        ((Stage)btnCreate.getScene().getWindow()).close();
    }
}
