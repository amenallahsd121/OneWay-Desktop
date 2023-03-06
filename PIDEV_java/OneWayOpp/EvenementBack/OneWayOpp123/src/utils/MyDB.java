/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Meddeb sofien
 */
public class MyDB {
    String url = "jdbc:mysql://localhost:3306/onewayv";
    String username = "root";
    String password = "";

    Connection cnx;
    
    
    private static MyDB instance;   //2- Declare une variable static de type class

    private MyDB() {    // 1-Singleton Constructeur Private
        try {
            cnx = DriverManager.getConnection(url, username, password);
            System.out.println("c'est bon Connexion établie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static MyDB getInstance() {   // 3-Implemetation la getter de la variable static     
        if (instance == null) {
            instance = new MyDB();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }

    
    
    
    
    
}
