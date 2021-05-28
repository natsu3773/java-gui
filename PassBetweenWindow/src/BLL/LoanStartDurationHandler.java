package BLL;

import BLL.AbstractYearHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class LoanStartDurationHandler extends AbstractYearHandler {

    @Override
    public ObservableList populateYearSelection() {
        ObservableList years = FXCollections.observableArrayList();
        int YYYY=LocalDate.now().getYear();
        int Max =1;
        for (int i = YYYY; i < YYYY+Max; i++) {
            years.add(i);
        }
        return years;

    }
}
