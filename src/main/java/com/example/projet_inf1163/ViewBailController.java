package com.example.projet_inf1163;

import com.example.projet_inf1163.src.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewBailController extends Application {
    public static int selectedIndex = 0;

    private boolean isEditMode = false;

    @FXML
    private Button btnCancel, btnEditBail;
    @FXML
    private TextField txtPhoneNumber, txtInsuranceId, txtAddress;
    @FXML
    private ComboBox<Extra> cmbExtra;
    @FXML
    private ComboBox<Unite> cmbUnit;
    @FXML
    private ComboBox<Locataire> cmbLocataire;

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("ViewBail.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Apperçu du bail");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void initialize() {
        Bail selectedBail = BailCatalogue.getBail(selectedIndex);
        System.out.println(selectedBail);

        cmbUnit.getItems().addAll(UniteCatalogue.getUnits());
        cmbLocataire.getItems().addAll(LocataireCatalogue.getLocataires());
        cmbExtra.getItems().addAll(ExtraCatalogue.getExtras());

        if (selectedBail.getLocataire() != null) {
            this.cmbLocataire.getSelectionModel().select(selectedBail.getLocataire());
            this.txtPhoneNumber.setText(selectedBail.getLocataire().getPhone());
        } else {
            this.txtPhoneNumber.setText("");
        }

        if (selectedBail.getUnite() != null) {
            this.cmbUnit.getSelectionModel().select(selectedBail.getUnite());
            this.txtAddress.setText(selectedBail.getUnite().getAdresse());
        } else {
            this.txtAddress.setText("");
        }

        this.txtInsuranceId.setText(selectedBail.getAssurance());
    }

    @FXML
    protected void btnCancel_clicked(ActionEvent e) {
        ((Stage)btnCancel.getScene().getWindow()).close();
    }

    @FXML
    protected void btnEditBail_clicked(ActionEvent e) {
        isEditMode = !isEditMode;
        if (isEditMode) {
            btnEditBail.setText("Confirmer");

            try {
                Bail b = BailCatalogue.getBail(selectedIndex);

                b.setAssurance(txtInsuranceId.getText());
                b.setLocataire(cmbLocataire.getSelectionModel().getSelectedItem());
                b.setUnite(cmbUnit.getSelectionModel().getSelectedItem());
                b.setExtra(cmbExtra.getSelectionModel().getSelectedItem());

                BailCatalogue.setBail(b, selectedIndex);
            }
            catch (Exception exception) {

            }
        } else {
            btnEditBail.setText("Modifier");
        }

        cmbLocataire.setDisable(!isEditMode);
        txtPhoneNumber.setDisable(!isEditMode);
        cmbUnit.setDisable(!isEditMode);
        txtInsuranceId.setDisable(!isEditMode);
        txtAddress.setDisable(!isEditMode);

        cmbExtra.setDisable(!isEditMode);
    }
}
