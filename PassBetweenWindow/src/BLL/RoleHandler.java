package BLL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoleHandler extends AbstractRoleHandler {

    @Override
    public ObservableList populateRoles() {
        ObservableList roles = FXCollections.observableArrayList();
        for (AccessTypes a:AccessTypes.values()) {
            roles.add(a);
        }
        return roles;
    }
}
