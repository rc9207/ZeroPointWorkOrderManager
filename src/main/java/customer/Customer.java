package customer;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {

  private StringProperty customerName;
  private StringProperty contactName;
  private StringProperty address;
  private StringProperty city;
  private StringProperty state;
  private IntegerProperty zipCode;
  private StringProperty phoneNumber;
  private StringProperty cellPhoneNumber;

  public Customer() {
    this.customerName = new SimpleStringProperty();
    this.contactName = new SimpleStringProperty();
    this.address = new SimpleStringProperty();
    this.city = new SimpleStringProperty();
    this.state = new SimpleStringProperty();
    this.zipCode = new SimpleIntegerProperty();
    this.phoneNumber = new SimpleStringProperty();
    this.cellPhoneNumber = new SimpleStringProperty();
  }

  public void setCustomerName(String customerName) {
    this.customerName.set(customerName);
  }

  public String getCustomerName() {
    return customerName.get();
  }

  public void setContactName(String contactName) {
    this.contactName.set(contactName);
  }

  public String getContactName() {
    return contactName.get();
  }

  public void setAddress(String address) {
    this.address.set(address);
  }

  public String getAddress() {
    return address.get();
  }

  public void setCity(String city) {
    this.city.set(city);
  }

  public String getCity() {
    return city.get();
  }

  public void setState(String state) {
    this.state.set(state);
  }

  public String getState() {
    return state.get();
  }

  public void setZipCode(int zipCode) {
    this.zipCode.set(zipCode);
  }

  public int getZipCode() {
    return zipCode.get();
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber.set(phoneNumber);
  }

  public String getPhoneNumber() {
    return phoneNumber.get();
  }

  public void setCellPhoneNumber(String cellPhoneNumber) {
    this.cellPhoneNumber.set(cellPhoneNumber);
  }

  public String getCellPhoneNumber() {
    return cellPhoneNumber.get();
  }

  public void customerToString() {
    System.out.println("Customer Name: " + customerName + "\n");
    System.out.println("Contact Name: " + contactName + "\n");
    System.out.println("Address: " + address + "\n");
    System.out.println("City: " + city + "\n");
    System.out.println("State: " + state + "\n");
    System.out.println("Zip Code: " + zipCode + "\n");
    System.out.println("Phone Number: " + phoneNumber + "\n");
    System.out.println("Cell Phone Number: " + cellPhoneNumber + "\n");
  }
}
