package com.example.projet_inf1163;

import com.example.projet_inf1163.src.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewBailController extends Application {
    //region Properties declaration
    public static int selectedIndex = 0;

    private boolean isEditMode = false;

    private ObservableList<Paiement> paiements;
    private Bail selectedBail;
    //endregion Properties declaration

    //region FXML variables
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
    @FXML
    private ListView<Paiement> lstPaiements;
    //endregion FXML variables

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("ViewBail.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Apperçu du bail");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Method to refresh payments
     */
    private void refreshPaiements() {
        paiements = FXCollections.observableList(selectedBail.getPaiements());
        lstPaiements.setItems(paiements);
    }

    @FXML
    /**
     * Method to initialize the fields to the bail values
     */
    private void initialize() {
        selectedBail = BailCatalogue.getBail(selectedIndex);

        refreshPaiements();

        ArrayList<Unite> units = new ArrayList<Unite>();

        for (Unite u: UniteCatalogue.getUnits()) {
            if (u.getRentIndication() == Unite.RentIndication.Libre || selectedBail.getUnite() == u) {
                units.add(u);
            }
        }

        cmbUnit.getItems().addAll(units);
        cmbLocataire.getItems().addAll(LocataireCatalogue.getLocataires());
        cmbExtra.getItems().addAll(ExtraCatalogue.getExtras());

        if (selectedBail.getExtra() != null)
            cmbExtra.getSelectionModel().select(selectedBail.getExtra());

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
    /**
     * When the cancel button is clicked, close the window
     */
    protected void btnCancel_clicked(ActionEvent e) {
        ((Stage)btnCancel.getScene().getWindow()).close();
    }

    @FXML
    /**
     * When the edit button is clicked, tries to edit the current bail
     */
    protected void btnEditBail_clicked(ActionEvent e) {
        isEditMode = !isEditMode;
        if (isEditMode) {
            btnEditBail.setText("Confirmer");
        } else {
            try {
                Bail b = BailCatalogue.getBail(selectedIndex);

                b.setAssurance(txtInsuranceId.getText());
                b.setLocataire(cmbLocataire.getSelectionModel().getSelectedItem());
                b.setUnite(cmbUnit.getSelectionModel().getSelectedItem());
                b.setExtra(cmbExtra.getSelectionModel().getSelectedItem());

                BailCatalogue.setBail(b, selectedIndex);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
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
