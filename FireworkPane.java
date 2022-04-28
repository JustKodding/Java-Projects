package application;



//Assignment #: Arizona State University CSE205 #12
//Name: Justin Carter
//StudentID: 1216733401
//Lecture: MWF 9:40am)
//Description: The FireworkPane with Timeline that create each individual Firework
//    that with different beam number, color and animation speed.

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class FireworkPane extends Pane
{
private double centerX, centerY, radius, radiusLimit, angleSize, step;
private Timeline timeline1;
private int beamNum;
private Color color;

public FireworkPane(Color color, int width)
{
this.color = color;
centerX = width/2;
centerY = centerX;
radiusLimit = (width-10)/(4.0);
radius = 25.0;
beamNum = 8;
angleSize = 360/(beamNum*2);
step = 2.0;
this.setStyle("-fx-background-color: black");

for (int currentAngle=0; currentAngle <= 360; currentAngle += 2*angleSize)
{
Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);
arc1.setFill(color);
arc1.setStroke(color);
arc1.setType(ArcType.ROUND);
this.getChildren().add(arc1);
}


//#3)Set the properties of the animation. Here we let the animation
//to run indefinitely


//#4)Start the animation

//Create a KeyFrame object with initial duration set to be 500ms and the relevant
//FireworkHandler object

KeyFrame kf = new KeyFrame(Duration.millis(500), new FireworkHandler());
//Initialize Timeline object timeline1 here, set its cycle count and initial
//rate to be 20, then
/***to be completed***/
timeline1 = new Timeline(kf);
timeline1.setCycleCount(Timeline.INDEFINITE);
timeline1.setRate(20);
timeline1.play();

class FireworkHandler implements EventHandler<ActionEvent>
{

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
}
//resumes animation
public void resume()
{
	  timeline1.play();
}
//stops animation
public void suspend()
{
	timeline1.pause();
}
//changes color
public void changeColor(Color anotherColor)
{
color = anotherColor;
}
//sets beam Number
public void setBeamNumber(int beam)
{
beamNum = beam;
angleSize = 360.0/(beamNum*2);
}

public void setRate(int rate1)
{

}

private class FireworkHandler implements EventHandler<ActionEvent>
{
public void handle(ActionEvent event)
{
getChildren().clear();

angleSize = 360/(beamNum*2);
for (int currentAngle=0; currentAngle <= 360; currentAngle += 2*angleSize)
{
 Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);
 arc1.setFill(color);
 arc1.setStroke(color);
 arc1.setType(ArcType.ROUND);
 getChildren().add(arc1);
}
radius += step;
if (radius>=radiusLimit)
{
 radius = 0;
}
}
}
}