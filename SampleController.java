package application;
import javafx.fxml.FXMLLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;  
import javafx.event.ActionEvent;

public class SampleController {
	@FXML Button SaveBtn;
	@FXML Button CancelBtn;
	@FXML TextField FirstNameF;
	@FXML TextField LastNameF;
	@FXML TextField PhoneNumberF;
	@FXML TextField CustomerIDF;
	@FXML TextField AddressF;
	@FXML TextField CheckingNumberF;
	@FXML TextField SavingNumberF;	


	public void saveCustomer(ActionEvent event)throws IOException
	{
		SaveBtn.setOnAction(e -> {
			
			String FirstName = FirstNameF.getText();
			String lastName = LastNameF.getText();
			String PhoneNumber = PhoneNumberF.getText();
			String ID = CustomerIDF.getText();
			String Address = AddressF.getText();
			String SavingNum = SavingNumberF.getText();
			String Checking = CheckingNumberF.getText();
	
	         try {
	        	 FileWriter myObj = new FileWriter("Customer.txt", true);
	             myObj.write("Name:" + FirstName +  " " + lastName + "\n" +"Phone Number: " + PhoneNumber +  "\n"+"Customer ID: " + ID +  "\n"+"Address: " + Address  + "\n"+"Saving Account Number: " + SavingNum + "\n"+"Checkings Account Number: " + Checking +  "\n");
	             myObj.close();
	        
	   
	             System.out.println("Successfully wrote to the file.");
	             
	           } catch (IOException e1) {
	             System.out.println("An error occurred.");
	             e1.printStackTrace();
	           }        
		});
	
	
	
	}

	public void cancelCustomer(ActionEvent event)throws IOException
	{
		CancelBtn.setOnAction(e -> {
			
		FirstNameF.setText("");
		LastNameF.setText("");
		PhoneNumberF.setText("");
			CustomerIDF.setText("");
			 AddressF.setText("");
			 SavingNumberF.setText("");
			CheckingNumberF.setText("");
	
	         
		});

}}
