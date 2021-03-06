package sample;

import BLL.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateCustomerInfoController implements Initializable {
    @FXML
    private ComboBox EditCustYear;
    @FXML private ComboBox EditCustMonth;
    @FXML private ComboBox EditCustDay;
    @FXML private ComboBox EditCustGender;
    @FXML private ComboBox EditCustEthnicity;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //local instances of the concrete gender ethnicity date handler abstract classes.
        YearHandler dates = new YearHandler();
        MonthHandler mh = new MonthHandler();
        DayHandler dh = new DayHandler();
        GenderHandler gh = new GenderHandler();
        EthnicityHandler eh = new EthnicityHandler();
        //adds year month and day items to the combo boxes.
        EditCustYear.getItems().addAll(dates.populateYearSelection());
        EditCustMonth.getItems().addAll(mh.populateMonthSelection());
        EditCustDay.getItems().addAll(dh.populateDaySelection());
        //adds genders to the gender combo box
        EditCustGender.getItems().addAll( gh.populateGender());
        //adds the ethnicities to the combo box
        EditCustEthnicity.getItems().addAll(eh.populateEthnicities());
    }

    public void onCancelEditCustomer(ActionEvent event) {
        // Closes the popup
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        //Defensively consume the event
        event.consume();
    }

    public void onSubmitCutomerEdit(ActionEvent event) {
    }
}
