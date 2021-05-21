package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginController {
@FXML Label label;

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

            stage.setScene(parent.getScene());
            Controller con = loader.getController();
            con.setLoginStatus();
            // Defensively consume event
            actionEvent.consume();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
