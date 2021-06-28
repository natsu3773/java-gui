package DAL;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDHandler extends DBM {
    public Connection conn;
     public void getALl(){
         try {
             conn = new DBM().connect();
             if(conn.isClosed()){
                 System.out.println("Goodbye moonman");
             }
             else {
                 System.out.println("Connected");
             }
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("Select * from Client");
             while (rs.next()){
                 System.out.println(rs.getString(1) + "\t" +  rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
             }
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }


     }

     public void GetCustomers(){

     }

}
