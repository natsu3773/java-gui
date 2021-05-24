package sample;
import BLL.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomerInfoController implements Initializable {
    @FXML private ComboBox AddCustYear;
    @FXML private ComboBox AddCustMonth;
    @FXML private ComboBox AddCustDay;
    @FXML private ComboBox AddCustGender;
    @FXML private ComboBox AddCustEthnicity;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //local instances of the concrete gender ethnicity date handler abstract classes.
        YearHandler dates = new YearHandler();
        MonthHandler mh = new MonthHandler();
        DayHandler dh = new DayHandler();
        GenderHandler gh = new GenderHandler();
        EthnicityHandler eh = new EthnicityHandler();
        //adds year month and day items to the combo boxes.
        AddCustYear.getItems().addAll(dates.populateYearSelection());
        AddCustMonth.getItems().addAll(mh.populateMonthSelection());
        AddCustDay.getItems().addAll(dh.populateDaySelection());
        //adds genders to the gender combo box
        AddCustGender.getItems().addAll( gh.populateGender());
        //adds the ethnicities to the combo box
        AddCustEthnicity.getItems().addAll(eh.populateEthnicities());
    }

}
