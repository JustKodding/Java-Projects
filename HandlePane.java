package application;

//Assignment #: Arizona State University CSE205 #6
//Name: Your Name
//StudentID: Your ID
//Lecture: Your lecture time (e.g., MWF 8:35am)
//Description: HandlePane displays a list of available new Orders
//and cancelled order. It also shows their total amounts

import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.layout.HBox;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import

import java.util.ArrayList;
import java.text.DecimalFormat;

//import all other necessary javafx classes here
//----

public class HandlePane extends HBox
{
//One for the new Order list, one for the cancelled list
private ArrayList < Order > orderedList, cancelledList;
private ListView < Order > orderedLV, cancelledLV;

//declare other necessary GUI components and variables here
//----

DecimalFormat fmt1 = new DecimalFormat("##,###.00");

//Constructor
public HandlePane(ArrayList < Order > list)
{
this.orderedList = list;
orderedLV = new ListView<Order>();
//The right hand side cancelled list is empty at beginnig
cancelledList = new ArrayList < Order > ();
orderedLV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

//initialize other GUI components and set up the layout here
//----

//Create the two ListView objects. The left one is for new order
//and the right one is for cancelled order. Study our sample codes
//to learn how
//----
for(Order ord: orderedList)
{
	orderedLV.getItems().add(ord);
}
//set up the layout of the left pane, leftPane contains label, ListView
//for new orders and total ordered amounts.
//----

//set up the layout of the right pane, rightPane contains label, ListView
//for cancelled orders and total cancelled amounts.
//----

//create a vertical TitlePane that hold the two buttons, set up the layout
//----

//HandlePane is a HBox, add sub components inside HandlePane
//----

//Step #3: Register the button with its handler class
//----

} //end of constructor

//This method refresh the new order ListView whenever there's new Order added
//in InputPane. It will (1)update the underline ObservableList object; (2)
//update the total ordered amount.
public  void updateOrderList(Order newOrder)
{
orderedLV.getItems().add(newOrder);
}

//Step #2: Create a ButtonHandler class
private class ButtonHandler2 implements EventHandler < ActionEvent >
{
//Override the abstact method handle()
public void handle(ActionEvent e)
{
	//----
}
} //end of ButtonHandler class
} //end of HandlePane class