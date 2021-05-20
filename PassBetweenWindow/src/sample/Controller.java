package sample;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Controller implements Initializable {
    // variables to use in initialization section
    public Label lblTime;
    @FXML private Label lblSystemState;
    public Timeline timeline;
   @FXML private Label LoggedStatus;

    public void setLoginStatus(){

        LoggedStatus.setText("true");
        System.out.println("Logged in: " + LoggedStatus.getText());
    }

    public void Search(ActionEvent actionEvent) {
        /*
        ADD SEARCH CODE HERE!!
         */
        // Defensively consume event
        actionEvent.consume();
    }

    public void onDialogPopup(ActionEvent actionEvent){
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        //Blocks other interactions before it is dealt with.
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
        //Defensively consume the event after handling
        actionEvent.consume();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //once fxml has been parsed this will run on a thread that can access the JavaFX thread.
        /*
         the next 3 lines create what is essentially an animation that updates every second and gets shown on screen
         a certain number of times or, in this case until the application is closed.
         Line 68 simply starts the animation and as it is in the initialise method will start the thread correctly.
          */
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            String current = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            lblTime.setText("System Time: " + current);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        //set defaults of online status an login status
        if(LoggedStatus.getText() == "true"){
            lblSystemState.setText("Status: Logged In");
        }else {
            lblSystemState.setText("Status: Online");

        };
    }

    public void onEditProfile(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
         FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("Profile.fxml"));
            try {
             Parent parent = fxmlLoader.load();
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                //Blocks other interactions before it is dealt with.
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Edit Profie");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public void onAboutClick(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);

        Stage stage = new Stage();
        stage.setTitle("About");
        //Blocks other interactions before it is dealt with.
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
        //Defensively consume the event after handling
        actionEvent.consume();
    }

    public void onLogin(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);

        Stage stage = new Stage();
        //Blocks other interactions before it is dealt with.
        stage.setScene(scene);
        stage.show();
        //Defensively consume the event after handling
        actionEvent.consume();
    }

    public void onAddCustomer(ActionEvent actionEvent) {
    }

    public void onEditCustomer(ActionEvent actionEvent) {
    }

    public void onDeleteCustomer(ActionEvent actionEvent) {
    }

    public void onAddAddress(ActionEvent actionEvent) {
    }

    public void onEditAddress(ActionEvent actionEvent) {
    }

    public void onDeleteAddress(ActionEvent actionEvent) {
    }

    public void onAddFinancialRecord(ActionEvent actionEvent) {
    }

    public void onEditFinancialRecord(ActionEvent actionEvent) {
    }

    public void onDeleteFinancialRecord(ActionEvent actionEvent) {
    }

    public void onAddLoan(ActionEvent actionEvent) {
    }

    public void onEditLoan(ActionEvent actionEvent) {
    }

    public void onDeleteLoan(ActionEvent actionEvent) {
    }
}
