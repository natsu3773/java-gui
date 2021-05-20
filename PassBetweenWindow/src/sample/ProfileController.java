package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileController {

    public void onUpdateProfile(ActionEvent actionEvent) {
    /*
    Add code to update table in database here.
     */
        // Gets the current window and controls and closes it.
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

        try {
            Parent parent = loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

            // Defensively consume the event
            actionEvent.consume();
    }

    public void onUpdateProfileCancel(ActionEvent actionEvent) {
        // Gets the current window and controls and closes it.
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        // Defensively consume the event
        actionEvent.consume();
    }
}
