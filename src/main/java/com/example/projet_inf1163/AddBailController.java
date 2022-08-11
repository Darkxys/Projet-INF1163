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

public class AddBailController extends Application {
    @FXML
    private Button btnCancel;

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("AddBail.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Créer Bail");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    protected void btnContinue_clicked(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("PaymentInfo.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage window = new Stage();
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);
            window.show();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    protected void btnCancel_clicked(ActionEvent e) {
        ((Stage)btnCancel.getScene().getWindow()).close();
    }
}
