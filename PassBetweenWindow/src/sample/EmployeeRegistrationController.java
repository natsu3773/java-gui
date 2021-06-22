package sample;

import BLL.GenEmployeeUsername;
import BLL.RoleHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeRegistrationController extends LoginController implements Initializable {
    @FXML private ComboBox cbxRoles;
    @FXML private TextField txtEmployeeName;
    @FXML private TextField txtEmployeeSurname;
    @FXML private TextField txtEmployeeUsername;



    public void onSubmitAddEmployeeRegistration(ActionEvent event) {
        String name = txtEmployeeName.getText();
        String surname = txtEmployeeSurname.getText();
        String access = cbxRoles.getSelectionModel().getSelectedItem().toString();
        GenEmployeeUsername gen = new GenEmployeeUsername();
        String username = gen.GenerateID(access,name,surname);
        txtEmployeeUsername.setText(username);
        event.consume();
    }

    public void onCancelAddEmployeeRegistration(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        LoginController.CBX.setSelected(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Do auto-generation of employeeID here.
        RoleHandler rh = new RoleHandler();
        cbxRoles.getItems().addAll(rh.populateRoles());
    }
}
