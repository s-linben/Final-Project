package main;

import java.util.ArrayList;
import java.util.Arrays;
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
import elements.*;

/**
 * 
 * This class is also the main class where everything is stored. 
 * 
 * @author Benjamin Lin
 *
 */
public class Visual extends Application {
	public static final String INSTANCE = System.getProperty("user.dir") + "\\Instance";
	public static final String ENTITY = System.getProperty("user.dir") + "\\entity";
	
	public static void main(String[] args) {
		
		String dir = System.getProperty("user.dir");
		
		System.out.print(dir);
		
		System.getProperty("user.dir",dir);
		
		// Creates a new folder
		new File(dir);
		
		boolean desktop = new File(dir + "\\suckMyAss").mkdirs();
		
		//launch(args);
		
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
	
	/*
	 * Should always check for the file suckMyAss.txt (game initializer file)
	 */
	private static Instance fileToInstance(String file) throws FileNotFoundException {
		Instance tempInstace = new Instance();
		
		File initalizerFile = new File(INSTANCE);
		File entityFile = new File(ENTITY);
		ArrayList<String> instanceTextFiles = listFileForFolder(initalizerFile);
		ArrayList<String> entityTextFiles = listFileForFolder(entityFile);
		mergeSortInitializer(instanceTextFiles);
		
		for (int index = 0;index < instanceTextFiles.size();index++) {
			
			// Removes the ".txt" part of the name of the files
			instanceTextFiles.set(index,instanceTextFiles.get(index).substring(0,instanceTextFiles.get(index).length() - 4));
			
		}
		
		Dialogue tempDialogue = new Dialogue();
		
		Instance tempInstance = new Instance();
		return tempInstance;
	}
	
	private static ArrayList<String> listFileForFolder(final File folder) {
		ArrayList<String> tempFileEntryList = new ArrayList<String>();
		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory()) {
				tempFileEntryList.add(fileEntry.getName());
			}
		}
		return tempFileEntryList;
	}
	
	private static Room fileToRoom(String file) throws FileNotFoundException {
		// This will break if it does not find the file
		
		String dir = System.getProperty("user.dir");
		
		Room room = new Room();
		ArrayList<String> text = fileToArray(new File(file));
		
		return room;
	}
	
	public static Dialogue folderToDialogue(File folder) {
		ArrayList<String> dialogueFiles = listFileForFolder(folder);
		mergeSortInitializer(dialogueFiles);
		
		
		for (int index = 0;index < dialogueFiles.size();index++) {
			
		}
		
		
		Dialogue initialDialogue = new Dialogue();
		
		
		Dialogue tempDialogue - new Dialogue();
	}
	
	public static ArrayList<String> textfileToStringArray(File file) throws FileNotFoundException {
		ArrayList<String> tempList = new ArrayList<String>();
		FileReader reader = new FileReader(file);
		Scanner tokenBasedReader = new Scanner(reader);
		
		while (tokenBasedReader.hasNextLine()) {
			tempList.add(tokenBasedReader.nextLine());
		}
		
		tokenBasedReader.close();
		return tempList;
	}
	
	public static void textfileToStringArray(File file,ArrayList<String> arrayList) throws FileNotFoundException {
		FileReader reader = new FileReader(file);
		Scanner tokenBasedReader = new Scanner(reader);
		
		while (tokenBasedReader.hasNextLine()) {
			arrayList.add(tokenBasedReader.nextLine());
		}
		tokenBasedReader.close();
	}
	
	public static void mergeSortInitializer(ArrayList<String> list) {
		
		String[] array = list.toArray(new String[list.size()]);
		array = mergeSort(array);
		list = new ArrayList<String>(Arrays.asList(array));
		
	}

	public static String[] mergeSort(String[] array) {

		/*
		 * System.out.println("MergeSort\t");
		 * 
		 * for (int index = 0;index < array.length;index++) {
		 * 
		 * System.out.println(array[index]);
		 * 
		 * }
		 */

		if (array.length > 2) {

			String[] left = Arrays.copyOfRange(array, 0, array.length / 2);
			String[] right = Arrays.copyOfRange(array, left.length, array.length);

			mergeSort(left);
			mergeSort(right);

			int leftCounter = 0;
			int rightCounter = 0;
			for (int index = 0; index < array.length; index++) {

				/*
				 * System.out.println("Left:" + leftCounter); System.out.println("Right:" +
				 * rightCounter); System.out.println("Index:" + index);
				 */

				if (leftCounter == left.length) {

					// System.out.println("left counter == left.length");

					// Dump rest in

					for (int tempInt = rightCounter; rightCounter < right.length; tempInt++) {

						array[index] = right[tempInt];
						index += 1;
						rightCounter += 1;
					}

				} else if (rightCounter == right.length) {

					// System.out.println("right counter == right.length");

					// Dump rest in

					for (int tempInt = leftCounter; leftCounter < left.length; tempInt++) {

						array[index] = left[tempInt];
						index += 1;
						leftCounter += 1;
					}
					
					// TODO: Check code
				} else if (left[leftCounter].compareTo(right[rightCounter]) < 0) {

					/*
					 * System.out.println("left:" + left[leftCounter]); System.out.println("Right:"
					 * + right[rightCounter]); System.out.println("Left is less than Right Var");
					 */

					array[index] = left[leftCounter];
					leftCounter += 1;

				} else {

					/*
					 * System.out.println("left:" + left[leftCounter]); System.out.println("Right:"
					 * + right[rightCounter]); System.out.println("Right is less than Left Var");
					 */

					array[index] = right[rightCounter];
					rightCounter += 1;

				}

			}

		} else if (array.length == 2) {

			// System.out.println("Double length array!!!");

			if (array[1].compareTo(array[0]) < 0) {

				String temp = array[1];
				array[1] = array[0];
				array[0] = temp;

			}

		}

		// System.out.println();

		return array;

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
