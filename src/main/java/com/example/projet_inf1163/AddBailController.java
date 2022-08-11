package com.example.projet_inf1163;

import com.example.projet_inf1163.src.Bail;
import com.example.projet_inf1163.src.Locataire;
import com.example.projet_inf1163.src.Periode;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddBailController extends Application {
    public static Locataire selectedLocataire;

    @FXML
    private Button btnCancel, btnGetLocataire, btnConfirmUnit, btnContinue;
    @FXML
    private TextField txtLocataire, txtSearchUnit, txtPeriodeMonth, txtPeriodeDay, txtPeriodeHour, txtPeriodeMinutes, txtPeriodeSeconds, txtDurationMonth, txtDurationDay, txtDurationHour, txtDurationMinutes, txtDurationSeconds, txtInsurance;
    @FXML
    private CheckBox rdoRenewable, rdoOption1, rdoOption2, rdoOption3, rdoOption4, rdoOption5, rdoOption6;

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("AddBail.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Créer Bail");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void initialize() {
        selectedLocataire = null;
    }

    @FXML
    protected void btnContinue_clicked(ActionEvent e) {
        if (selectedLocataire == null) return;
        Bail newBail = new Bail(selectedLocataire);
        LocalDateTime now = LocalDateTime.now();
        newBail.setDate_debut(now);
        LocalDateTime then = now;
        long durationMonth = Long.getLong(txtDurationMonth.getText());
        then = then.plusMonths(durationMonth);
        long durationDay = Long.getLong(txtDurationDay.getText());
        then = then.plusDays(durationDay);

        long durationHour = Long.getLong(txtDurationHour.getText());
        then = then.plusHours(durationHour);
        long durationMinutes = Long.getLong(txtDurationMinutes.getText());
        then = then.plusMinutes(durationMinutes);
        long durationSeconds = Long.getLong(txtDurationSeconds.getText());
        then = then.plusSeconds(durationSeconds);

        long periodeMonth = Long.getLong(txtPeriodeMonth.getText());
        long periodeDay = Long.getLong(txtPeriodeDay.getText());
        long periodeHour = Long.getLong(txtPeriodeHour.getText());
        long periodeMinutes = Long.getLong(txtPeriodeMinutes.getText());
        long periodeSeconds = Long.getLong(txtPeriodeSeconds.getText());

        newBail.setDate_fin(then);

        newBail.setAssurance(txtInsurance.getText());

        Periode p = new Periode(periodeMonth, periodeDay, periodeHour, periodeMinutes, periodeSeconds);
        newBail.setPeriode(p);

        newBail.setRenouvelable(rdoRenewable.isSelected());

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("PaymentInfo.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage window = new Stage();
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);
            window.show();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    protected void btnGetLocataire_clicked(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("LocataireList.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage window = new Stage();
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);
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
}
