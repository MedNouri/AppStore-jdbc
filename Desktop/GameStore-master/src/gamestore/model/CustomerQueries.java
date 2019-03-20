// The PreparedStatements that are used in the GameSpot application.
package gamestore.model;

import gamestore.Connexion;
import gamestore.DAO.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerQueries implements DAO<Customer> {

    
    private Connection connection; // manages the connection
    private PreparedStatement selectCustomerByUserName;
    private PreparedStatement selectCustomerByPassword;
    private PreparedStatement insertNewCustomer;
    private PreparedStatement getAllUSers;
    private PreparedStatement deleteCustomer;
    private PreparedStatement updateCustomer;
    // Constructor
    public CustomerQueries() {
        try {
            connection = Connexion.getInstance().getConnection();
            
            // creates the query for the records of Customer table with specific UserName
            selectCustomerByUserName = connection.prepareStatement("SELECT * FROM customers WHERE UserName = ?");
            
            // creates the query for the records of Customer table with specific Password
            selectCustomerByPassword = connection.prepareStatement("SELECT * FROM customers WHERE Password = ?");
            
            //creates the query for inserting an new record in the Customer table
            insertNewCustomer = connection.prepareStatement("INSERT INTO customers " + " (UserName, Password, Email, CCNumber) " + "VALUES (?, ?, ?, ?)");

            // creates the query for the records of Customer table with specific UserName
            getAllUSers = connection.prepareStatement("SELECT * FROM customers ");

            // creates the query for the records of Customer table with specific UserName
            deleteCustomer = connection.prepareStatement("DELETE  FROM customers WHERE  customerID = ?");


            updateCustomer  = connection.prepareStatement("SELECT * FROM customers WHERE CustomerID = ? ");

            // updat the user account
            


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }
    
    //Selects Customer with UserName for Login Form
    public List<Customer> getCustomerByUserName(String userName) {
        List<Customer> results = null;
        ResultSet resultSet = null;
        
        try {
            selectCustomerByUserName.setString(1, userName);
            
            // executeQuery returns a ResultSet that contains the desired records
            resultSet = selectCustomerByUserName.executeQuery();
            
            results = new ArrayList<Customer>();
            
            while(resultSet.next()) {
                results.add(new Customer(
                        resultSet.getInt("customerID"),
                        resultSet.getString("userName"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("ccNumber"),
                        resultSet.getDouble("balance")));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        
        return results;
    }
    //Selects Customer with UserName for Login Form
    public Customer getCustomerByUserID(int  USerid) {
         Customer customer = null;
        ResultSet resultSet = null;

        try {
            updateCustomer.setInt(1, USerid);

            // executeQuery returns a ResultSet that contains the desired records
            resultSet = updateCustomer.executeQuery();



            if (resultSet.first()) {
              return   new Customer(
                        resultSet.getInt("customerID"),
                        resultSet.getString("userName"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("ccNumber"),
                        resultSet.getDouble("balance"));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return customer;
    }
    // Selects Customer with Password for Login Form
    public List<Customer> getCustomerByPassword(String password) {
        List<Customer> results = null;
        ResultSet resultSet = null;
        
        try {
            selectCustomerByPassword.setString(1, password);
            
            // executeQuery returns a ResultSet that contains the desired records
            resultSet = selectCustomerByPassword.executeQuery();
            
            results = new ArrayList<Customer>();
            
            while (resultSet.next()) {
                results.add(new Customer(resultSet.getInt("customerID"),
                        resultSet.getString("userName"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("ccNumber"),
                        resultSet.getDouble("balance"))
                );
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        
        return results;
    }


    // Selects Customer with Password for Login Form
    public List<Customer> getAllCustomers() {
        List<Customer> results = null;
        ResultSet resultSet = null;

        try {

            // executeQuery returns a ResultSet that contains the desired records
            resultSet = getAllUSers.executeQuery();

            results = new ArrayList<Customer>();

            while (resultSet.next()) {
                results.add(new Customer(resultSet.getInt("customerID"),
                        resultSet.getString("userName"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("ccNumber"),
                        resultSet.getDouble("balance"))
                );
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }

        return results;
    }

    // Insert new Customer for Register Form
    public int addCustomer(String userName, String password, String email, String ccNumber) {
        int result = 0;
        
        // defines parameters and then runs insertNewCustomer
        try {
            insertNewCustomer.setString(1, userName);
            insertNewCustomer.setString(2, password);
            insertNewCustomer.setString(3, email);
            insertNewCustomer.setString(4, ccNumber);
            
            // inserts the new record and returns the number of the lines that update
            result = insertNewCustomer.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }
        
        return result;
    }


    // Insert new Customer for Register Form
    @Override
    public int delete(int CustomerID) {
        int result = 0;

        // defines parameters and then runs insertNewCustomer
        try {
            deleteCustomer.setInt(1, CustomerID);


            // inserts the new record and returns the number of the lines that update
            result = deleteCustomer.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }

        return result;
    }


    // close database connection
    public void close() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public boolean create(Customer obj) {
        return false;
    }





    @Override
    public boolean update(Customer obj) {
        return false;
    }

    @Override
    public Customer find(int id) {
        return null;
    }
}
