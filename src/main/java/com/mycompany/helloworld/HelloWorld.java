package com.mycompany.helloworld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
//import org.controlsfx.tools.Borders;

import java.io.IOException;

/**
 * A JavaFX Hello World
 */
public class HelloWorld extends Application {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException {
		stage.setTitle("Hello World");

		BorderPane bp = new BorderPane();

		Label l = new Label("java.version: " + System.getProperty("java.version"));
		bp.setTop(l);

		final HTMLEditor htmlEditor = new HTMLEditor();
		htmlEditor.setPrefHeight(245);
		bp.setCenter(htmlEditor);

		Button b = new Button("Press");
		// Node wrappedButton = Borders.wrap(b)
		// .lineBorder().color(Color.RED).build()
		// .lineBorder().color(Color.GREEN).build()
		// .build();
		// Note: Some controlsfx widgets don't seem to work for Java9
		// Rating r = new Rating();
		// RangeSlider rs = new RangeSlider();
		// bp.setBottom(rs);
		// bp.setBottom(wrappedButton);
		bp.setBottom(b);

		Scene scene = new Scene(bp, 300, 250);

		stage.setScene(scene);
		stage.show();

		// do some excel stuf
		/*
		 * XSSFWorkbook w = new XSSFWorkbook("./test.xlsx"); w.createSheet("foo");
		 * w.close();
		 */

	}
}