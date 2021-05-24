package BLL;

import BLL.AbstractEthnicityHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EthnicityHandler extends AbstractEthnicityHandler {
    @Override
    public ObservableList populateEthnicities() {
        ObservableList ethnicities = FXCollections.observableArrayList();
        ethnicities.add(0,"Black");
        ethnicities.add(1,"White");
        ethnicities.add(2,"Asian");
        ethnicities.add(3,"Mixed");
        ethnicities.add(4,"Private");
        return ethnicities;
    }

    public EthnicityHandler() {
    }
}
