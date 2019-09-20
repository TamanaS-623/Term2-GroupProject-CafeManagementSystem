package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondController {

        static ReservationList _ReservationList = MainController._ReservationList;
        static OrderList _list = OrderController._list;

        @FXML
        private TextArea textArea;
        @FXML
        private Button btnClose;

        @FXML
        private void initialize() {
                // Attach event handler(s)
                btnClose.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                                buttonClose(); // Always call a method in the outer class
                        }
                });

                    // String display = "";
                System.out.println(_ReservationList.toString());
                for (int index = 0; index < _ReservationList.size(); index++) {
                        String display = _ReservationList.get(index) + "\n";
                        textArea.appendText(display);
                }

                // OrderList list;
                for (int i = 0; i < _list.getSize(); i++) {
                        String display = _list.getOrder(i) + "\n";

                        textArea.appendText(display);
                        System.out.println(_list.get(i));
                        System.out.println();
                }

        }

        private void buttonClose() {
                // Get a reference to the stage
                Stage stage = (Stage) btnClose.getScene().getWindow();
                // Close the window
                stage.close();
        }
}
