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
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void setCurrentBail(Bail bail) {
        currentBail = bail;

        lblSommaryUnits.setText(df.format(currentBail.getUnitPrice()));
        lblSommaryExtras.setText(df.format(currentBail.getExtraPrice()));
        lblSommarySubtotal.setText(df.format(currentBail.calculateSubtotal()));
        lblSommaryTPS.setText(df.format(currentBail.calculateTPS()));
        lblSommaryTVQ.setText(df.format(currentBail.calculateTVQ()));
        lblSommaryTotal.setText(df.format(currentBail.calculateTotal()));
    }

    private Bail currentBail;

    public void setPreviousController(AddBailController previousController) {
        this.previousController = previousController;
    }

    private AddBailController previousController;

    @FXML
    private Button btnReturn, btnCreate;
    @FXML
    private TextField txtLastName, txtFirstName, txtCardNumber, txtExpiryDate, txtCVV;
    @FXML
    private Label lblSommaryUnits, lblSommaryExtras, lblSommarySubtotal, lblSommaryTPS, lblSommaryTVQ, lblSommaryTotal;

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("PaymentInfo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Informations payment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

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
    protected void btnReturn_clicked(ActionEvent e) {
        ((Stage)btnReturn.getScene().getWindow()).close();
    }

    @FXML
    protected void btnCreate_clicked(ActionEvent e) {
        BailCatalogue.addBail(currentBail);
        previousController.getPreviousController().refreshBails();

        previousController.closeWindow();

        ((Stage)btnCreate.getScene().getWindow()).close();
    }
}
