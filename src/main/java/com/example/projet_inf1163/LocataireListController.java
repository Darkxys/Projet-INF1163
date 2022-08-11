package com.example.projet_inf1163;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LocataireListController extends Application {
    @FXML
    private TextField txtName, txtPhone, txtCoteCredit, txtSecondaryAddress;
    @FXML
    private ListView lstLocataires;
    @FXML
    private Button btnAdd, btnSelect, btnCancel;

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("LocataireList.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Locataires");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    protected void btnCancel_clicked(ActionEvent e) {
        ((Stage)btnCancel.getScene().getWindow()).close();
    }
}
