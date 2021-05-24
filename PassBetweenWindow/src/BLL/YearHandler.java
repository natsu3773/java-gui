package BLL;

import BLL.AbstractYearHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class YearHandler extends AbstractYearHandler {
   public static ObservableList<String> yearitems;

      @Override
      public ObservableList populateYearSelection(){
        //collection for the combo box
        yearitems = FXCollections.observableArrayList();
        //limits the age by year to be between 18 and 60 years old.
        int start = LocalDate.now().getYear()-60;
        int end = LocalDate.now().getYear()-18;
        for (int i = end; i >= start ; i--) {
            yearitems.add(String.valueOf(i));
        }
        return yearitems;

    }

    public YearHandler() {
    }
}
