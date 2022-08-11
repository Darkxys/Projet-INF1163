package com.example.projet_inf1163;

import com.example.projet_inf1163.src.Locataire;
import com.example.projet_inf1163.src.Unite;
import com.example.projet_inf1163.src.UniteCatalogue;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
    private ComboBox<Locataire> cmbLocataire;
    @FXML
    private ComboBox<Unite.UnitType> cmbType;
    @FXML
    private ComboBox<Unite.RentIndication> cmbRent;
    @FXML
    private Button btnEdit;

    @FXML
    private DatePicker dateBuilt;

    private boolean isEditMode = false;
    private ArrayList<Control> fieldsArr = new ArrayList<>();

    public static int selectedIndex = 0;

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

        // Initialize attributes
        Unite u = UniteCatalogue.getUnit(selectedIndex);
        txtAdresse.setText(u.getAdresse());
        txtPrix.setText(Float.toString(u.getPrix()));
        txtAir.setText(Integer.toString(u.getAir()));
        txtBathroom.setText(Integer.toString(u.getQttBathRoom()));
        txtRoom.setText(Integer.toString(u.getQttRoom()));
        txtIdentifiant.setText(u.getIdentifiant());

        // Locataire combobox
        cmbRent.getItems().addAll(Unite.RentIndication.values());
        cmbType.getItems().addAll(Unite.UnitType.values());

        cmbRent.getSelectionModel().select(u.getRentIndication());
        cmbType.getSelectionModel().select(u.getType());

        dateBuilt.setValue(u.getBuiltDate());
    }

    @FXML
    protected void onEditButtonClick() {
        if (this.isEditMode) {
            // Saving edits
            try {
                Unite u = UniteCatalogue.getUnit(selectedIndex);
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

                UniteCatalogue.setUnit(u, selectedIndex);
                ((Stage) btnEdit.getScene().getWindow()).close();
            } catch (Exception e) {

            }
        }

        for (Control c : this.fieldsArr) {
            c.setDisable(this.isEditMode);
        }
        this.isEditMode = !this.isEditMode;
        if (isEditMode) {
            btnEdit.setText("Confirmer");
        } else {
            btnEdit.setText("Modifier");
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("qweqweqwewqe");
        super.stop();
    }
}
