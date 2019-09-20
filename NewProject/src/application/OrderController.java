package application;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OrderController {

        @FXML private Button btnGoBack;			//button to Save the order and Go Back to Home window
        @FXML private Button btnConfirm;		//button to confirm the order and redirect to confirmation window
        @FXML private Button btnCancel;			//button to cancel the order
        @FXML private TextField username;		//textField for customer name

        //checkBoxes for Light Meal menu
        @FXML private CheckBox cbM1;
        @FXML private CheckBox cbM2;
        @FXML private CheckBox cbM3;
        @FXML private CheckBox cbM4;
        @FXML private CheckBox cbM5;
        @FXML private CheckBox cbM6;
        @FXML private CheckBox cbM7;

        //checkBoxes for Beverages menu
        @FXML private CheckBox cbB1;
        @FXML private CheckBox cbB2;
        @FXML private CheckBox cbB3;
        @FXML private CheckBox cbB4;
        @FXML private CheckBox cbB5;
        @FXML private CheckBox cbB6;
        @FXML private CheckBox cbB7;

        //checkBoxes for Desserts menu
        @FXML private CheckBox cbD1;
        @FXML private CheckBox cbD2;
        @FXML private CheckBox cbD3;
        @FXML private CheckBox cbD4;
        @FXML private CheckBox cbD5;
        @FXML private CheckBox cbD6;
        @FXML private CheckBox cbD7;

        //creating object of OrderList class
        static OrderList _list = new OrderList();
        //Images images = new Images();

        //initializer method
        @FXML public void initializer() {

                //Event Handler when Confirm button is clicked, It calls onConformClicked method
                btnConfirm.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                onConfirmClicked();
                        }
                });

                //Event Handler when Save and Go Back button is clicked, It calls onGoBackClicked method
                btnGoBack.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                onGoBackClicked();
                        }
                });

                //Event Handler when Cancel button is clicked, It calls onCancelClicked method
                btnCancel.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                onCancelClicked();
                        }
                });

        }

        //method to check which checkBox is clicked
        public void onCheckBoxesClicked() {

                //it clears the arrayList
                _list.clear();

                //conditions to check which checkBox is clicked and then add it to the arrayList by creating an object of Order class
                if (cbM1.isSelected()) {
                        _list.addList(new Order("Chicken Mayo", 10.0));
                }

                if (cbM2.isSelected()) {
                        _list.addList(new Order("Chicken Strips", 22.0));
                }

                if (cbM3.isSelected()) {
                        _list.addList(new Order("Chicken Biryani", 30.0));
                }

                if (cbM4.isSelected()) {
                        _list.addList(new Order("Egg Masala", 10.0));
                }

                if (cbM5.isSelected()) {
                        _list.addList(new Order("Veg-Burger", 20.0));
                }

                if (cbM6.isSelected()) {
                        _list.addList(new Order("Green Salad ", 7.0));
                }

                if (cbM7.isSelected()) {
                        _list.addList(new Order("Sushi Bowl", 25.0));
                }

                if (cbB1.isSelected()) {
                        _list.addList(new Order("Fruit Smoothie", 5.0));
                }

                if (cbB2.isSelected()) {
                        _list.addList(new Order("Iced Tea", 4.0));
                }

                if (cbB3.isSelected()) {
                        _list.addList(new Order("Italian Soda", 8.0));
                }

                if (cbB4.isSelected()) {
                        _list.addList(new Order("Kit-Kat Shake", 8.0));
                }

                if (cbB5.isSelected()) {
                        _list.addList(new Order("Coca-Cola", 7.0));
                }

                if (cbB6.isSelected()) {
                        _list.addList(new Order("Lemon Shake", 9.0));
                }

                if (cbB7.isSelected()) {
                        _list.addList(new Order("Hot Chocolate", 9.0));
                }

                if (cbD1.isSelected()) {
                        _list.addList(new Order("Lemon Meringue", 5.0));
                }

                if (cbD2.isSelected()) {
                        _list.addList(new Order("Chesse Cake", 5.0));
                }

                if (cbD3.isSelected()) {
                        _list.addList(new Order("Cup Cake", 4.0));
                }

                if (cbD4.isSelected()) {
                        _list.addList(new Order("Apple Pie", 6.0));
                }

                if (cbD5.isSelected()) {
                        _list.addList(new Order("Carrot Cake", 5.0));
                }

                if (cbD6.isSelected()) {
                        _list.addList(new Order("Carrot Cake", 5.0));
                }

                if (cbD7.isSelected()) {
                        _list.addList(new Order("Vanilla Cake", 5.0));
                }

        }

        //method which is called from HomeController to pass the userName
        public void name(String first, String last) {
                String display = first + " " + last;
                username.setText(display);
        }

        // method to create object of reservation class and the n add it to the arrayList
        public void onConfirmClicked() {
                onCheckBoxesClicked();
                try {
                        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main2.fxml"));
                        Scene scene = new Scene(root, 600, 632);
                        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();
                } catch (Exception e) {
                        e.printStackTrace();

                }
        }

        //method is called when the confirm button is clicked
        public void onGoBackClicked() {
                onCheckBoxesClicked();
                Stage stage = (Stage) btnGoBack.getScene().getWindow();
                stage.close();
        }

        //method is called when the Go Back is Clicked button is clicked
        public void onCancelClicked() {
                // Get a reference to the stage
                Stage stage = (Stage) btnCancel.getScene().getWindow();
                // Close the window
                stage.close();
        }

}
