package BLL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DayHandler extends AbstractDayHandler {
    @Override
    public ObservableList populateDaySelection(){
        //collection for the combo box
       ObservableList dayitems = FXCollections.observableArrayList();
        //Adding 31 days by default may be changed to be more accurate
        for (int i = 1; i < 32; i++) {
            dayitems.add(String.valueOf(i));
        }

        return dayitems;
    }

}
