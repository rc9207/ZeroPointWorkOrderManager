package customer;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerToolBar {

  @FXML private JFXButton addCustomerButton;
  @FXML private JFXButton deleteCustomerButton;

  public void addCustomerButtonPushed(ActionEvent event) {

    try {
      Parent root = FXMLLoader.load(getClass().getResource("/customer/addCustomer.fxml"));
      Scene scene = new Scene(root);
      Stage stage = new Stage();

      stage.setScene(scene);
      stage.show();

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
