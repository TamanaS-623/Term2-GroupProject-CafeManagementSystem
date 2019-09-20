package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HomeController {
        @FXML private Button btnOrder;			//order button
        @FXML private Button btnReservation;	//reservation button
        @FXML private TextField fieldFirstName;	//first name test field
        @FXML private TextField fieldLastName;	//last name text field

        private String firstName;				//variable for firstname
        private String lastName;				//variable for lastname

        //initialize method
        @FXML private void initialize(){

                //Event handler when order button is clicked
                btnOrder.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event){
                                onOrderClicked();
                        }
                });

                //Event handler when reservation button is clicked
                btnReservation.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent event){
                                onReservationClicked();
                        }
                });
        }

        //method to assign the first and last name from test field to variables
        public void name(){

                        firstName = fieldFirstName.getText();  //gets the first name from firstName textField and assigns it to firstName variable
                        lastName = fieldLastName.getText();		//gets the last name from lastName textField and assigns it to lastName variable


                        //condition to check firstname and last name is not null and if it is then display dialog bos
                 if(firstName.length() < 1 && lastName.length() < 1){
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter your first and/or last Name first!");
                        alert.showAndWait();
                        return;
                }
        }



        //method that opens order window when order button is clicked
        public void onOrderClicked(){
                name();

                //condition to check if firstname and lastname is entered
                if (firstName.length() > 1 || lastName.length() > 1) {
                        FXMLLoader Loader = new FXMLLoader();
                        Loader.setLocation(getClass().getResource("Order.fxml"));
                        try {
                                Loader.load();
                        } catch(Exception e) {
                                e.printStackTrace();
                        }

                        OrderController display = Loader.getController();
                        display.name(firstName, lastName);
                        Parent root = Loader.getRoot();
                        Stage OrderStage = new Stage();
                        OrderStage.setScene(new Scene(root));
                        OrderStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
                        OrderStage.showAndWait();
                }
        }


        //method that opens reservation window when reservation button is clicked
        public void onReservationClicked(){
                name();

                //condition to check if firstName and last name is entered
                if (firstName.length() > 1 || lastName.length() > 1 ) {

                        FXMLLoader Loader = new FXMLLoader();
                        Loader.setLocation(getClass().getResource("Main.fxml"));
                        try {
                                Loader.load();

                        } catch(Exception e) {
                                e.printStackTrace();
                        }

                        MainController display = Loader.getController();
                        display.name(firstName, lastName);

                        Parent root = Loader.getRoot();
                        Stage reservationStage = new Stage();
                        reservationStage.setScene(new Scene(root));
                        reservationStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
                        reservationStage.showAndWait();
                }
        }

}
