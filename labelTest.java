package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class labelTest extends Application
{
     public void start(Stage stage)
     {
          TextField tf = new TextField("ABC");
          Label label = new Label("xyz");
          tf.setText("123" + label.getText());
          VBox pane = new VBox();
          pane.getChildren().addAll(tf, label);

          Scene scene = new Scene(pane, 180, 100);
          stage.setTitle("LabelText");
          stage.setScene(scene);
          stage.show();
     }
}