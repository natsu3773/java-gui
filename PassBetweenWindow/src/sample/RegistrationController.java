package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController extends LoginController implements Initializable{
    public void onSubmitAddRegistration(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        CBX.setSelected(false);
        FirstTime = true;
        event.consume();
    }

    public void onCancelAddRegistration(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        CBX.setSelected(false);
        FirstTime = false;
        event.consume();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
