package main;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;						// IDK what this is for
import javafx.scene.Group;						// IDK what this is for
import javafx.scene.Scene;						// IDK what this is for
import javafx.scene.canvas.Canvas;				// JavaFX canvas class
import javafx.scene.canvas.GraphicsContext;		// IDK what this is for
import javafx.scene.image.Image;				// JavaFX importing pictures and stuff
import javafx.scene.paint.Color;				// This is for color
import javafx.scene.text.Font;					// Remove this once you delete the practice stuff, useless
import javafx.scene.text.FontWeight;			// Remove this as well, because don't need automated text
import javafx.scene.input.KeyEvent;

/**
 * 
 * @author Benjamin Lin
 *
 */
public class Visual extends Application {
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	@Override
	public void start(Stage stage) {
		// The Stage variable is the window it first initializes
		
		stage.setTitle("The Trip");
		// The name of the game and the window now
		
		Group root = new Group();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		Canvas canvas = new Canvas(1000,1000);
		root.getChildren().add(canvas);
		
		stage.show();
		
	}
	
}
