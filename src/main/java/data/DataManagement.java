package data;

import customer.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataManagement {

  public static void addCustomer(String customerName, String contactName, String address, String city,
      String state, int zipCode, String phoneNumber, String cellPhoneNumber) {

    try {
      Connection connection =
          DriverManager.getConnection("jdbc:sqlite:src/main/resources/data/ZeroPointDB.db");

      if (connection != null) {
        PreparedStatement prepStatement =
            connection.prepareStatement(
                "INSERT INTO CUSTOMER"
                    + "(CUSTOMER_NAME, CONTACT_NAME, ADDRESS, CITY, STATE, ZIP_CODE, PHONE_NUMBER, "
                    + "CELL_PHONE_NUMBER) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS);

        prepStatement.setString(1, customerName);
        prepStatement.setString(2, contactName);
        prepStatement.setString(3, address);
        prepStatement.setString(4, city);
        prepStatement.setString(5, state);
        prepStatement.setInt(6, zipCode);
        prepStatement.setString(7, phoneNumber);
        prepStatement.setString(8, cellPhoneNumber);

        prepStatement.executeUpdate();
        prepStatement.close();
        connection.close();

      } else {
        throw new Exception("Could not establish connection to the database.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static ObservableList<Customer> getCustomers() {

    try {
      Connection connection =
          DriverManager.getConnection("jdbc:sqlite:src/main/resources/data/ZeroPointDB.db");

      if (connection != null) {

        PreparedStatement prepState = connection.prepareStatement("SELECT * FROM CUSTOMER",
            PreparedStatement.RETURN_GENERATED_KEYS);

        ResultSet resSet = prepState.executeQuery();

        ObservableList<Customer> customerList = getCustomerList(resSet);

        prepState.close();
        connection.close();
        return customerList;

      } else {
        throw new Exception("Could not establish connection to the database.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private static ObservableList<Customer> getCustomerList(ResultSet resSet) {

    try {
      ObservableList<Customer> customerList = FXCollections.observableArrayList();

      while (resSet.next()) {
        Customer customer = new Customer();
        customer.setCustomerName(resSet.getString("Customer_Name"));
        customer.setContactName(resSet.getString("Contact_Name"));
        customer.setAddress(resSet.getString("Address"));
        customer.setCity(resSet.getString("City"));
        customer.setState(resSet.getString("State"));
        customer.setZipCode(resSet.getInt("Zip_Code"));
        customer.setPhoneNumber(resSet.getString("Phone_Number"));
        customer.setCellPhoneNumber(resSet.getString("Cell_Phone_Number"));
        customerList.add(customer);
      }
      return customerList;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
