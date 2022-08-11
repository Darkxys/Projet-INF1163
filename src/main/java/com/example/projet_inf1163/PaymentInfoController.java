package com.example.projet_inf1163;

import com.example.projet_inf1163.src.Bail;
import com.example.projet_inf1163.src.BailCatalogue;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class PaymentInfoController extends Application {
    // Decimal formating tool
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Method to set the current bail
     * @param bail
     */
    public void setCurrentBail(Bail bail) {
        currentBail = bail;

        lblSommaryUnits.setText(df.format(currentBail.calculateUnitPriceForPeriod(currentBail.getDate_debut())));
        lblSommaryExtras.setText(df.format(currentBail.calculateExtraPriceForPeriod(currentBail.getDate_debut())));
        lblSommarySubtotal.setText(df.format(currentBail.calculateSubtotalForPeriod(currentBail.getDate_debut())));
        lblSommaryTPS.setText(df.format(currentBail.calculateTPSForPeriod(currentBail.getDate_debut())));
        lblSommaryTVQ.setText(df.format(currentBail.calculateTVQForPeriod(currentBail.getDate_debut())));
        lblSommaryTotal.setText(df.format(currentBail.calculateTotalForPeriod(currentBail.getDate_debut())));
    }

    // Current Bail
    private Bail currentBail;

    /**
     * Method to set the previous controller
     * @param previousController
     */
    public void setPreviousController(AddBailController previousController) {
        this.previousController = previousController;
    }

    // Previous controller
    private AddBailController previousController;

    //region FXML variables
    @FXML
    private Button btnReturn, btnCreate;
    @FXML
    private TextField txtLastName, txtFirstName, txtCardNumber, txtExpiryDate, txtCVV;
    @FXML
    private Label lblSommaryUnits, lblSommaryExtras, lblSommarySubtotal, lblSommaryTPS, lblSommaryTVQ, lblSommaryTotal;
    //endregion FXML variables

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("PaymentInfo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Informations payment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Method to check if the create button should be disabled
     */
    private void checkDisableCreateButton() {
        btnCreate.setDisable(
                txtLastName.getText().trim() == "" ||
                txtFirstName.getText().trim() == "" ||
                txtCardNumber.getText().trim() == "" ||
                txtExpiryDate.getText().trim() == "" ||
                txtCVV.getText().trim() == ""
        );
    }

    @FXML
    /**
     * Method to initialize fields
     */
    private void initialize() {
        btnCreate.setDisable(true);

        txtLastName.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableCreateButton();
        });
        txtFirstName.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableCreateButton();
        });
        txtCardNumber.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableCreateButton();
        });
        txtExpiryDate.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableCreateButton();
        });
        txtCVV.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableCreateButton();
        });
    }

    @FXML
    /**
     * When the return button is clicked, close the window
     */
    protected void btnReturn_clicked(ActionEvent e) {
        ((Stage)btnReturn.getScene().getWindow()).close();
    }

    @FXML
    /**
     * When the create button is clicked, add the new payment into the bail
     */
    protected void btnCreate_clicked(ActionEvent e) {
        BailCatalogue.addBail(currentBail);
        previousController.getPreviousController().refreshBails();

        previousController.closeWindow();

        ((Stage)btnCreate.getScene().getWindow()).close();
    }
}
