package bin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  public static Stage primaryStage;

  @Override
  public void start(Stage primaryStage) throws Exception {

    this.primaryStage = primaryStage;
    Parent root = FXMLLoader.load(getClass().getResource("/customer/customer.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setMaximized(true);
    primaryStage.show();
    primaryStage.setResizable(true);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
