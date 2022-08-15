package com.example.projet_inf1163;

import com.example.projet_inf1163.src.Bail;
import com.example.projet_inf1163.src.BailCatalogue;
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
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ViewTasksController extends Application {

    // FXML variables
    @FXML
    protected Group grpNextRenew, grpFuturs, grpModification, grpCollection;

    //region Properties declaration
    private int qttCells = 10;
    private ArrayList<Bail>[] values;
    private Scene scene;
    //endregion Properties declaration

    // Current indexes
    private int[] indexes = {0, 0, 0, 0};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ViewTasksController.class.getResource("ViewTasks.fxml"));
        this.scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.setTitle("Tâches");
        s.setScene(this.scene);
        s.show();
    }

    /**
     * Method to generate bail for next renewal
     * @return
     */
    public ArrayList<Bail> generateNextRenew(){
        ArrayList<Bail> lst = new ArrayList<>();

        for(Bail b : BailCatalogue.getBails()){
            if(b.getPeriode() == null) continue;

            if(b.isRenouvelable() && b.getPeriode().add(b.getDate_fin(), -6).isBefore(LocalDateTime.now())){
                lst.add(b);
            }
        }

        return lst;
    }

    /**
     * Method to generate the list of future people
     * @return
     */
    public ArrayList<Bail> generateFuturs(){
        ArrayList<Bail> lst = new ArrayList<>();

        for(Bail b : BailCatalogue.getBails()){
            if(b.getPeriode() == null) continue;

            if(!b.isRenouvelable() && b.getPeriode().add(b.getDate_fin(), -5).isBefore(LocalDateTime.now())){
                lst.add(b);
            }
        }

        return lst;
    }

    /**
     * Method to generate the lift for modification
     * @return
     */
    public ArrayList<Bail> generateModif(){
        ArrayList<Bail> lst = new ArrayList<>();

        for(Bail b : BailCatalogue.getBails()){
            if(b.getPeriode() == null) continue;

            if(b.getPeriode().add(b.getDate_fin(), -6).isBefore(LocalDateTime.now())){
                lst.add(b);
            }
        }

        return lst;
    }

    /**
     * Method to generate the list for collection
     * @return
     */
    private ArrayList<Bail> generateCollection(){
        ArrayList<Bail> lst = new ArrayList<>();

        for(Bail b : BailCatalogue.getBails()){
            if(b.getPeriode() == null) continue;

            // Add verification code here
        }

        return lst;
    }


    @FXML
    /**
     * Method to initialize all the components of the tasks viewer
     */
    protected void initialize() {

        this.values = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            this.values[i] = new ArrayList<>();
        }
        this.values[0] = generateNextRenew();
        this.values[1] = generateFuturs();
        this.values[2] = generateModif();

        for (int i = 0; i < 3; i++) {
            this.displayList(i);
        }
    }

    @FXML
    /**
     * To go to the next batch
     */
    protected void onNext(ActionEvent e) {
        Button b = (Button) e.getSource();
        String id = b.getId();
        int index = Integer.parseInt(id.substring(id.length() - 1));
        this.indexes[index]++;

        if ((long) (this.indexes[index] + 1) * this.qttCells >= this.values[index].size()) {
            b.setDisable(true);
        }
        b.getParent().lookup("#back" + index).setDisable(false);

        this.displayList(index);
    }

    @FXML
    /**
     * To go to the previous batch
     */
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

    /**
     * Method to display the current batch of items
     * @param listIndex
     */
    private void displayList(int listIndex) {
        // Create a dummy label
        Label lbl;
        // Create a vbox to contain the list
        VBox vbox = new VBox();
        // Get the group that needs to display their list
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
        // Remove all children to re-populate
        g.getChildren().clear();

        // For loop with a maximum of qttCells per page
        for (int i = 0; i < this.qttCells; i++) {
            // Get the element index to display
            int index = i + this.indexes[listIndex] * this.qttCells;
            // When the index is over the size of array, get out of for loop
            if(index >= this.values[listIndex].size()) break;

            // Instantiate a new label
            lbl = new Label();
            // Set the label text to the value of the list
            lbl.setText(this.values[listIndex].get(index).toString());
            // Put the label into the vbox
            vbox.getChildren().add(lbl);
        }

        // Put the vbox into the group
        g.getChildren().add(vbox);
    }
}
