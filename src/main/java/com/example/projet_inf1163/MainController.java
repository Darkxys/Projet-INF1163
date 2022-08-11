package com.example.projet_inf1163;

import com.example.projet_inf1163.src.Bail;
import com.example.projet_inf1163.src.BailCatalogue;
import com.example.projet_inf1163.src.Unite;
import com.example.projet_inf1163.src.UniteCatalogue;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController extends Application {

    @FXML
    private Group grpUnit;
    @FXML
    private ListView<Bail> lstBail;

    private int unitIndex = 0;
    private int qttCells = 10;
    private ArrayList<Unite> units = new ArrayList<>();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    protected void initialize(){
        ArrayList<Bail> bails = BailCatalogue.getBails();
        this.units = UniteCatalogue.getUnits();

        lstBail.getItems().addAll(bails);
        lstBail.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() >= 2) {
                    ViewBailController.selectedBail = lstBail.getSelectionModel().getSelectedItem();

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("ViewBail.fxml"));
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
            }
        });

        this.displayList();
    }

    @FXML
    protected void onNext(ActionEvent e) {
        Button b = (Button) e.getSource();
        String id = b.getId();
        int index = Integer.parseInt(id.substring(id.length() - 1));
        this.unitIndex++;

        if ((long) (this.unitIndex + 1) * this.qttCells >= this.units.size()) {
            b.setDisable(true);
        }
        b.getParent().lookup("#back" + index).setDisable(false);

        this.displayList();
    }

    @FXML
    protected void onBack(ActionEvent e) {
        Button b = (Button) e.getSource();
        String id = b.getId();
        int index = Integer.parseInt(id.substring(id.length() - 1));
        this.unitIndex--;

        if (this.unitIndex == 0) {
            b.setDisable(true);
        }
        b.getParent().lookup("#next" + index).setDisable(false);

        this.displayList();
    }

    private void displayList() {
        ListView<Unite> lstView = new ListView<>();
        lstView.setPrefHeight(400);
        grpUnit.getChildren().clear();

        for (int i = 0; i < this.qttCells; i++) {
            int index = i + this.unitIndex * this.qttCells;
            if(index >= this.units.size()) break;

            lstView.getItems().add(this.units.get(index));
        }

        lstView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() >= 2) {
                    ViewUnitController.selectedIndex = UniteCatalogue.getUnits().indexOf(lstView.getSelectionModel().getSelectedItem());

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("ViewUnit.fxml"));
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
            }
        });

        grpUnit.getChildren().add(lstView);
    }

    @FXML
    protected void btnAddBail_clicked(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("AddBail.fxml"));
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
    protected void btnTasks_clicked(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("ViewTasks.fxml"));
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
    protected void btnAddUnit_clicked(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("AddUnit.fxml"));
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
}
