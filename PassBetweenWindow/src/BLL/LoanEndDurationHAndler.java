package BLL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class LoanEndDurationHAndler {
    public ObservableList populateYearSelection() {
        ObservableList years = FXCollections.observableArrayList();
        int YYYY=LocalDate.now().getYear();
        int Max =20;
        for (int i = YYYY; i < YYYY+Max; i++) {
            years.add(i);
        }
        return years;
    }

    public LoanEndDurationHAndler() {
    }
}
