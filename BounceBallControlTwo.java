package application;

//This program demonstrates two circles (with two Arcs) linked
//by a Line move together.
//see BallPaneTwo.java

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class BounceBallControlTwo extends Application
{
public void start(Stage primaryStage)
{
  BallPaneTwo ballPane = new BallPaneTwo(); // Create a ball pane

  // Increase and decrease animation by Up & Down arrow key
  // Note: here the event handled by lambda notation
  ballPane.setOnKeyPressed(e ->
  {
    if (e.getCode() == KeyCode.UP)
    {
      ballPane.increaseSpeed();
    }
    else if (e.getCode() == KeyCode.DOWN)
    {
      ballPane.decreaseSpeed();
    }
  });

  // Create a scene and place it in the stage
  Scene scene = new Scene(ballPane, 250, 200);
  primaryStage.setTitle("Two Bounce Balls");
  primaryStage.setScene(scene);
  primaryStage.show();

  // Must request focus after the primary stage is displayed
  ballPane.requestFocus();
}

//The main method is only needed for the IDE with limited JavaFX support
public static void main(String[] args)
{
  launch(args);
}
}