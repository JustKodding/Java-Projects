package application;

import java.io.IOException;
import java.util.EventObject;

import javax.print.DocFlavor.URL;
import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SceneController {
	
	@FXML
	Button docBtn;
	
	@FXML
	Button nurseBtn;
	
	@FXML
	Button btnScene1;
	
	@FXML
	Button btnScene2;
	
	@FXML
	Button btnScene4;
	
	@FXML
	Button loginBtn;
	
	@FXML
	Button signOutBtn;
	
	@FXML
	Button newPatient;
	
	
	
	
	public void handleBtn1() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		 
		 Stage window = (Stage) btnScene1.getScene().getWindow();
		 window.setScene(new Scene(root, 750, 500));
		
	}
	
	public void handleBtn2() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		 
		 Stage window = (Stage) btnScene2.getScene().getWindow();
		 window.setScene(new Scene(root, 750, 500));
	
	}
	
	public void docHandleBtn()throws IOException
	{
		  Parent root = FXMLLoader.load(getClass().getResource("doctoLogin.fxml"));
			 Stage window = (Stage) docBtn.getScene().getWindow();
			 window.setScene(new Scene(root, 750, 500));
	
	}
	
	public void NurseHandleBtn()throws IOException
	{
		  	Parent root = FXMLLoader.load(getClass().getResource("NurseLogin.fxml"));
			 Stage window = (Stage) nurseBtn.getScene().getWindow();
			 window.setScene(new Scene(root, 750, 500));
			 
			 
	}
	
	public void NurseHandleLogin()throws IOException
	{
		  	Parent root = FXMLLoader.load(getClass().getResource("NurseAfterLogin.fxml"));
			 Stage window = (Stage) loginBtn.getScene().getWindow();
			 window.setScene(new Scene(root, 750, 500));
			 
			 
	}
	
	public void NurseHandleLogout()throws IOException
	{
		  	Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
			 Stage window = (Stage) signOutBtn.getScene().getWindow();
			 window.setScene(new Scene(root, 750, 500));
			 
	}
	
	public void newPatient()throws IOException
	{
		  	Parent root = FXMLLoader.load(getClass().getResource("NurseNewPatient.fxml"));
			 Stage window = (Stage) newPatient.getScene().getWindow();
			 window.setScene(new Scene(root, 750, 500));
	}
	
	
	
	
	

}