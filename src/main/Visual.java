package main;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage; // IDK what this is for
import javafx.scene.Group; // IDK what this is for
import javafx.scene.Scene; // IDK what this is for
import javafx.scene.canvas.Canvas; // JavaFX canvas class
import javafx.scene.canvas.GraphicsContext; // IDK what this is for
import javafx.scene.image.Image; // JavaFX importing pictures and stuff
import javafx.scene.paint.Color; // This is for color
import javafx.scene.text.Font; // Remove this once you delete the practice stuff, useless
import javafx.scene.text.FontWeight; // Remove this as well, because don't need automated text
import javafx.scene.input.KeyEvent;
import java.io.File; // File Class
import java.io.FileReader; // FileReader Class
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
	// These are lists of all the folders of all the main assets
	public static final String INSTANCE = System.getProperty("user.dir") + "\\src\\source\\Instance";
	public static final String ENTITY = System.getProperty("user.dir") + "\\src\\source\\Entity";
	public static final String ROOM = System.getProperty("user.dir") + "\\src\\source\\Room";
	public static final String DIALOGUE = System.getProperty("user.dir") + "\\src\\source\\Dialogue";
	public static final String SPRITES = System.getProperty("user.dir") + "\\src\\source\\Sprites";
	
	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage stage) throws FileNotFoundException {
		// The Stage variable is the window it first initializes

		ArrayList<Room> roomList = new ArrayList<Room>();
		ArrayList<Entity> entityList = new ArrayList<Entity>();
		ArrayList<Instance> instanceList = new ArrayList<Instance>();
		
		initializer(roomList,entityList,instanceList);

		stage.setTitle("The Trip");
		// The name of the game and the window now

		Group root = new Group();
		Scene scene = new Scene(root);
		stage.setScene(scene);

		Canvas canvas = new Canvas(1000, 1000);
		root.getChildren().add(canvas);
		
		Boolean change = new Boolean(false);
		
		ArrayList<String> input = new ArrayList<String>();
		
		/*
		scene.setOnMouseClicked(
				new EventHandler() {
					public void handle(MouseEvent e) {
						change = new Boolean("true");
					}
				});
				*/
		
		scene.setOnKeyPressed(
				new EventHandler<KeyEvent>() {
					public void handle(KeyEvent e) {
						String code = e.getCode().toString();
						if (!input.contains(code)) {
							input.add(code);
						}
					}
				});
		
		scene.setOnKeyReleased(
				new EventHandler<KeyEvent>() {
					public void handle(KeyEvent e) {
						String code = e.getCode().toString();
						input.remove(code);
					}
				});
		
		GraphicsContext graphic = canvas.getGraphicsContext2D();
		
		//stage.show();

		new AnimationTimer() {

			public void handle(long currentNanoTime) {
				
				graphic.clearRect(0,0,1000,1000);
				
				
			}

		}.start();
		
		stage.show();
		
	}

	private static void initializer(ArrayList<Room> roomList,ArrayList<Entity> entityList,ArrayList<Instance> instanceList) throws FileNotFoundException {
		// This needs to return the room
		
		// TODO: Check the order of these, make sure they're in the right order
		ArrayList<String> roomFileArray = listFileForFolder(new File(ROOM));
		ArrayList<String> entityFileArray = listFileForFolder(new File(ENTITY));
		ArrayList<String> instanceFileArray = listFileForFolder(new File(INSTANCE));
		
		for (int roomArrayIndex = 0;roomArrayIndex < roomFileArray.size();roomArrayIndex++) {
			ArrayList<String> tempList = textfileToStringArray(new File(roomFileArray.get(roomArrayIndex)));
			roomList.add(new Room(tempList.get(0)));
		}
		
		for (int entityArrayIndex = 0;entityArrayIndex < entityFileArray.size();entityArrayIndex++) {
			ArrayList<String> tempList = textfileToStringArray(new File(entityFileArray.get(entityArrayIndex)));
			entityList.add(new Entity(SPRITES + tempList.get(0),tempList.get(1)));
		}
		
		for (int instanceArrayIndex = 0;instanceArrayIndex < instanceFileArray.size();instanceArrayIndex++) {
			instanceList.add(fileToInstance(instanceFileArray.get(0)));
		}
		
	}

	/*
	 * Should always check for the file suckMyAss.txt (game initializer file)
	 */
	private static Instance fileToInstance(String file) throws FileNotFoundException {
		/*
		//File initalizerFile = new File(INSTANCE);
		//File entityFile = new File(ENTITY);
		ArrayList<String> instanceTextFiles = listFileForFolder(initalizerFile);
		//ArrayList<String> entityTextFiles = listFileForFolder(entityFile);
		mergeSortInitializer(instanceTextFiles);

		for (int index = 0; index < instanceTextFiles.size(); index++) {

			// Removes the ".txt" part of the name of the files
			instanceTextFiles.set(index,instanceTextFiles.get(index).substring(0, instanceTextFiles.get(index).length() - 4));

		}
		*/
		
		// Creates a new file
		File tempFile = new File(file);
		
		// Removes the txt of the instance file
		String tempInstanceFile = file.substring(0,file.length() - 4);
		
		// Reads all the dialogue from an array of "a" - "f", so only 26 lines, though can be extended if you add double characters
		// TODO: extend the number of lines per thing
		Dialogue tempDialogue = folderToDialogue(new File(DIALOGUE + "\\dialogue_" + tempInstanceFile));
		
		/*
		 * Need to do entity list in this, should be <Entity ID>:<xcoord>:<ycoord>; *repeats after this
		 */
		
		ArrayList<String> instanceFileArrayList = textfileToStringArray(tempFile);
		ArrayList<ShorthandEntities> instanceEntityList = new ArrayList<ShorthandEntities>();
		
		String[] entityArray = instanceFileArrayList.get(0).split(";");
		for (int index = 0;index < entityArray.length;index++) {
			String[] tempArray = entityArray[index].split(":");
			int[] tempIntArray = new int[tempArray.length];
			for (int entityIndex = 0;entityIndex < 3;entityIndex++) {
				// This turns all the Strings into integer values, because we only need 3 integer values per shorthandEntity
				tempIntArray[entityIndex] = Integer.parseInt(tempArray[entityIndex]);
			}
			instanceEntityList.add(new ShorthandEntities(tempIntArray[1],tempIntArray[2],tempIntArray[0]));
		}
		
		Instance tempInstance = new Instance(tempDialogue,instanceEntityList,Integer.parseInt(instanceFileArrayList.get(1)));
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

	/*
	private static Room fileToRoom(String file) throws FileNotFoundException {
		// This will break if it does not find the file

		String dir = System.getProperty("user.dir");

		Room room = new Room();
		ArrayList<String> text = fileToArray(new File(file));

		return room;
	}
	*/

	public static Dialogue folderToDialogue(File folder) throws FileNotFoundException {
		ArrayList<String> dialogueFiles = listFileForFolder(folder);
		mergeSortInitializer(dialogueFiles);
		
		for (int index = 0;index < dialogueFiles.size();index++) {
			
			// Removes the ".txt" part of the name of the files
			dialogueFiles.set(index,dialogueFiles.get(index).substring(0,dialogueFiles.get(index).length() - 4));
			
		}
		
		ArrayList<String> tempArray = textfileToStringArray(new File(dialogueFiles.get(0) + ".txt"));
		
		// Dialogue ID : Speaker ID : Words : choiceTrue (should be the same ID as the dialogue, but with "_choice" tacked on at the end)
		Dialogue initialDialogue = new Dialogue(dialogueFiles.get(0),Integer.parseInt(tempArray.get(0)),tempArray.get(1),Boolean.parseBoolean(tempArray.get(2)));
		
		// Skip the first one
		for (int index = 1;index < dialogueFiles.size();index++) {
			File tempTextfile = new File(dialogueFiles.get(index));
			tempArray = textfileToStringArray(tempTextfile);
			initialDialogue.add(new Dialogue(dialogueFiles.get(index),Integer.parseInt(tempArray.get(0)),tempArray.get(1),Boolean.parseBoolean(tempArray.get(2))));
		}
		
		return initialDialogue;
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

	public static void textfileToStringArray(File file, ArrayList<String> arrayList) throws FileNotFoundException {
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
