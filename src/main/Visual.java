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
import java.io.File;							// File Class
import java.io.FileReader;						// FileReader Class
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import background.Room;

/**
 * 
 * This class is also the main class where everything is stored. 
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
		
		Room room_1;
		initializer();
		
		stage.setTitle("The Trip");
		// The name of the game and the window now
		
		Group root = new Group();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		Canvas canvas = new Canvas(1000,1000);
		root.getChildren().add(canvas);
		
		stage.show();
		
		new AnimationTimer() {
			
			public void handle(long currentNanoTime) {
				
				
				
			}
			
		}.start();
		
	}
	
	private static void initializer(String file) throws FileNotFoundException {
		// This needs to return the room
		
		Room room = fileToRoom("Potato");
		
		ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
		
		File in;
		File out;
		String filename;
		
		
		
		
		//initialReader();
		
	}
	
	private static Room fileToRoom(String file) throws FileNotFoundException {
		// This will break if it does not find the file
		
		Room room = new Room();
		ArrayList<String> text = fileToArray(new File(file));
		
		room.setRoomNum(Integer.parseInt(text.get(0)));
		fileToTileMaps(text.get(1),room);
		fileToProps(text.get(2),room);
		fileToBarrier(text.get(3),room);
		fileToInteractable(text.get(4),room);
		fileToItem(text.get(5),room);
		
		return room;
	}
	
	private static void fileToTileMaps(String file,Room room) throws FileNotFoundException {
		
		File itemFile = new File(file);
		Scanner reader = new Scanner(itemFile);
		
		while (reader.hasNextLine()) {
			
			
			
		}
		
	}
	
	private static void fileToProps(String file,Room room) throws FileNotFoundException {
		
		File itemFile = new File(file);
		Scanner reader = new Scanner(itemFile);
		
		while (reader.hasNextLine()) {
			
			
			
		}
		
	}
	
	private static void fileToBarrier(String file,Room room) throws FileNotFoundException {
		
		File itemFile = new File(file);
		Scanner reader = new Scanner(itemFile);
		
		while (reader.hasNextLine()) {
			
			
			
		}
		
	}
	
	private static void fileToInteractable(String file,Room room) throws FileNotFoundException {
		
		File itemFile = new File(file);
		Scanner reader = new Scanner(itemFile);
		
		while (reader.hasNextLine()) {
			
			
			
		}
		
	}
	
	private static void fileToItem(String file,Room room) throws FileNotFoundException {
		
		File itemFile = new File(file);
		Scanner reader = new Scanner(itemFile);
		
		while (reader.hasNextLine()) {
			
			room.addItem(reader.nextLine());
			
		}
		
	}
	
	private static void fileToPlayer(String file) throws FileNotFoundException {
		
		
		
	}
	
	private static ArrayList<String> fileToArray(File file) throws FileNotFoundException {
		
		ArrayList<String> array = new ArrayList<String>();
		
		FileReader fileRead = new FileReader(file);
		Scanner input = new Scanner(fileRead);
		
		while (input.hasNextLine()) {
			
			array.add(input.nextLine());
			
		}
		
		input.close();
		
		return new ArrayList<String>();
		
	}

}
