package application;

//See driver program BounceBallControlTwo.java

import javafx.animation.KeyFrame;	//**Need to import
import javafx.animation.Timeline;	//**Need to import
import javafx.util.Duration;		//**Need to import
//import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;	//**Need to import
import javafx.event.EventHandler;	//**Need to import

public class BallPaneTwo extends Pane
{
public final double radius = 15;
private double x = radius, y = radius, x2, y2;
private double dx = 1, dy = 1;
private Circle c1, c2;
private Arc arc1, arc2;
private Line aLine;
private Timeline animation;
private int currentAngle;
private int step = 5;


public BallPaneTwo()
{
	//Step #1: initialize each instance variables and set up layout
	c1 = new Circle(x, y, radius);
  c1.setStroke(Color.BLACK);
  c1.setFill(null);
	x2 = x+30;	//(x2,y2) is center coordinate of c2
	y2 = y+30;
	c2 = new Circle(x2, y2, radius);
  c2.setStroke(Color.BLACK);
  c2.setFill(null);

  //aLine links the center of the two circles
 	aLine = new Line(x, y, x2, y2);

	currentAngle = 0;
	arc1 = new Arc(x,y,radius,radius, currentAngle, 90);
	arc1.setFill(Color.GREEN);
	arc1.setType(ArcType.ROUND);

  arc2 = new Arc(x,y,radius,radius, currentAngle+180, 90);
	arc2.setFill(Color.RED);
	arc2.setType(ArcType.ROUND);

	//Add all GUI components into this pane
  getChildren().addAll(c1,c2,aLine, arc1, arc2);

  //Create a KeyFrame object first. It generate a MoveHandler event
  //in every 20 milliseconds
  KeyFrame kf = new KeyFrame(Duration.millis(20), new MoveHandler());

  //Create a Timeline from above KeyFrame
  animation = new Timeline(kf);

	//set the properties of the Timeline object
  animation.setCycleCount(Timeline.INDEFINITE);

  //start the animation
  animation.play();
}

public void increaseSpeed()
{
  animation.setRate(animation.getRate() + 0.1);
}

public void decreaseSpeed()
{
  animation.setRate(
    animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
}

//A handler class that handles the move of those GUI components
private class MoveHandler implements EventHandler<ActionEvent>
{
	 public void handle(ActionEvent event)
	 {
		 if (x < radius || (x+30) > getWidth() - radius)
  	 {
    		dx *= -1; // Change ball move direction
  	 }
  	 if (y < radius || (y+30) > getHeight() - radius)
  	 {
    		dy *= -1; // Change ball move direction
  	 }

  	 //update x, y and currentAngle value
  	currentAngle += step;
 		x += dx;
  	y += dy;

  	//re-place Circle c1's center at (x, y)
  	c1.setCenterX(x);
 		c1.setCenterY(y);

   	//re-place Circle c2's center at new position
	    c2.setCenterX(x+30);
 		c2.setCenterY(y+30);

 		//Note the line always links the centers of the two circle.
 		aLine.setStartX(c1.getCenterX());
	    aLine.setStartY(c1.getCenterY());
		aLine.setEndX(c2.getCenterX());
 		aLine.setEndY(c2.getCenterY());

 		//re-place arc1's center and starting angle
	    arc1.setCenterX(x);
	    arc1.setCenterY(y);
	    arc1.setStartAngle(currentAngle);

	    arc2.setCenterX(x);
	    arc2.setCenterY(y);
	    arc2.setStartAngle(currentAngle+180);
	 }
} //end of MoveHandler
} //end of BallPaneTwo class