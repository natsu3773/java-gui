package BLL;

import BLL.AbstractGenderHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GenderHandler extends AbstractGenderHandler {
    @Override
    public ObservableList populateGender() {
        ObservableList genders = FXCollections.observableArrayList();
        genders.add(0,"Male");
        genders.add(1,"Female");
        genders.add(2,"Other");
        genders.add(3,"Private");
        return genders;
    }

    public GenderHandler() {
    }
}
