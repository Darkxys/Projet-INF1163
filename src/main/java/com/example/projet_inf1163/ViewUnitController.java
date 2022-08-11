package com.example.projet_inf1163;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewUnitController extends Application {

    @FXML
    private TextField txtIdentifiant, txtAdresse, txtPrix;

    @FXML
    private ChoiceBox cbLocataire;

    private boolean isEditMode = false;
    private ArrayList<Control> fieldsArr = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewUnit.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Unité");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    protected void initialize(){
        this.fieldsArr.add(txtAdresse);
        this.fieldsArr.add(txtPrix);
        this.fieldsArr.add(cbLocataire);
    }

    @FXML
    protected void onEditButtonClick(){
        if(this.isEditMode){
            System.out.println("save");
        }

        for(Control c : this.fieldsArr){
            c.setDisable(this.isEditMode);
        }
        this.isEditMode = !this.isEditMode;
    }
}
