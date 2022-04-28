package application;

//See also OneBounceBall.java

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class OneBounceBallControl extends Application
{
public void start(Stage primaryStage)
{
  OneBounceBall ballPane = new OneBounceBall(); // Create a ball pane

  // Create a scene and place it in the stage
  Scene scene = new Scene(ballPane, 250, 200);
  primaryStage.setTitle("One Bounce Ball"); // Set the stage title
  primaryStage.setScene(scene); // Place the scene in the stage
  primaryStage.show(); // Display the stage

  // Must request focus after the primary stage is displayed
  ballPane.requestFocus();
}

//The main method is only needed for the IDE with limited JavaFX support
public static void main(String[] args)
{
  launch(args);
}
}
