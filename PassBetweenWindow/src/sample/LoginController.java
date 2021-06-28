package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Controller implements Initializable {
    Validation validation;
    @FXML private TextField username;
    @FXML private PasswordField pass;
    @FXML private CheckBox CheckRegistration;
    public static CheckBox CBX;
    public static boolean FirstTime=false;

    public void onLoginClick(ActionEvent actionEvent) {
        String un = username.getText();
        String pw = pass.getText();
        /*
            Put validation logic for user account here.
            If valid credentials: use the try catch block . Else consume the event.
            Assume valid credentials for navigation testing.
         */
        try {
            //Update the state Variables for the system if the user logs in
            // Validation will trigger events if the user attempts to log in with blank fields
            if (!loggedIn) {
                // If a user is an admin they can perform all tasks therefore enabling all buttons
                if(un.equalsIgnoreCase("Admin") && pw.equalsIgnoreCase("Admin")){
                    AddCust.setDisable(false);
                    EditCust.setDisable(false);
                    DelCust.setDisable(false);
                    AddAddr.setDisable(false);
                    EditAddr.setDisable(false);
                    DelAddr.setDisable(false);
                    AddCont.setDisable(false);
                    EditContact.setDisable(false);
                    DelContact.setDisable(false);
                    AddFin.setDisable(false);
                    EditFin.setDisable(false);
                    DelFin.setDisable(false);
                    SAddLoan.setDisable(false);
                    SEditLoan.setDisable(false);
                    DelLoan.setDisable(false);
                    EditCust.setVisible(true);
                    DelCust.setVisible(true);
                    EditContact.setVisible(true);
                    DelContact.setVisible(true);
                    EditAddr.setVisible(true);
                    DelAddr.setVisible(true);
                    EditFin.setVisible(true);
                    DelFin.setVisible(true);
                    SEditLoan.setVisible(true);
                    DelLoan.setVisible(true);
                }
                // enable buttons for first time on system to complete registration
                // *NB Still need to add credential check later
                if(FirstTime){
                    AddCust.setDisable(false);
                    AddCont.setDisable(false);
                    AddAddr.setDisable(false);
                    AddFin.setDisable(false);
                    SAddLoan.setDisable(false);
                }


                //Updates labels and menu items once logged in successfully
                LocalLabel.setText("Status: Logged In");
                LocalMenuItem.setText("Logout");
                loggedIn=true;
                LocalMenuItem.setOnAction(event -> loggedIn=true);
                ProfileEdit.setOnAction(event -> loggedIn=true);


            }
            // Update the state Variables for the system after logging out
            if(loggedIn){
                LocalMenuItem.setOnAction(e->{
                    loggedIn=false;
                    LocalLabel.setText("Status: Online");
                    LocalMenuItem.setText("Login");
                    // This resets the event handler such that a client can login again without restarting the application.
                    LocalMenuItem.setOnAction(this::onLogin);
                    ProfileEdit.setOnAction(this::onLogin);
                    //Ensures that the access to all actions are restricted after logging out.
                    AddCust.setDisable(true);
                    EditCust.setDisable(true);
                    DelCust.setDisable(true);
                    AddAddr.setDisable(true);
                    EditAddr.setDisable(true);
                    DelAddr.setDisable(true);
                    AddCont.setDisable(true);
                    EditContact.setDisable(true);
                    DelContact.setDisable(true);
                    AddFin.setDisable(true);
                    EditFin.setDisable(true);
                    DelFin.setDisable(true);
                    SAddLoan.setDisable(true);
                    SEditLoan.setDisable(true);
                    DelLoan.setDisable(true);
                    EditCust.setVisible(false);
                    DelCust.setVisible(false);
                    EditContact.setVisible(false);
                    DelContact.setVisible(false);
                    EditAddr.setVisible(false);
                    DelAddr.setVisible(false);
                    EditFin.setVisible(false);
                    DelFin.setVisible(false);
                    SEditLoan.setVisible(false);
                    DelLoan.setVisible(false);
                });

                ProfileEdit.setOnAction(e->{
                    FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("Profile.fxml"));
                    try {
                        Parent parent = fxmlLoader.load();
                        Scene scene = new Scene(parent);
                        Stage stage = new Stage();
                        //Blocks other interactions before it is dealt with.
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException ev) {
                        ev.printStackTrace();
                    }
                });
            }
            // Closes the popup window
            Node source = (Node)  actionEvent.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();
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
            CBX = CheckRegistration;
    }

    public void onCheckRegistration(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstUserCheck.fxml"));
        try {
            Parent parent = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            //Defensively consume event
            event.consume();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
