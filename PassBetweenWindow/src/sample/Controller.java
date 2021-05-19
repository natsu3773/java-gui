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
    public Label lblSystemState;
    public Timeline timeline;
   @FXML private Label LoggedStatus;

    public void setLoginStatus(String status){
        LoggedStatus.setText(status);
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
        lblSystemState.setText("Status: Online");
        LoggedStatus.setText("false");
    }

    public void onEditProfile(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profile.fxml"));
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
        stage.setTitle("Edit Profile");
        stage.setScene(scene);
        stage.show();
        //Defensively consume the event after handling
        actionEvent.consume();
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
}
