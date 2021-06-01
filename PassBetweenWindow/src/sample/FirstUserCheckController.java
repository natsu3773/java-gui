package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstUserCheckController implements Initializable {
    @FXML private RadioButton radioEmployee;
    @FXML private RadioButton radioCustomer;
    FXMLLoader loader;
    public void onStartRegistration(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        if(radioCustomer.isSelected()){
            loader = new FXMLLoader(getClass().getResource("Registration.fxml"));
            Parent parent=null;
            try {
                parent = loader.load();
                stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(radioEmployee.isSelected()){
            loader = new FXMLLoader(getClass().getResource("EmployeeRegistration.fxml"));
            try {
                Parent parent = loader.load();
                stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!radioEmployee.isSelected() && !radioCustomer.isSelected()) {
            loader = new FXMLLoader(getClass().getResource("IncompleteError.fxml"));
            try {
                Parent parent = loader.load();
                stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
