package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

public class RegistrationController extends LoginController implements Initializable{
    public void onSubmitAddRegistration(ActionEvent event) {
    }

    public void onCancelAddRegistration(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        CBX.setSelected(false);
        event.consume();
    }



}
