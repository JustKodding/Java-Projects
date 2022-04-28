package application;

//Assignment #: Arizona State University CSE205 #6
//Name: Justin Carter
//StudentID: 1216733401
//Lecture: MWF 9:30
//Description: The Assignment6 class creates a Tabbed Pane with
//    two tabs, one for Order input and one for
//    Order handling.

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class Assignment6 extends Application
{
private TabPane tabPane;
private InputPane inputPane;
private HandlePane handlePane;
private ArrayList < Order > orderList;

public void start(Stage stage)
{
StackPane root = new StackPane();

//orderList to be used in both InputPane & HandlePane
orderList = new ArrayList < Order > ();

handlePane = new HandlePane(orderList);
inputPane = new InputPane(orderList, handlePane);

tabPane = new TabPane();

Tab tab1 = new Tab();
tab1.setText("Order Input");
tab1.setContent(inputPane);

Tab tab2 = new Tab();
tab2.setText("Order Handle");
tab2.setContent(handlePane);

tabPane.getSelectionModel().select(0);
tabPane.getTabs().addAll(tab1, tab2);

root.getChildren().add(tabPane);

Scene scene = new Scene(root, 580, 400);
stage.setTitle("Order Handling Apps");
stage.setScene(scene);
stage.show();
}

public static void main(String[] args)
{
launch(args);
}
}