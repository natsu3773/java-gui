package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBM {
    public static final String URL = "jdbc:ucanaccess://TestDB.accdb";
   public Connection connection;

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

}
