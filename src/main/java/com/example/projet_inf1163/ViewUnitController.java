package com.example.projet_inf1163;

import com.example.projet_inf1163.src.Unite;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewUnitController extends Application {

    @FXML
    private TextField txtIdentifiant, txtAdresse, txtPrix, txtAir, txtRoom, txtBathroom;

    @FXML
    private ComboBox cmbLocataire, cmbType, cmbRent;

    @FXML
    private DatePicker dateBuilt;

    private boolean isEditMode = false;
    private ArrayList<Control> fieldsArr = new ArrayList<>();

    public static Unite unitSelected;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ViewUnitController.class.getResource("ViewUnit.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Unité");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    protected void initialize(){
        this.fieldsArr.add(txtAdresse);
        this.fieldsArr.add(txtPrix);
        this.fieldsArr.add(txtAir);
        this.fieldsArr.add(txtBathroom);
        this.fieldsArr.add(txtRoom);
        this.fieldsArr.add(cmbLocataire);
        this.fieldsArr.add(cmbType);
        this.fieldsArr.add(cmbRent);
        this.fieldsArr.add(dateBuilt);
        System.out.println(unitSelected);
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
