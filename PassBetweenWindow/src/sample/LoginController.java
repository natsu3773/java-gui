package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javafx.scene.Parent;
import javafx.stage.Stage;

public class LoginController {

    public void onLoginClick(ActionEvent actionEvent) {
        /*
            Put validation logic for user account here.
            If valid credentials: move the try catch block inside the if block. Else consume the event.
            Assume valid credentials for navigation testing.
         */
        try {
            // Gets the current window and controls and closes it.
            Node source = (Node)  actionEvent.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent parent = loader.load();
            Controller controller = loader.getController();
            controller.setLoginStatus("true");

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Else  Defensively consume event
        actionEvent.consume();
    }

    public void onCancelClick(ActionEvent actionEvent) {
        // Gets the current window and controls and closes it.
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        // Defensively consume the event
        actionEvent.consume();
    }
}
