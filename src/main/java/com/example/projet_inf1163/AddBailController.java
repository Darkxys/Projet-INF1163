package com.example.projet_inf1163;

import com.example.projet_inf1163.src.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AddBailController extends Application {
    /**
     * Method to set the previous controller
     * @param previousController
     */
    public void setPreviousController(MainController previousController) {
        this.previousController = previousController;
    }

    /**
     * Method to get the previous controller
     * @return
     */
    public MainController getPreviousController() {
        return this.previousController;
    }

    // Previous Controller
    private MainController previousController;

    /**
     * Method to refresh Locataire
     * @param locataire
     */
    public void refreshLoc(Locataire locataire) {
        setSelectedLocataire(locataire);
        if (locataire != null) {
            txtLocataire.setText(selectedLocataire.getNom());
        }
    }

    // Currently selected Locataire
    private Locataire selectedLocataire;

    /**
     * Set currently selected Locataire
     * @param locataire
     */
    private void setSelectedLocataire(Locataire locataire) {
        this.selectedLocataire = locataire;
        checkDisableContinue();
    }

    // Selected Unit
    private Unite selectedUnit;

    /**
     * Set selected unit
     * @param unit
     */
    private void setSelectedUnit(Unite unit) {
        this.selectedUnit = unit;
        checkDisableContinue();
    }

    private ObservableList<Unite> unites;

    //region FXML variables
    @FXML
    private Button btnCancel, btnGetLocataire, btnConfirmUnit, btnContinue;
    @FXML
    private TextField txtSelectedUnit, txtLocataire, txtSearchUnit, txtPeriodeMonth, txtPeriodeDay, txtPeriodeHour, txtPeriodeMinutes, txtPeriodeSeconds, txtDurationMonth, txtDurationDay, txtDurationHour, txtDurationMinutes, txtDurationSeconds, txtInsurance;
    @FXML
    private CheckBox rdoRenewable;
    @FXML
    private ComboBox<Extra> cmbExtra;
    @FXML
    private ListView<Unite> lstUnits;
    //endregion

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("AddBail.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Créer Bail");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Method to refresh all units in the combobox
     */
    private void refreshUnits() {
        ArrayList<Unite> arrUnits = UniteCatalogue.getUnits();
        ArrayList<Unite> filteredUnits = new ArrayList<Unite>();

        for (Unite unit: arrUnits) {
            if (unit.getRentIndication() == Unite.RentIndication.Libre && unit.matches(txtSearchUnit.getText())) {
                filteredUnits.add(unit);
            }
        }

        unites = FXCollections.observableList(filteredUnits);
        lstUnits.setItems(unites);
    }

    @FXML
    /**
     * Method to initialize components data
     * All fields are initialized to nothing
     */
    private void initialize() {
        setSelectedLocataire(null);
        setSelectedUnit(null);
        cmbExtra.getItems().addAll(ExtraCatalogue.getExtras());

        txtPeriodeMonth.setTextFormatter(new TextFormatter<Integer>(change -> {
            if (!change.getText().isEmpty()) {
                if (change.getText().matches("\\d+")) {
                    int i = Integer.parseInt(change.getControlNewText());
                    if (i >= 0 && i <= 120) {
                        return change;
                    }
                }
                return null;
            }

            return change;
        }));
        txtDurationMonth.setTextFormatter(new TextFormatter<Integer>(change -> {
            if (!change.getText().isEmpty()) {
                if (change.getText().matches("\\d+")) {
                    int i = Integer.parseInt(change.getControlNewText());
                    if (i >= 0 && i <= 120) {
                        return change;
                    }
                }
                return null;
            }

            return change;
        }));
        txtPeriodeDay.setTextFormatter(new TextFormatter<Integer>(change -> {
            if (!change.getText().isEmpty()) {
                if (change.getText().matches("\\d+")) {
                    int i = Integer.parseInt(change.getControlNewText());
                    if (i >= 0 && i <= 31) {
                        return change;
                    }
                }
                return null;
            }

            return change;
        }));
        txtDurationDay.setTextFormatter(new TextFormatter<Integer>(change -> {
            if (!change.getText().isEmpty()) {
                if (change.getText().matches("\\d+")) {
                    int i = Integer.parseInt(change.getControlNewText());
                    if (i >= 0 && i <= 31) {
                        return change;
                    }
                }
                return null;
            }

            return change;
        }));
        txtPeriodeHour.setTextFormatter(new TextFormatter<Integer>(change -> {
            if (!change.getText().isEmpty()) {
                if (change.getText().matches("\\d+")) {
                    int i = Integer.parseInt(change.getControlNewText());
                    if (i >= 0 && i <= 23) {
                        return change;
                    }
                }
                return null;
            }

            return change;
        }));
        txtDurationHour.setTextFormatter(new TextFormatter<Integer>(change -> {
            if (!change.getText().isEmpty()) {
                if (change.getText().matches("\\d+")) {
                    int i = Integer.parseInt(change.getControlNewText());
                    if (i >= 0 && i <= 23) {
                        return change;
                    }
                }
                return null;
            }

            return change;
        }));
        txtPeriodeMinutes.setTextFormatter(new TextFormatter<Integer>(change -> {
            if (!change.getText().isEmpty()) {
                if (change.getText().matches("\\d+")) {
                    int i = Integer.parseInt(change.getControlNewText());
                    if (i >= 0 && i <= 59) {
                        return change;
                    }
                }
                return null;
            }

            return change;
        }));
        txtDurationMinutes.setTextFormatter(new TextFormatter<Integer>(change -> {
            if (!change.getText().isEmpty()) {
                if (change.getText().matches("\\d+")) {
                    int i = Integer.parseInt(change.getControlNewText());
                    if (i >= 0 && i <= 59) {
                        return change;
                    }
                }
                return null;
            }

            return change;
        }));
        txtPeriodeSeconds.setTextFormatter(new TextFormatter<Integer>(change -> {
            if (!change.getText().isEmpty()) {
                if (change.getText().matches("\\d+")) {
                    int i = Integer.parseInt(change.getControlNewText());
                    if (i >= 0 && i <= 59) {
                        return change;
                    }
                }
                return null;
            }

            return change;
        }));
        txtDurationSeconds.setTextFormatter(new TextFormatter<Integer>(change -> {
            if (!change.getText().isEmpty()) {
                if (change.getText().matches("\\d+")) {
                    int i = Integer.parseInt(change.getControlNewText());
                    if (i >= 0 && i <= 59) {
                        return change;
                    }
                }
                return null;
            }

            return change;
        }));

        // Listener to check if it should disable the continue button
        txtDurationMonth.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableContinue();
        });
        txtDurationDay.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableContinue();
        });
        txtDurationHour.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableContinue();
        });
        txtDurationMinutes.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableContinue();
        });
        txtDurationSeconds.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableContinue();
        });
        txtPeriodeMonth.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableContinue();
        });
        txtPeriodeDay.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableContinue();
        });
        txtPeriodeHour.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableContinue();
        });
        txtPeriodeMinutes.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableContinue();
        });
        txtPeriodeSeconds.textProperty().addListener((observable, oldValue, newValue) -> {
            checkDisableContinue();
        });

        txtSearchUnit.textProperty().addListener((observable, oldValue, newValue) -> {
            refreshUnits();
        });

        refreshUnits();
    }

    /**
     * Method to check if the continue button should be disabled
     */
    private void checkDisableContinue() {
        if (selectedLocataire == null ||
                selectedUnit == null ||
                txtDurationMonth.getText() == null ||
                txtDurationDay.getText() == null ||
                txtDurationHour.getText() == null ||
                txtDurationMinutes.getText() == null ||
                txtDurationSeconds.getText() == null ||
                txtPeriodeMonth.getText() == null ||
                txtPeriodeDay.getText() == null ||
                txtPeriodeHour.getText() == null ||
                txtPeriodeMinutes.getText() == null ||
                txtPeriodeSeconds.getText() == null) {
            btnContinue.setDisable(true);
            return;
        }

        try {
            long periodeMonth = Long.parseLong(txtPeriodeMonth.getText());
            long periodeDay = Long.parseLong(txtPeriodeDay.getText());
            long periodeHour = Long.parseLong(txtPeriodeHour.getText());
            long periodeMinutes = Long.parseLong(txtPeriodeMinutes.getText());
            long periodeSeconds = Long.parseLong(txtPeriodeSeconds.getText());

            Periode p = new Periode(periodeMonth, periodeDay, periodeHour, periodeMinutes, periodeSeconds);

            if (p.isZero()) {
                btnContinue.setDisable(true);
                return;
            }
        } catch (NumberFormatException e) {
            btnContinue.setDisable(true);
            return;
        }

        btnContinue.setDisable(false);
    }

    @FXML
    /**
     * Method triggered when the continue button is clicked
     */
    protected void btnContinue_clicked(ActionEvent e) {
        if (selectedLocataire == null) return;
        if (selectedUnit == null) return;

        Bail newBail = new Bail(selectedLocataire);
        LocalDateTime now = LocalDateTime.now();
        newBail.setDate_debut(now);
        LocalDateTime then = now;
        try {
            long durationMonth = Long.parseLong(txtDurationMonth.getText());
            then = then.plusMonths(durationMonth);
            long durationDay = Long.parseLong(txtDurationDay.getText());
            then = then.plusDays(durationDay);

            long durationHour = Long.parseLong(txtDurationHour.getText());
            then = then.plusHours(durationHour);
            long durationMinutes = Long.parseLong(txtDurationMinutes.getText());
            then = then.plusMinutes(durationMinutes);
            long durationSeconds = Long.parseLong(txtDurationSeconds.getText());
            then = then.plusSeconds(durationSeconds);

            long periodeMonth = Long.parseLong(txtPeriodeMonth.getText());
            long periodeDay = Long.parseLong(txtPeriodeDay.getText());
            long periodeHour = Long.parseLong(txtPeriodeHour.getText());
            long periodeMinutes = Long.parseLong(txtPeriodeMinutes.getText());
            long periodeSeconds = Long.parseLong(txtPeriodeSeconds.getText());

            Periode p = new Periode(periodeMonth, periodeDay, periodeHour, periodeMinutes, periodeSeconds);
            newBail.setDate_fin(then);
            newBail.setPeriode(p);

            newBail.setUnite(selectedUnit);
        } catch (ArithmeticException err) {
            return;
        }

        newBail.setAssurance(txtInsurance.getText());
        newBail.setExtra(cmbExtra.getSelectionModel().getSelectedItem());
        newBail.setRenouvelable(rdoRenewable.isSelected());

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("PaymentInfo.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage window = new Stage();
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);

            PaymentInfoController paymentInfoController = fxmlLoader.getController();
            paymentInfoController.setCurrentBail(newBail);
            paymentInfoController.setPreviousController(this);

            window.show();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    /**
     * Method triggered when the GetLocataire button is clicked
     */
    protected void btnGetLocataire_clicked(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("LocataireList.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage window = new Stage();
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);

            LocataireListController locataireListController = fxmlLoader.getController();
            locataireListController.initData(this);

            window.show();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    protected void btnCancel_clicked(ActionEvent e) {
        ((Stage)btnCancel.getScene().getWindow()).close();
    }

    @FXML
    protected void btnConfirmUnit_clicked(ActionEvent e) {
        selectedUnit = lstUnits.getSelectionModel().getSelectedItem();
        if (selectedUnit != null) {
            txtSelectedUnit.setText(selectedUnit.getAdresse());
        }
    }

    public void closeWindow() {
        ((Stage)btnCancel.getScene().getWindow()).close();
    }
}
