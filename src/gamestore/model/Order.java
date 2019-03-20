package gamestore.model;

public class Order {

    private int OrderID;
    private int Quantity;
    private int ProductID;
    private int CustomerID;

    public Order(int orderID, int quantity, int productID, int customerID) {
        OrderID = orderID;
        Quantity = quantity;
        ProductID = productID;
        CustomerID = customerID;
    }

    // Default constructor
    public Order(){}


    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }
}
