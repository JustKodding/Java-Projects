package application;

//Assignment #: Arizona State University CSE205 #7

//Name: Justin Carter
//StudentID: 1216733401
//Lecture:MWF 9:40Am
//Description: The DrawPane class creates a canvas where we can use
//    mouse key to draw either a Rectangle, a Circle or an Arc with different
//    colors. We can also use the the two buttons to erase the last
//		 drawn shape or clear them all.

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class DrawPane extends BorderPane {
//instance variable
	private Button undoBtn, eraseBtn;
	private ComboBox<String> colorCombo;
	private RadioButton rbRect, rbCircle, rbArc;
	private ArrayList<Shape> shapeList;
	private Pane canvas;

	private boolean rectangle = true;
	private boolean circle = false;
	private boolean arc = false;

	private Shape currentShape = null;

	private Color fillColor = Color.BLACK;

	private double X, Y;

//constructor 
	public DrawPane() {
		// Buttons
		undoBtn = new Button("Undo");
		eraseBtn = new Button("Erase");

		undoBtn.setMinWidth(80.0);
		eraseBtn.setMinWidth(80.0);
//Listing colors
		colorCombo = new ComboBox<String>(FXCollections.observableArrayList(

				"Black", "Red", "Blue",

				"Green", "Yellow", "Orange", "Pink"));

		colorCombo.getSelectionModel().select(0);

		rbRect = new RadioButton("Rectangle");

		rbRect.setSelected(true);

		rbCircle = new RadioButton("Circle");

		rbArc = new RadioButton("Arc");

		ToggleGroup t = new ToggleGroup();

		rbRect.setToggleGroup(t);

		rbCircle.setToggleGroup(t);

		rbArc.setToggleGroup(t);

		shapeList = new ArrayList<Shape>();

		canvas = new Pane();

		canvas.setStyle("-fx-background-color: Azure;");
//setting up layout
		VBox vbox = new VBox(colorCombo, rbRect, rbCircle, rbArc);

		vbox.setSpacing(20);

		vbox.setPadding(new Insets(20));

		vbox.setStyle("-fx-border-color: black");

		HBox hbox = new HBox(undoBtn, eraseBtn);

		hbox.setSpacing(20);

		hbox.setAlignment(Pos.CENTER);

		hbox.setStyle("-fx-border-color: black");

		setLeft(vbox);

		setCenter(canvas);

		setBottom(hbox);

		MouseHandler mouseHandler = new MouseHandler();

		canvas.setOnMousePressed(mouseHandler);

		canvas.setOnMouseDragged(mouseHandler);

		canvas.setOnMouseReleased(mouseHandler);

		ButtonHandler btnHandler = new ButtonHandler();

		undoBtn.setOnAction(btnHandler);

		eraseBtn.setOnAction(btnHandler);

		ShapeHandler shapeHandler = new ShapeHandler();

		rbCircle.setOnAction(shapeHandler);

		rbRect.setOnAction(shapeHandler);

		rbArc.setOnAction(shapeHandler);

		ColorHandler colorHandler = new ColorHandler();

		colorCombo.setOnAction(colorHandler);

	}

	private class MouseHandler implements EventHandler<MouseEvent> {

		public void handle(MouseEvent event) {

			if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {

				if (currentShape == null) {

					X = event.getX();

					Y = event.getY();

					if (rectangle) {

						currentShape = new Rectangle(event.getX(), event.getY(), 0, 0);

					} else if (circle) {

						currentShape = new Circle(event.getX(), event.getY(), 0);

					} else if (arc) {
						currentShape = new Arc(event.getX(), event.getY(), 0, 0, 0, 0);
					}

					currentShape.setFill(Color.WHITE);

					currentShape.setStroke(Color.BLACK);

					shapeList.add(currentShape);

					canvas.getChildren().clear();

					canvas.getChildren().addAll(shapeList);

				}

			} else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {

				if (currentShape != null) {

					double dx = Math.abs(X - event.getX());

					double dy = Math.abs(Y - event.getY());

					if (rectangle) {

						currentShape = new Rectangle(X, Y, dx, dy);

						currentShape.setFill(Color.WHITE);

						currentShape.setStroke(Color.BLACK);

						shapeList.set(shapeList.size() - 1, currentShape);

					} else if (circle) {

						currentShape = new Circle(X, Y, dx);

						currentShape.setFill(Color.WHITE);

						currentShape.setStroke(Color.BLACK);

						shapeList.set(shapeList.size() - 1, currentShape);

					} else if (arc) {
						currentShape = new Arc(X, Y, dx, dy, 0, dy);

						currentShape.setFill(Color.WHITE);

						currentShape.setStroke(Color.BLACK);

						shapeList.set(shapeList.size() - 1, currentShape);

					}

					canvas.getChildren().clear();

					canvas.getChildren().addAll(shapeList);

				}

			} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {

				if (currentShape != null) {

					double dx = Math.abs(X - event.getX());

					double dy = Math.abs(Y - event.getY());

					if (rectangle) {

						currentShape = new Rectangle(X, Y, dx, dy);

					} else if (circle) {

						currentShape = new Circle(X, Y, dx);

					} else if (arc) {
						double angleInRadians = Math.atan2(dy, dx);

						double length = Math.toDegrees(angleInRadians);
						currentShape = new Arc(X, Y, dx, dy, angleInRadians, dy);
					}

					currentShape.setFill(fillColor);

					shapeList.set(shapeList.size() - 1, currentShape);

					canvas.getChildren().clear();

					canvas.getChildren().addAll(shapeList);

					currentShape = null;

				}

			}

		}

	}

	private class ButtonHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			if (event.getSource().equals(undoBtn)) {

				if (shapeList.size() > 0) {

					shapeList.remove(shapeList.size() - 1);

					canvas.getChildren().clear();

					canvas.getChildren().addAll(shapeList);

				}

			} else if (event.getSource().equals(eraseBtn)) {

				shapeList.clear();

				canvas.getChildren().clear();

			}

		}

	}

	private class ShapeHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			// gets shape
			if (event.getSource().equals(rbRect)) {

				rectangle = true;

			} else {

				rectangle = false;

			}

			if (event.getSource().equals(rbCircle)) {

				circle = true;

			} else {

				circle = false;

			}

			if (event.getSource().equals(rbArc)) {

				arc = true;

			} else {

				arc = false;

			}
		}

	}

	private class ColorHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			String selected = colorCombo.getSelectionModel().getSelectedItem();
			// changes color
			if (selected.equalsIgnoreCase("Black")) {

				fillColor = Color.BLACK;

			} else if (selected.equalsIgnoreCase("Red")) {

				fillColor = Color.RED;

			} else if (selected.equalsIgnoreCase("Blue")) {

				fillColor = Color.BLUE;

			} else if (selected.equalsIgnoreCase("Green")) {

				fillColor = Color.GREEN;

			} else if (selected.equalsIgnoreCase("Yellow")) {

				fillColor = Color.YELLOW;

			} else if (selected.equalsIgnoreCase("Orange")) {

				fillColor = Color.ORANGE;

			} else {

				fillColor = Color.PINK;

			}

		}

	}

}