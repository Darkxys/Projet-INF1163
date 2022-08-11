package com.example.projet_inf1163;

import com.example.projet_inf1163.src.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LocataireListController extends Application {
    public void initData(AddBailController addBailController) {
        this.bailControllerRef = addBailController;
    }
    private AddBailController bailControllerRef;

    private ObservableList<Locataire> locList;

    @FXML
    private TextField txtName, txtPhone, txtCoteCredit, txtSecondaryAddress;
    @FXML
    private ListView<Locataire> lstLocataires;
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

    private void refreshLocataires() {
        locList = FXCollections.observableList(LocataireCatalogue.getLocataires());
        lstLocataires.setItems(locList);
    }

    private void resetTextFields() {
        txtName.setText(new String());
        txtPhone.setText(new String());
        txtCoteCredit.setText(new String());
        txtSecondaryAddress.setText(new String());
    }

    private void refreshAddButtonState() {
        if (txtName.getText().trim().length() > 0 && txtPhone.getText().trim().length() > 0) {
            btnAdd.setDisable(false);
        } else {
            btnAdd.setDisable(true);
        }
    }

    @FXML
    private void initialize() {
        btnAdd.setDisable(true);
        refreshLocataires();

        txtName.textProperty().addListener((observable, oldValue, newValue) -> {
            refreshAddButtonState();
        });

        txtPhone.textProperty().addListener((observable, oldValue, newValue) -> {
            refreshAddButtonState();
        });

        txtCoteCredit.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtCoteCredit.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @FXML
    protected void btnAdd_clicked(ActionEvent e) {
        Locataire newLoc = new Locataire();

        newLoc.setNom(txtName.getText());
        newLoc.setPhone(txtPhone.getText());

        try{
            int coteCredit = Integer.parseInt(txtCoteCredit.getText());
            newLoc.setCote_credit(coteCredit);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        newLoc.setAdresse(txtSecondaryAddress.getText());

        LocataireCatalogue.addLocataire(newLoc);

        refreshLocataires();

        resetTextFields();
    }

    @FXML
    protected void btnCancel_clicked(ActionEvent e) {
        ((Stage)btnCancel.getScene().getWindow()).close();
    }

    @FXML
    protected void btnSelect_clicked(ActionEvent e) {
        Locataire selectedLoc = this.lstLocataires.getSelectionModel().getSelectedItem();
        if (selectedLoc == null) return;

        bailControllerRef.refreshLoc(selectedLoc);

        ((Stage)btnSelect.getScene().getWindow()).close();
    }
}
