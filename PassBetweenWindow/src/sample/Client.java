package sample;

import javafx.beans.property.SimpleStringProperty;

public class Client {
    private final SimpleStringProperty ClientID = new SimpleStringProperty("");
    private final SimpleStringProperty ClientFName = new SimpleStringProperty("");
    private final SimpleStringProperty ClientLName = new SimpleStringProperty("");


    public String getClientID() {
        return ClientID.get();
    }

    public void setClientID(String clientID) {
         ClientID.set(clientID);
    }

    public String getClientFName() {
        return ClientFName.get();
    }

    public void setClientFName(String clientFName) {
        ClientFName.set(clientFName);
    }

    public String getClientLName() {
        return ClientLName.get();
    }

    public void setClientLName(String clientLName) {
        ClientLName.set(clientLName);
    }

    public Client(String clientID, String clientFName, String clientLName) {
        setClientID(clientID);
        setClientFName(clientFName);
        setClientLName(clientLName);
    }
}
