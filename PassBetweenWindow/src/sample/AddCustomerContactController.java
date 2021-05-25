package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AddCustomerContactController {
    public void onSubmitAddContact(ActionEvent event) {
    }

    public void onCancelAddContact(ActionEvent event) {
        // Closes the popup
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        //Defensively consume the event
        event.consume();
    }
}
