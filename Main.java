package application;
 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
 
	

	
	
 @Override
 public void start(Stage stage) {
	  try {
		 
	
	   Parent root = FXMLLoader.load(getClass().getResource("SDbank.fxml"));
	   Scene scene = new Scene(root);
	   stage.setScene(scene);
	   stage.show();
	   
	  } catch(Exception e) {
	   e.printStackTrace();
	  }
	 } 
	
	 public static void main(String[] args) throws IOException {
			
		 	launch(args);
	 }
}