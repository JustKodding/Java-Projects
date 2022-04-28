// Assignment #: Arizona State University CSE205 #6
//         Name: Your Name
//    StudentID: Your ID
//      Lecture: Your lecture time (e.g., MWF 8:35am)
//  Description: InputPane generates a pane where a user can enter
//  a new order information and create a list of available Orders.
//  //---- is where you need to add your own codes
package application;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

//import all other necessary javafx classes here
//----

public class InputPane extends HBox
{
	//components
	ArrayList < Order > orderList;

	//The relationship between InputPane and HandlePane is Aggregation
	private HandlePane handlePane;

	//declare other necessary GUI components and variables here
	//----
private TextField txtf1,txtf2,txtf3,txtf4;
private Label orderstatus;
TextArea textArea;
 Button PlaceOrder;	
//constructor
	public InputPane(ArrayList < Order > list, HandlePane pane)
	{
		this.orderList = list;
		this.handlePane = pane;

		//initialize each instance variable (textfields, labels, textarea, button, etc.)
		//and set up the layout
		//----
	orderstatus = new Label("");
	orderstatus.setTextFill(Color.RED);
		Label label1 = new Label("PROD Name");
		label1.setMinWidth(10);
		txtf1 = new TextField();
		
		Label label2 = new Label("Quantity");
		label2.setMinWidth(10);
		txtf2 = new TextField();
		
		Label label3 = new Label("Price($)");
		label3.setMinWidth(10);
		txtf3 = new TextField();
		
		Button PlaceOrder = new Button();
		PlaceOrder.setText("Place Order");
		PlaceOrder.setMinWidth(100);

		//create a GridPane hold the labels & text fields.
		//you can choose to use setPadding() or setHgap(), setVgap()
		//to control the spacing and gap, etc.
		//----
GridPane leftPane = new GridPane();
leftPane.setVgap(10);
leftPane.setHgap(5);
		//You might need to create a sub pane to hold the button
		//----

		//Set up the layout for the left half of the InputPane
		//----
leftPane.add(orderstatus, 0, 0);
leftPane.add(label1,0,1);
leftPane.add(txtf1, 1, 1);
leftPane.add(label2,0,2);
leftPane.add(label3, 0, 3);
leftPane.add(txtf2, 1, 2);
leftPane.add(txtf3, 1, 3);
leftPane.add(PlaceOrder, 1, 5);		
//the right half of the InputPane is simply a TextArea object
		//Note: a ScrollPane will be added automatically when there are no
		//enough space
		//----
TextArea textArea = new TextArea();
textArea.setEditable(false);
leftPane.setAlignment(Pos.TOP_CENTER);
leftPane.setPrefWidth(500);
		//Add the left half and right half to the InputPane
		//Note: InputPane extends from HBox
		//----
setSpacing(10);
		//register source object with event handler
		//----
this.getChildren().add(leftPane);
this.getChildren().add(textArea);
	PlaceOrder.setOnAction(aHandler);
	} //end of constructor

	//Step 2: Create a ButtonHandler class
	//ButtonHandler listen to see if the button "Place an order" is pushed or not,
	//When the event occurs, it get an order's product name, quantiy, unit price
	//from the relevant text fields, then create a new Order object and add it inside
	//the orderList. Meanwhile it will display the order's total cost and other info. inside the text area.
	//It also does error checking in case any of the textfields are empty
	
ButtonHandler aHandler = new ButtonHandler();
public void refresh()
{
	StringBuilder sb = new StringBuilder();
	for(Order o :orderList)
	{
		sb.append("ProductName");
		sb.append(o.getProductName());
		sb.append("");
		sb.append(o.getQuantity());
		sb.append("");
		sb.append(o.getUnitPrice());
	sb.append("");
	sb.append(o.getTotalCost());
	}
textArea.setText(sb.toString());
}
   
	private class ButtonHandler implements EventHandler < ActionEvent >
	{
		
		//Override the abstact method handle()
		public void handle(ActionEvent e)
		{
			//declare any necessary local variables here
			//---

			//when one text field is empty and the button is pushed
			//display msg "Please fill all fields"
		if (txtf1.getText().length()==0 || txtf2.getText().length()==0||txtf3.getText().length()==0 )
			{
				//handle the case here
			orderstatus.setText("Please fill all fields");
			}
			else
			{ 
				//when a non-numeric value was entered for quantity or price
				//and the button is pushed
				//you will need to use try & catch block to catch
				//the NumberFormatException
				//----

				//When a duplicated order was attempted to be added, do not
				//add it to the list. Instead displaying msg "Order not added - duplicate"
				//----

				//When everything is correct, create a new Order object and
				//add it inside orderList
				//----

				//Next, don't forget to update the new arrayList information
				//on the ListView of the handlePane
				
			try {
				String name = txtf1.getText();
				int quantity =Integer.parseInt(txtf2.getText());
			int price = Integer.parseInt(txtf3.getText());
				Order ord = new Order();	
			 ord.setProductName(name);
			  ord.setModel(quantity);
			 ord.setUnitPrice(price);
			 ord.setTotalCost();
			orderList.add(ord);
			handlePane.updateOrderList(ord);
			refresh();
			txtf1.setText("");
			txtf2.setText("");
			txtf3.setText("");
			;
			orderstatus.setText("Product Added");
			
			}catch(NumberFormatException e1){
				orderstatus.setText("Invalid input");
			
			}}
		} //end of handle() method
	} //end of ButtonHandler class
}