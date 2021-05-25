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

public class AddLoanController implements Initializable {
    @FXML private ComboBox AddLoanType;
    @FXML private ComboBox AddLoanStartYear;
    @FXML private ComboBox AddLoanStartMonth;
    @FXML private ComboBox AddLoanStartDay;
    @FXML private ComboBox AddLoanEndYear;
    @FXML private ComboBox AddLoanEndMonth;
    @FXML private ComboBox AddLoanEndDay;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //local instances of the loan-type and date handler concrete classes for the abstract handler classes
        LoanTypeHandler lth = new LoanTypeHandler();
        MonthHandler mh = new MonthHandler();
        DayHandler dh = new DayHandler();
        LoanStartDurationHandler lsyh = new LoanStartDurationHandler();
        LoanEndDurationHAndler ledh = new LoanEndDurationHAndler();

        //Populating the combo boxes
        AddLoanType.getItems().addAll(lth.populateLoanTypes());
        AddLoanStartYear.getItems().addAll(lsyh.populateYearSelection());
        AddLoanEndYear.getItems().addAll(ledh.populateYearSelection());
        AddLoanStartMonth.getItems().addAll(mh.populateMonthSelection());
        AddLoanEndMonth.getItems().addAll(mh.populateMonthSelection());
        AddLoanStartDay.getItems().addAll(dh.populateDaySelection());
        AddLoanEndDay.getItems().addAll(dh.populateDaySelection());
    }

    public void onSubmitAddLoan(ActionEvent event) {
    }

    public void onCancelAddLoan(ActionEvent event) {
        //Closes the popup
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        //Defensively consume the event
        event.consume();
    }

}
