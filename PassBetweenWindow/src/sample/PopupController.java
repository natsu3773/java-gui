package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class PopupController {

    public void CloseAppFromDialog(ActionEvent actionEvent) {
        // Gracefully exit the application/
        Platform.exit();
    }

    public void CloseDialog(ActionEvent actionEvent)  {
        // Gets the window above which the dialog was drawn and gives control back to it.
        Node  source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        // Defensively consume the event
        actionEvent.consume();
    }


}
