package application;

//This program demonstrate a bouncing one ball
//see driver program: OneBounceBallControl.java

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OneBounceBall extends Pane
{
public final double radius = 20;
private double x = radius, y = radius;
private double dx = 1, dy = 1;
private Circle c1;
private Timeline animation;

public OneBounceBall()
{
	  c1 = new Circle(x,y,radius);
	  c1.setStroke(Color.BLACK);
	  c1.setFill(Color.BLUE);

	  this.getChildren().add(c1); // Place the ball into the pane

  //#1)First create a KeyFrame that runs the relevant ActionEvent in every 20 milliseconds
  KeyFrame kf = new KeyFrame(Duration.millis(20), new MoveHandler());

  //#2)Then create an animation that play the KeyFrame.
  animation = new Timeline(kf);

  //#3)Set the properties of the animation. Here we let the animation
  //to run indefinitely
  animation.setCycleCount(Timeline.INDEFINITE);

  //#4)Start the animation
  animation.play();
}

private class MoveHandler implements EventHandler<ActionEvent>
{
	 public void handle(ActionEvent event)
	 {
		 if (x < radius || x > getWidth() - radius)
 		 {
    		dx *= -1; // Change ball move x-direction
  	 }

  	 if (y < radius || y > getHeight() - radius)
  	 {
    		dy *= -1; // Change ball move y-direction
  	 }

  	// Adjust ball position
	    x += dx;
  	y += dy;
  	c1.setCenterX(x);
  	c1.setCenterY(y);
	}
} //end MoveHandler class
}