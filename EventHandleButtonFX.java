//This program demonstate event handling with a Button
package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;	//**Need to import
import javafx.event.EventHandler;	//**Need to import

public class EventHandleButtonFX extends Application
{
  //define GUI components
  int pushes;
  Label label;
  Button push;

  public void start(Stage primaryStage)
  {
	  //Step 1: create & initialize the relevant GUI components
   	  pushes = 0;
      label = new Label("Pushes: " + pushes);
      push = new Button("Push Me!");

	 //set up the layout & its properties - use HBox
	 HBox pane = new HBox();
	 pane.setSpacing(20);
     pane.setPadding(new Insets(20, 12, 12, 20));

     //add label & button inside the pane
     pane.getChildren().addAll(label, push);

     //Step 3: Register the button with a ButtonHandler object
     ButtonHandler aHandler = new ButtonHandler();
     push.setOnAction(aHandler);

     // Create a scene and place it in the stage
     Scene scene = new Scene(pane, 200, 100);
     primaryStage.setTitle("Button Event Demo");
     primaryStage.setScene(scene); // Place the scene in the stage
     primaryStage.show(); // Display the stage
 } //end start()

    //Step 2: Create a handler class that handle button event.
	//This class should implements the relevant interface
	private class ButtonHandler implements EventHandler<ActionEvent>
	{
	    //Override the abstact method handle()
	    public void handle(ActionEvent e)
	    {
	       //It updates the counter when the button is pushed.
	       pushes++;
	       label.setText("Pushes: " + pushes);
	    }
  
	}//end of ButtonHandler

}//end EventHandleButtonFX