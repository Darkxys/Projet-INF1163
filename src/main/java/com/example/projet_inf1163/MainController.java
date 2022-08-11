package com.example.projet_inf1163;

import com.example.projet_inf1163.src.Bail;
import com.example.projet_inf1163.src.BailCatalogue;
import com.example.projet_inf1163.src.Unite;
import com.example.projet_inf1163.src.UniteCatalogue;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    //region FXML variables
    @FXML
    private Group grpUnit;
    @FXML
    private ListView<Bail> lstBail;
    //endregion FXML variables

    //region Properties declaration
    private int unitIndex = 0;
    private int qttCells = 10;
    private ArrayList<Unite> units = new ArrayList<>();
    //endregion Properties declaration

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

    /**
     * Method to refresh the bails
     */
    public void refreshBails() {
        ObservableList<Bail> bails = FXCollections.observableList(BailCatalogue.getBails());
        lstBail.setItems(bails);
    }

    @FXML
    /**
     * Method to initialize the units list and the bails list
     */
    protected void initialize(){
        this.units = UniteCatalogue.getUnits();

        refreshBails();
        lstBail.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() >= 2) {
                    ViewBailController.selectedIndex = BailCatalogue.getBails().indexOf(lstBail.getSelectionModel().getSelectedItem());

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
    /**
     * Method triggered when the -> is clicked
     * Change the batch to the next one
     */
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
    /**
     * Method triggered when the <- is clicked.
     * Change the batch to the previous one
     */
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

    /**
     * Method to display the unit list in batch mode
     */
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
                        window.setOnHiding( event -> {
                            displayList();
                        } );
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
    /**
     * When the add button of Bail is clicked, open the Add Bail window
     */
    protected void btnAddBail_clicked(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("AddBail.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage window = new Stage();
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);

            AddBailController addBailController = fxmlLoader.getController();
            addBailController.setPreviousController(this);

            window.show();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    /**
     * When the Tasks button is clicked, open the Tasks window
     */
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
    /**
     * When the add button of Unit is clicked, open the Add Unit window
     */
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
