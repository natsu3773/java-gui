package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class UpdateCustomerContactController {
    public void onSubmitEditContact(ActionEvent event) {
    }

    public void onCancelEditContact(ActionEvent event) {
        // Closes the popup
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        //Defensively consume the event
        event.consume();
    }
}
