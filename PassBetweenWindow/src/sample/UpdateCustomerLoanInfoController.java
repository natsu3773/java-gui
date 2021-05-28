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

public class UpdateCustomerLoanInfoController implements Initializable {
    @FXML private ComboBox EditLoanType;
    @FXML private ComboBox EditLoanStatus;
    @FXML private ComboBox EditLoanStartYear;
    @FXML private ComboBox EditLoanStartMonth;
    @FXML private ComboBox EditLoanStartDay;
    @FXML private ComboBox EditLoanEndYear;
    @FXML private ComboBox EditLoanEndMonth;
    @FXML private ComboBox EditLoanEndDay;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //local instances of the loan-type and date handler concrete classes for the abstract handler classes
        LoanTypeHandler lth = new LoanTypeHandler();
        MonthHandler mh = new MonthHandler();
        DayHandler dh = new DayHandler();
        LoanStartDurationHandler lsyh = new LoanStartDurationHandler();
        LoanEndDurationHAndler ledh = new LoanEndDurationHAndler();
        LoanStatusHandler slh = new LoanStatusHandler();
        //Populating the combo boxes
        EditLoanType.getItems().addAll(lth.populateLoanTypes());
        EditLoanStartYear.getItems().addAll(lsyh.populateYearSelection());
        EditLoanEndYear.getItems().addAll(ledh.populateYearSelection());
        EditLoanStartMonth.getItems().addAll(mh.populateMonthSelection());
        EditLoanEndMonth.getItems().addAll(mh.populateMonthSelection());
        EditLoanStartDay.getItems().addAll(dh.populateDaySelection());
        EditLoanEndDay.getItems().addAll(dh.populateDaySelection());
        EditLoanStatus.getItems().addAll(slh.populateLoanStatus());
    }

    public void onSubmitEditLoan(ActionEvent event) {
    }

    public void onCancelEditLoan(ActionEvent event) {
        // Closes the popup
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        //Defensively consume the event
        event.consume();
    }
}
