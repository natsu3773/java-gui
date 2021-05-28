package BLL;

import BLL.AbstractLoanTypeHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LoanTypeHandler extends AbstractLoanTypeHandler {
    @Override
    public ObservableList populateLoanTypes() {
        ObservableList loanTypes = FXCollections.observableArrayList();
        loanTypes.add(0,"Vehicle");
        loanTypes.add(1,"Home");
        loanTypes.add(2,"Personal");

        return loanTypes;
    }

    public LoanTypeHandler() {
    }
}
