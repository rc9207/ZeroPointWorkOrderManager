package customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import data.DataManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AddCustomer {

  @FXML private JFXButton saveCustomerButton;
  @FXML private JFXTextField customerNameField;
  @FXML private JFXTextField contactNameField;
  @FXML private JFXTextField addressField;
  @FXML private JFXTextField cityField;
  @FXML private JFXTextField stateField;
  @FXML private JFXTextField zipCodeField;
  @FXML private JFXTextField phoneNumberField;
  @FXML private JFXTextField cellPhoneNumberField;

  public void saveCustomerButtonPushed(ActionEvent event) {

    String customerName = customerNameField.getText();
    String contactName = contactNameField.getText();
    String address = addressField.getText();
    String city = cityField.getText();
    String state = stateField.getText();
    int zipCode = Integer.parseInt(zipCodeField.getText());
    String phoneNumber = phoneNumberField.getText();
    String cellPhoneNumber = cellPhoneNumberField.getText();

    DataManagement.addCustomer(customerName, contactName, address, city, state, zipCode,
        phoneNumber, cellPhoneNumber);

    Stage stage = (Stage) saveCustomerButton.getScene().getWindow();
    stage.close();
  }

}
