
package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
        static ReservationList _ReservationList = new ReservationList();

        // all the buttons table and continue button an order button
        @FXML private RadioButton btn1;			//first toggle button
        @FXML private RadioButton btn2;			//Second toggle button
        @FXML private RadioButton btn3;			//third toggle button
        @FXML private RadioButton btn4;			//forth toggle button
        @FXML private RadioButton btn5;			//fifth toggle button
        @FXML private RadioButton btn6;			//sixth toggle button
        @FXML private RadioButton btn7;			//seventh toggle button
        @FXML private RadioButton btn8;			//eight toggle button

        @FXML private Label radioButtonlabel;	//first toggle button

        @FXML private Button btncontinue;		//button to redirect to confirmation window
        @FXML private Button btnEnter;			//button to save the timing
        @FXML private Button btnGoBack;			//button to save the reservation and go back to Home Window
        @FXML private Button btnCancel;			//button to cancel the reservation

        @FXML private TextField textName;		//name textField
        @FXML private TextField textTime;		//time textField

        private ToggleGroup radioButtons;		//method used for toggle buttons

        @FXML public void initialize() {
                // Add initialization code you need in here
                radioButtonlabel.setText(" ");		//label null for radio buttons
                radioButtons = new ToggleGroup();   //creating toggleGroup class

                //assigning the button to toggleGroup
                this.btn1.setToggleGroup(radioButtons);
                this.btn2.setToggleGroup(radioButtons);
                this.btn3.setToggleGroup(radioButtons);
                this.btn4.setToggleGroup(radioButtons);
                this.btn5.setToggleGroup(radioButtons);
                this.btn6.setToggleGroup(radioButtons);
                this.btn7.setToggleGroup(radioButtons);
                this.btn8.setToggleGroup(radioButtons);

                //on each radio button selection, it calls the radioButton method
                btn1.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                                radioButtonChenged();
                        }
                });

                btn2.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                                radioButtonChenged();
                        }
                });

                btn3.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                                radioButtonChenged();
                        }
                });

                btn4.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                                radioButtonChenged();
                        }
                });

                btn5.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                                radioButtonChenged();
                        }
                });

                btn6.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                                radioButtonChenged();
                        }
                });
                btn7.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                                radioButtonChenged();
                        }
                });
                btn8.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                                radioButtonChenged();
                        }
                });

                btncontinue.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                                buttonChange();
                        }

                });

                btnEnter.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                                EnterChange();
                        }
                });

                btnGoBack.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                onGoBackClicked();
                        }
                });

                btnCancel.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                System.out.print("working?");
                                onCancelClicked();
                        }
                });
        }


        public void radioButtonChenged() {

                //conditions if any radio button is selected, it will print out the table they selected
                //getSelected toggle method is used to compare with the button to the radio buttons that was initialized in the initializer method
                if (this.radioButtons.getSelectedToggle().equals(this.btn1))
                        radioButtonlabel.setText("You selected table 1");

                if (this.radioButtons.getSelectedToggle().equals(this.btn2))
                        radioButtonlabel.setText("You selected table 2");

                if (this.radioButtons.getSelectedToggle().equals(this.btn3))
                        radioButtonlabel.setText("You selected table 3");

                if (this.radioButtons.getSelectedToggle().equals(this.btn4))
                        radioButtonlabel.setText("You selected table 4");

                if (this.radioButtons.getSelectedToggle().equals(this.btn5))
                        radioButtonlabel.setText("You selected table 5");

                if (this.radioButtons.getSelectedToggle().equals(this.btn6))
                        radioButtonlabel.setText("You selected table 6");

                if (this.radioButtons.getSelectedToggle().equals(this.btn7))
                        radioButtonlabel.setText("You selected table 7");

                if (this.radioButtons.getSelectedToggle().equals(this.btn8))
                        radioButtonlabel.setText("You selected table 8");

        }

        //method which is called from HomeController to pass the userName
        public void name(String first, String last) {
                String display = first + " " + last;
                textName.setText(display);
        }

        // method to create object of reservation class and the n add it to the arrayList
        private void EnterChange() {

                //try block to check if the customer enters an except integer for the Time field
                try{
                // create a reservation
                Reservation p1 = new Reservation(textName.getText(), Integer.parseInt(textTime.getText()));
                // TODO: add obj to arraylist
                _ReservationList.saveData(p1);

                }
                catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please type an Integer only. For Example, to book for 7:00 p.m, type just 7.");
                alert.showAndWait();
                return;
                }
        }

        //method is called when the confirm button is clicked
        private void buttonChange() {
                EnterChange();

                //condition to check if time is entered by customer
                if(textTime.getText().length() > 0){
                        _ReservationList.load();

                        try {
                                AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main2.fxml"));
                                Scene scene = new Scene(root, 600, 632);
                                scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                                Stage secondStage = new Stage();
                                secondStage.setScene(scene);
                                secondStage.initModality(Modality.APPLICATION_MODAL);
                                secondStage.showAndWait();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }
        }

        //method is called when the Go Back is Clicked button is clicked
        public void onGoBackClicked() {
                EnterChange();

                //condition to check if time is entered by customer
                if(textTime.getText().length() > 0){
                        _ReservationList.load();

                EnterChange();
                Stage stage = (Stage) btnGoBack.getScene().getWindow();
                stage.close();
        }
        }

        //method is called when the cancel button is clicked
        public void onCancelClicked() {
                // Get a reference to the stage
                Stage stage = (Stage) btnCancel.getScene().getWindow();
                // Close the window
                stage.close();
        }
}
