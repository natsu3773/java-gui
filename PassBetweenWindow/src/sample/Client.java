package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableArray;

public class Client {
    private SimpleIntegerProperty CustID;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty midName;
    private SimpleStringProperty DOB;
    private SimpleStringProperty Ethnicity;
    private SimpleStringProperty Nationality;


    public int getCustID() {
        return this.CustID.get();
    }

    public void setCustID(SimpleIntegerProperty custID) {
        CustID = custID;
    }

    public SimpleStringProperty getFirstName() {
        return firstName;
    }

    public void setFirstName(SimpleStringProperty firstName) {
        this.firstName = firstName;
    }

    public SimpleStringProperty getLastName() {
        return lastName;
    }

    public void setLastName(SimpleStringProperty lastName) {
        this.lastName = lastName;
    }

    public SimpleStringProperty getMidName() {
        return midName;
    }

    public void setMidName(SimpleStringProperty midName) {
        this.midName = midName;
    }

    public SimpleStringProperty getDOB() {
        return DOB;
    }

    public void setDOB(SimpleStringProperty DOB) {
        this.DOB = DOB;
    }

    public SimpleStringProperty getEthnicity() {
        return Ethnicity;
    }

    public void setEthnicity(SimpleStringProperty ethnicity) {
        Ethnicity = ethnicity;
    }

    public SimpleStringProperty getNationality() {
        return Nationality;
    }

    public void setNationality(SimpleStringProperty nationality) {
        Nationality = nationality;
    }
}
