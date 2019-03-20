package gamestore;

import gamestore.model.Customer;
import gamestore.model.CustomerQueries;
import gamestore.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class AllUsersController {
    private Alert.AlertType type = Alert.AlertType.INFORMATION;
    private Stage stage;
    public Hyperlink checkoutCartButton;
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    private List<Customer> results;
    private ObservableList<Customer> customers = FXCollections.observableArrayList();


    @FXML TableView<Customer> allusertabel;
    @FXML private TableColumn<Customer, String> checkoutTitleCol;
    @FXML private TableColumn<Customer, String> checkoutPriceCol;
    @FXML private TableColumn<Customer, String> Quantity;
    @FXML private TableColumn<Customer, Double> total;

    public void initialize() {
        System.out.println("i can start hehe ");

        CustomerQueries customerQueries = new CustomerQueries();

        results =  customerQueries.getAllCustomers();
        //numberOfEntries = results.size();

        customers.addAll(results);

        System.out.println(customers);

        checkoutTitleCol.setCellValueFactory(new PropertyValueFactory<>("User Name "));
        checkoutPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


        checkoutTitleCol.setCellValueFactory(
                new PropertyValueFactory<>("userName"));

        checkoutPriceCol.setCellValueFactory(
                new PropertyValueFactory<>("email"));
        Quantity.setCellValueFactory(
                new PropertyValueFactory<>("userName"));

        total.setCellValueFactory(
                new PropertyValueFactory<>("userName"));


        allusertabel.setItems(customers);





    }




}
