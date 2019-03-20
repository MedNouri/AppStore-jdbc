package gamestore.model;

import gamestore.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderQueries {



    private Connection connection; // manages the connection

    private PreparedStatement geAllPuRCHASED;

    // Constructor
    public OrderQueries() {
        try {
            connection = Connexion.getInstance().getConnection();

           geAllPuRCHASED = connection.prepareStatement( "SELECT Title, Cover, ExeFile FROM products INNER JOIN orders ON products.`ProductID` = orders.`ProductID` AND orders.`CustomerID` = ? ");


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    public ResultSet getAllPUrchased(int customerID) {

        ResultSet resultSet = null;

        try {
            geAllPuRCHASED.setInt(1, customerID);

            // executeQuery returns a ResultSet with all the desired records
            resultSet = geAllPuRCHASED.executeQuery();


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }

        return resultSet;
    }
    // close database connection
    public void close() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
