
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDB {
    String url = "jdbc:mysql://localhost:3306/oneway";
    String username = "root";
    String password ="";
    Connection cnx;
    private static MyDB instance;
    public MyDB() {
        try {
            this.cnx = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected");
        } catch (SQLException ex) {
           // Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }


    public static MyDB getInstance() {
        if(instance == null){
            instance = new MyDB();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
