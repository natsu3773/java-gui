package BLL;

import BLL.AbstractLoanStatusHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LoanStatusHandler extends AbstractLoanStatusHandler {
    @Override
    public ObservableList populateLoanStatus() {

            ObservableList statuses = FXCollections.observableArrayList();
            statuses.add(0,"Completed");
            statuses.add(1,"Pending Approval");
            statuses.add(2,"Approved");
            statuses.add(3,"Pending Investigation");
            statuses.add(4,"Denied");
            return statuses;
    }


    public LoanStatusHandler() {
    }
}
