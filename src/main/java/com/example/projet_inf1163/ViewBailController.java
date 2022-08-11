package com.example.projet_inf1163;

import com.example.projet_inf1163.src.Bail;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewBailController extends Application {
    public static Bail selectedBail = null;

    private boolean isEditMode = false;

    @FXML
    private Button btnCancel, btnEditBail;
    @FXML
    private TextField txtLocataire, txtPhoneNumber, txtUnite, txtInsuranceId, txtAddress;
    @FXML
    private CheckBox rdoOption01, rdoOption02, rdoOption03, rdoOption04, rdoOption05, rdoOption06;

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
        System.out.println(selectedBail);

        if (selectedBail.getLocataire() != null) {
            this.txtLocataire.setText(selectedBail.getLocataire().getNom());
            this.txtPhoneNumber.setText(selectedBail.getLocataire().getPhone());
        } else {
            this.txtLocataire.setText(new String());
            this.txtPhoneNumber.setText(new String());
        }

        if (selectedBail.getUnite() != null) {
            this.txtUnite.setText(selectedBail.getUnite().getIdentifiant());
            this.txtAddress.setText(selectedBail.getUnite().getAdresse());
        } else {
            this.txtUnite.setText(new String());
            this.txtAddress.setText(new String());
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
        } else {
            btnEditBail.setText("Modifier");
        }

        txtLocataire.setDisable(!isEditMode);
        txtPhoneNumber.setDisable(!isEditMode);
        txtUnite.setDisable(!isEditMode);
        txtInsuranceId.setDisable(!isEditMode);
        txtAddress.setDisable(!isEditMode);

        rdoOption01.setDisable(!isEditMode);
        rdoOption02.setDisable(!isEditMode);
        rdoOption03.setDisable(!isEditMode);
        rdoOption04.setDisable(!isEditMode);
        rdoOption05.setDisable(!isEditMode);
        rdoOption06.setDisable(!isEditMode);
    }
}
