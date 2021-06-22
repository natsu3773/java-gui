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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    // variables to use to handle state and initialization of the window
    public Label lblTime;
    public Timeline timeline;

    @FXML private Label lblSystemState;
    @FXML private MenuItem EditProfile;
    @FXML private MenuItem LoginMenuItem;
    @FXML private Button AddCustomer;
    @FXML private Button EditCustomer;
    @FXML private Button DeleteCustomer;
    @FXML private Button AddContactInfo;
    @FXML private Button EditContactInfo;
    @FXML private Button DeleteContactInfo;
    @FXML private Button AddAddress;
    @FXML private Button EditAddress;
    @FXML private Button DeleteAddress;
    @FXML private Button AddFinancialRecord;
    @FXML private Button EditFinancialRecord;
    @FXML private Button DeleteFinancialRecord;
    @FXML private Button AddLoan;
    @FXML private Button EditLoan;
    @FXML private Button DeleteLoan;
    public static MenuItem ProfileEdit;
    public static MenuItem LocalMenuItem;
    public static Label LocalLabel;
    public static boolean loggedIn = false;
    public static Button AddCust;
    public static Button EditCust;
    public static Button DelCust;
    public static Button AddCont;
    public static Button EditContact;
    public static Button DelContact;
    public static Button AddAddr;
    public static Button EditAddr;
    public static Button DelAddr;
    public static Button AddFin;
    public static Button EditFin;
    public static Button DelFin;
    public static Button SAddLoan;
    public static Button SEditLoan;
    public static Button DelLoan;


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
            LocalLabel = lblSystemState;
            LocalMenuItem = LoginMenuItem;
            ProfileEdit = EditProfile;
            AddCust = AddCustomer;
            EditCust = EditCustomer;
            DelCust = DeleteCustomer;
            AddCont = AddContactInfo;
            EditContact = EditContactInfo;
            DelContact = DeleteContactInfo;
            AddAddr = AddAddress;
            EditAddr = EditAddress;
            DelAddr = DeleteAddress;
            AddFin = AddFinancialRecord;
            EditFin = EditFinancialRecord;
            DelFin = DeleteFinancialRecord;
            SAddLoan = AddLoan;
            SEditLoan = EditLoan;
            DelLoan = DeleteLoan;
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

    }


    public void onEditProfile(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
         FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("Login.fxml"));
            try {
             Parent parent = fxmlLoader.load();
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                //Blocks other interactions before it is dealt with.
                stage.initModality(Modality.APPLICATION_MODAL);
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
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
        //Defensively consume the event after handling
        actionEvent.consume();
    }

    public void onAddCustomer(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCustomerInfo.fxml"));
        Parent parent;
        try {
            parent = loader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Add new customer");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            actionEvent.consume();
        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }

    public void onEditCustomer(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("UpdateCutomerInfo.fxml"));
        Parent parent;
        try {
           parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Edit Customer Info");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }

    public void onDeleteCustomer(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeleteCheck.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete Customer");
            stage.show();
            actionEvent.consume();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onAddAddress(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("AddAddressInfo.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add Address Info");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }

    public void onEditAddress(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("UpdateAddressInfo.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Edit Address Info");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }

    public void onDeleteAddress(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("DeleteCheck.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete Record");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }

    public void onAddFinancialRecord(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("AddFinancialInfo.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add Financial Info");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }

    public void onEditFinancialRecord(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("UpdateCustomerFInancialInfo.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Edit Financial Info");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }

    public void onDeleteFinancialRecord(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("DeleteCheck.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete Record");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }

    public void onAddLoan(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("AddLoan.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add Loan Info");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onEditLoan(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("UpdateCutomerLoanInfo.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Edit Loan Info");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }

    public void onDeleteLoan(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("DeleteCheck.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete Record");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        actionEvent.consume();
    }

    public void onAddContactInfo(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("AddCustomerContact.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add Contact Info");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }

    public void onEditContactInfo(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("UpdateCustomerContact.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Edit Contact Info");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }

    public void onDeleteContactInfo(ActionEvent actionEvent) {
        //Gets the contents from the fxml and displays it onto a new window focus on the new popup window.
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("DeleteCheck.fxml"));
        try {

            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setUserData(new Client());
            //Blocks other interactions before it is dealt with.
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete Record");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        actionEvent.consume();
    }
}
