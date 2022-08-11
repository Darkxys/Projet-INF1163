package com.example.projet_inf1163;

import com.example.projet_inf1163.src.Bail;
import com.example.projet_inf1163.src.BailCatalogue;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private ArrayList<String> values = new ArrayList<>();

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

        lstBail.getItems().addAll(bails);


        for(int i = 0; i < 33; i++){
            this.values.add("Value : " + i);
        }
        this.displayList();
    }

    @FXML
    protected void onNext(ActionEvent e) {
        Button b = (Button) e.getSource();
        String id = b.getId();
        int index = Integer.parseInt(id.substring(id.length() - 1));
        this.unitIndex++;

        if ((long) (this.unitIndex + 1) * this.qttCells >= this.values.size()) {
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
        ListView<String> lstView = new ListView<>();
        grpUnit.getChildren().clear();

        for (int i = 0; i < this.qttCells; i++) {
            int index = i + this.unitIndex * this.qttCells;
            if(index >= this.values.size()) break;

            lstView.getItems().add(this.values.get(index));
        }

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
}
