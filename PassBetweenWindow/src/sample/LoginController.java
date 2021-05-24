package sample;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Controller implements Initializable {
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

            //Update the state Variables for the system
            if (!loggedIn) {
                LocalLabel.setText("Status: Logged In");
                LocalMenuItem.setText("Logout");
                loggedIn=true;
                LocalMenuItem.setOnAction(event -> loggedIn=true);

            }
            if(loggedIn){
                LocalMenuItem.setOnAction(e->{
                    loggedIn=false;
                    LocalLabel.setText("Status: Online");
                    LocalMenuItem.setText("Login");
                    // This resets the event handler such that a client can login again without restarting the application.
                    LocalMenuItem.setOnAction(this::onLogin);

                });
            }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
