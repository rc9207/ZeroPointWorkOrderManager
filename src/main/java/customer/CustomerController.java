package customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import data.DataManagement;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CustomerController {

  private ObservableList<Customer> customerList;
  private CustomerToolBar customerToolBar;

  @FXML public BorderPane customerBorderPane;
  @FXML private JFXButton addCustomerButton;
  @FXML private JFXHamburger taskBarHamburger;
  @FXML private JFXDrawer taskDrawer;
  @FXML private TableView<Customer> customerTableView;
  @FXML private TableColumn<Customer, String> customerNameCol;
  @FXML private TableColumn<Customer, String> contactNameCol;
  @FXML private TableColumn<Customer, String> addressCol;
  @FXML private TableColumn<Customer, String> cityCol;
  @FXML private TableColumn<Customer, String> stateCol;
  @FXML private TableColumn<Customer, Integer> zipCodeCol;
  @FXML private TableColumn<Customer, String> phoneNumberCol;
  @FXML private TableColumn<Customer, String> cellPhoneNumberCol;

  public void setCustomerToolBar(CustomerToolBar customerToolBar) {
    this.customerToolBar = customerToolBar;
  }

  @FXML
  public void initialize() throws Exception {

    customerList = DataManagement.getCustomers();

    customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
    contactNameCol.setCellValueFactory(new PropertyValueFactory<>("contactName"));
    addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
    cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
    stateCol.setCellValueFactory(new PropertyValueFactory<>("state"));
    zipCodeCol.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
    phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    cellPhoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("cellPhoneNumber"));

    customerTableView.setItems(customerList);

    initDrawer();
  }

  @FXML
  public void initDrawer() throws IOException {

    VBox toolbar = FXMLLoader.load(getClass().getResource("/customer/customerToolBar.fxml"));

    customerBorderPane.setLeft(null);

    HamburgerBackArrowBasicTransition hamburgerTransition = new HamburgerBackArrowBasicTransition(taskBarHamburger);
    hamburgerTransition.setRate(-1);
    taskBarHamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
      hamburgerTransition.setRate(hamburgerTransition.getRate() * -1);
      hamburgerTransition.play();

      if (taskDrawer.isOpened()) {
        taskDrawer.close();
        customerBorderPane.setLeft(null);

      } else if (taskDrawer.isClosed()) {
        taskDrawer.setSidePane(toolbar);
        taskDrawer.open();
        customerBorderPane.setLeft(taskDrawer);
      }
    });
  }

  @FXML
  public void addCustomerButtonPushed() {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/customer/customerToolBar"));
    CustomerToolBar controller = loader.getController();

  }
}
