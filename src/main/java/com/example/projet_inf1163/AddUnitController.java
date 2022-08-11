package com.example.projet_inf1163;

import com.example.projet_inf1163.src.Locataire;
import com.example.projet_inf1163.src.Unite;
import com.example.projet_inf1163.src.UniteCatalogue;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddUnitController extends Application {
    //region FXML variables
    @FXML
    private Button addButton;
    @FXML
    private TextField txtAdresse, txtPrix, txtAir, txtRoom, txtBathroom;

    @FXML
    private ComboBox<Locataire> cmbLocataire;
    @FXML
    private ComboBox<Unite.UnitType> cmbType;
    @FXML
    private ComboBox<Unite.RentIndication> cmbRent;
    @FXML
    private DatePicker dateBuilt;
    //endregion

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
    /**
     * Method triggered when the add button is clicked.
     * This method saves the new Unit into the UnitCatalogue
     */
    public void onAddButton(ActionEvent e) {
        // Add unit to json

        Unite u = new Unite();
        u.setAdresse(txtAdresse.getText());
        u.setPrix(Float.parseFloat(txtPrix.getText()));
        u.setAir(Integer.parseInt(txtAir.getText()));
        u.setQttBathRoom(Integer.parseInt(txtBathroom.getText()));
        u.setQttRoom(Integer.parseInt(txtRoom.getText()));
        u.setType(cmbType.getSelectionModel().getSelectedItem());
        u.setRentIndication(cmbRent.getSelectionModel().getSelectedItem());
        u.setOwner(cmbLocataire.getSelectionModel().getSelectedItem());
        u.setBuiltDate(dateBuilt.getValue());
        u.updateIdentifiant();

        UniteCatalogue.addUnit(u);
        ((Stage)addButton.getScene().getWindow()).close();
    }
}
