package com.example.projet_inf1163;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewTasksController extends Application {

    @FXML
    protected Group grpNextRenew, grpFuturs, grpModification, grpCollection;

    private int qqtCells = 10;
    private ArrayList<String>[] values;
    private Scene scene;

    // Current indexes
    private int[] indexes = {0, 0, 0, 0};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewTasks.fxml"));
        this.scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.setTitle("Tâches");
        s.setScene(this.scene);
        s.show();
    }

    @FXML
    protected void initialize() {

        this.values = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            this.values[i] = new ArrayList<>();
        }
        for (int i = 0; i < 30; i++) {
            this.values[0].add("Value " + i);
            this.values[1].add("Value " + i);
            this.values[2].add("Value " + i);
            this.values[3].add("Value " + i);
        }

        for (int i = 0; i < 4; i++) {
            this.displayList(i);
        }
    }

    @FXML
    protected void onNext(ActionEvent e) {
        Button b = (Button) e.getSource();
        String id = b.getId();
        int index = Integer.parseInt(id.substring(id.length() - 1));
        this.indexes[index]++;

        if ((long) (this.indexes[index] + 1) * this.qqtCells >= this.values[index].stream().count()) {
            b.setDisable(true);
        }
        b.getParent().lookup("#back" + index).setDisable(false);

        this.displayList(index);
    }

    @FXML
    protected void onBack(ActionEvent e) {
        Button b = (Button) e.getSource();
        String id = b.getId();
        int index = Integer.parseInt(id.substring(id.length() - 1));
        this.indexes[index]--;

        if (this.indexes[index] == 0) {
            b.setDisable(true);
        }
        b.getParent().lookup("#next" + index).setDisable(false);

        this.displayList(index);
    }

    private void displayList(int listIndex) {
        Label lbl;
        VBox vbox = new VBox();
        Group g = this.grpNextRenew;
        switch (listIndex) {
            case 1:
                g = this.grpFuturs;
                break;
            case 2:
                g = this.grpModification;
                break;
            case 3:
                g = this.grpCollection;
                break;
        }
        g.getChildren().clear();

        for (int i = 0; i < this.qqtCells; i++) {
            lbl = new Label();
            lbl.setText(this.values[listIndex].get(i + this.indexes[listIndex] * this.qqtCells));
            vbox.getChildren().add(lbl);
        }

        g.getChildren().add(vbox);
    }
}
