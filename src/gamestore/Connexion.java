package gamestore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Deny Prasetyo
 */
public class Connexion {

    private static Connexion instance;
    private Connection connection;
    private static final String DATABASE_URL = "jdbc:mysql://localhost/gamestore_fx_db";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "FOSRoKl6pJ7VZ6ay";

    private Connexion() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        }catch (SQLException e){
            System.out.print(e);
        }finally {
            if (this.connection != null){
                //   this.connection.close();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connexion getInstance() throws SQLException {
        if (instance == null) {
            instance = new Connexion();
        } else if (instance.getConnection().isClosed()) {
            instance = new Connexion();
        }

        return instance;
    }
}