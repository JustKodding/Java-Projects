package application;

//This program demonstrate Slider event handling

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javafx.scene.control.Slider;			//***
import javafx.beans.value.ChangeListener;	//***
import javafx.beans.value.ObservableValue;	//***

public class EventHandleSliderFX extends Application
{
private Slider slHorizontal, slVertical;
private Text text;
private Pane paneForText;

public void start(Stage primaryStage)
{
	//step #1: initialize each component and set up layout
  text = new Text(20, 20, "JavaFX Programming");

	//create a horizontal slider and set up its properties
  slHorizontal = new Slider();
	slHorizontal.setMin(0);			//The minimum value of the slider
	slHorizontal.setMax(100);		//The maximum value of the slider
	slHorizontal.setValue(30);		//The initial value of the slider
	slHorizontal.setShowTickLabels(true);	//labels are enabled
	slHorizontal.setShowTickMarks(true);	//marks are enabled
	slHorizontal.setMajorTickUnit(10);		//the unit distance between major tick
											//marks is set to 10
	slHorizontal.setMinorTickCount(5);		//the number of minor ticks between any
											//two major ticks is specified as 5

  slVertical = new Slider(0, 100, 50);
  slVertical.setOrientation(Orientation.VERTICAL);
  slVertical.setShowTickLabels(true);
  slVertical.setShowTickMarks(true);

  //Create a text in a pane
  paneForText = new Pane();
  paneForText.getChildren().add(text);

  //Create a border pane to hold text and sliders
  BorderPane pane = new BorderPane();
  pane.setCenter(paneForText);
  pane.setBottom(slHorizontal);
  pane.setRight(slVertical);

  //Step #3: register slider with its handler
  slHorizontal.valueProperty().addListener(new HSliderHandler());
  slVertical.valueProperty().addListener(new VSliderHandler());

  // Create a scene and place it in the stage
  Scene scene = new Scene(pane, 450, 170);
  primaryStage.setTitle("SliderDemo");
  primaryStage.setScene(scene);
  primaryStage.show();
}

//Step #2:(A)Horizontal slider handler class
private class HSliderHandler implements ChangeListener<Number>
{
	 public void changed(ObservableValue<? extends Number> ov,
              Number oldValue, Number newValue)
   {
		 //get horizontal slider's current value.
		 double xCoordinate = (slHorizontal.getValue()/slHorizontal.getMax()) * paneForText.getWidth();
		 text.setX(xCoordinate);
	 }
}

//Step #2:(B)Vertical slider handler class
private class VSliderHandler implements ChangeListener<Number>
{
	 public void changed(ObservableValue<? extends Number> ov,
              Number oldValue, Number newValue)
   {
		 //get vertical slider's current value.
		 double yCoordinate = (slVertical.getMax() - slVertical.getValue())/slVertical.getMax()
		 					  * paneForText.getHeight();
		 text.setY(yCoordinate);
	 }
}

//The main method is only needed for the IDE with limited JavaFX support.
public static void main(String[] args) {
  launch(args);
}
}