package BLL;

import BLL.AbstractMonthHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MonthHandler extends AbstractMonthHandler {
    @Override
    public ObservableList populateMonthSelection(){
        //collection for the combo box
       ObservableList monthitems = FXCollections.observableArrayList();
        //limits the month to be between 1 and 12 for January to December respectively.
        for (int i = 1; i <13; i++) {
            monthitems.add(String.valueOf(i));
        }
        return monthitems;
    }
}
