package main;

import java.io.File; // File Class
import java.io.FileNotFoundException;
import java.io.FileReader; // FileReader Class
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Iterator;

import elements.Audio;
import elements.Dialogue;
import elements.Entity;
import elements.Instance;
import elements.Room;
import elements.ShorthandEntities;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group; // IDK what this is for
import javafx.scene.Scene; // IDK what this is for
import javafx.scene.canvas.Canvas; // JavaFX canvas class
import javafx.scene.canvas.GraphicsContext; // IDK what this is for
import javafx.scene.image.Image; // JavaFX importing pictures and stuff
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaView;
import javafx.scene.image.Image;
import javafx.stage.Stage; // IDK what this is for

//import javafx.scene.paint.Color; // This is for color
//import javafx.scene.text.Font; // Remove this once you delete the practice stuff, useless
//import javafx.scene.text.FontWeight; // Remove this as well, because don't need automated text

/**
 * 
 * This class is also the main class where everything is stored.
 * 
 * @author Benjamin Lin
 *
 */
public class Visual extends Application {
	// These are lists of all the folders of all the main assets
	// TODO: Use an Enum for this???
	public static final String INSTANCE = System.getProperty("user.dir") + "\\src\\source\\Instance";
	public static final String ENTITY = System.getProperty("user.dir") + "\\src\\source\\Entity";
	public static final String ROOM = System.getProperty("user.dir") + "\\src\\source\\Room";
	public static final String DIALOGUE = System.getProperty("user.dir") + "\\src\\source\\Dialogue";
	public static final String SPRITES = System.getProperty("user.dir") + "\\src\\source\\Sprites";
	public static final String SPRITESURL = "file:src/source/Sprites";
	public static final String AUDIO = System.getProperty("user.dir") + "\\src\\source\\Audio";
	public static final String GAMENAME = "Reverse Odyssey";
	
	static final MediaView VIEW = new MediaView();	// IDK what this does
	Iterator<String> itr;							// IDK what this does
	
	// NOTE: for any word subtract 97 from the char and it will become a image to print out.
	
	public static void main(String[] args) {

		
		
		launch(args);

	}

	@Override
	public void start(Stage stage) throws FileNotFoundException {
		// The Stage variable is the window it first initializes

		ArrayList<Room> roomList = new ArrayList<Room>();
		ArrayList<Entity> entityList = new ArrayList<Entity>();
		ArrayList<Instance> instanceList = new ArrayList<Instance>();
		ArrayList<Audio> songList = new ArrayList<Audio>();
		System.out.println("Array Lists mado");
		initializer(roomList,entityList,instanceList,songList);
		System.out.println("WORKS");
		stage.setTitle(GAMENAME);
		// The name of the game and the window now

		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(1024,1024,1024,1024));
		
		Group root = new Group();
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.setResizable(false);

		Canvas canvas = new Canvas();
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
		
		// So this is where all the images go through to get printed out
		GraphicsContext graphic = canvas.getGraphicsContext2D();
		
		//stage.show();
		
		Integer counter = new Integer(0);

		new AnimationTimer() {

			public void handle(long currentNanoTime) {
				
				graphic.clearRect(0,0,2000,2000);
				
				// Draws the background of the instance
				graphic.drawImage(roomList.get(instanceList.get(counter).getRoom()).getBackground(),0,0);
				
				// All characters printed
				for (int index = 0;index < instanceList.get(counter).getEntities().size();index++) {
					graphic.drawImage(entityList.get(instanceList.get(counter).getEntity(index).getEntityID()).getImage(),instanceList.get(counter).getEntity(index).getXcoord(),instanceList.get(counter).getEntity(index).getYcoord());
				}
				
				// The random bar for text
				graphic.drawImage(entityList.get(0).getImage(),0,744);
				
				
				
			}

		}.start();
		
		stage.show();
		
	}
	
	private static Image[][] wordProcessor(String text) {
		// TODO: Finish word processing
		String[] array = stringCutter(new String[] {text});
		Image[][] imageArray = new Image[array.length][30];
		
		for (int index = 0;index < array.length;index++) {
			
			for (int secIndex = 0;secIndex < array[index].length();secIndex++) {
				//imageArray
				imageArray[index][secIndex] = new Image(SPRITES + "\\Extra\\" + array[index].charAt(secIndex) + ".png");
			}
			
		}
		
		return imageArray;
		
	}
	
	public static String[] stringCutter(String[] text) {
		int extension = 0;
		int[] indvExtension = new int[text.length];
		
		// Traverses all the lines in the String
		for (int index = 0; index < text.length; index++) {
			
			// If one of the Strings in the array is greater than 30, then this method will run
			if ((((double) text[index].length()) / 30) - 1 > 0.0) {
				
				// This records the total rows that this String needs
				indvExtension[index] = (int) Math.ceil(((double) text[index].length()) / 30);

				extension += (indvExtension[index] - 1);
			} else {
				
				indvExtension[index] = 1;
				
			}

		}
		
		// If there is no need for an extension, then this it short circuits and returns it as it is.
		if (extension == 0) {
			return text;
		}

		String[] rInfo = new String[text.length + extension];
		int indxCount = 0;

		for (int index = 0; index < text.length; index++) {

			if (indvExtension[index] > 0) {

				for (int repeats = 0; repeats < indvExtension[index]; repeats++) {

					if (repeats == indvExtension[index] - 1) {

						rInfo[indxCount] = text[index].substring( 30 * repeats, text[index].length());

					} else {
						rInfo[indxCount] = text[index].substring(30 * repeats, 30 + (30 * repeats));
					}

					indxCount++;

				}

			} else {

				rInfo[indxCount] = text[index];
				indxCount++;

			}

		}
		
		return rInfo;
		
	}

	private static void initializer(ArrayList<Room> roomList,ArrayList<Entity> entityList,ArrayList<Instance> instanceList,ArrayList<Audio> mediaList) throws FileNotFoundException {
		// This needs to return the room
		
		// TODO: Check the order of these, make sure they're in the right order
		ArrayList<String> roomFileArray = listFileForFolder(new File(ROOM));
		ArrayList<String> entityFileArray = listFileForFolder(new File(ENTITY));
		ArrayList<String> instanceFileArray = listFileForFolder(new File(INSTANCE));
		ArrayList<String> songFileArray = listFileForFolder(new File(AUDIO));
		
		for (int roomArrayIndex = 0;roomArrayIndex < roomFileArray.size();roomArrayIndex++) {
			System.out.println("Room #" + roomArrayIndex + " initializing");
			ArrayList<String> tempList = textfileToStringArray(new File(ROOM + "\\" + roomFileArray.get(roomArrayIndex)));
			
			System.out.println(SPRITESURL + tempList.get(0));
			roomList.add(new Room(SPRITESURL + tempList.get(0)));
			System.out.println("Room #" + roomArrayIndex + " initialized");
		}
		
		for (int entityArrayIndex = 0;entityArrayIndex < entityFileArray.size();entityArrayIndex++) {
			System.out.println("Entity #" + entityArrayIndex + " initializing");
			try {
				ArrayList<String> tempList = textfileToStringArray(new File(ENTITY + "\\" + entityFileArray.get(entityArrayIndex)));
				entityList.add(new Entity(SPRITESURL + tempList.get(0),tempList.get(1)));
			} catch (Exception e) {
				System.out.println("ERROR IN PROCESSING!!!");
				e.printStackTrace();
			}
			
			
			System.out.println("Entity #" + entityArrayIndex + " initialized");
		}
		
		for (int instanceArrayIndex = 0;instanceArrayIndex < instanceFileArray.size();instanceArrayIndex++) {
			instanceList.add(fileToInstance(INSTANCE + "\\" + instanceFileArray.get(0)));
		}
		
		for (int songArrayIndex = 0;songArrayIndex < songFileArray.size();songArrayIndex++) {
			mediaList.add(new Audio(AUDIO + songFileArray.get(songArrayIndex)));
		}
		
	}

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
		
		// IDK what this is
		//Dialogue tempDialogue = folderToDialogue(new File(DIALOGUE + "\\dialogue_" + tempInstanceFile));
		Dialogue tempDialogue = fileToDialogue(new File(DIALOGUE + "\\" + tempInstanceFile + ".txt"));
		
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
	
	public static Dialogue fileToDialogue(File textfile) throws FileNotFoundException {
		ArrayList<String> dialogueFile = textfileToStringArray(textfile);
		
		String[] tempArray = dialogueFile.get(0).split(":");
		Dialogue initialDialogue = new Dialogue(tempArray[0],Integer.parseInt(tempArray[1]),tempArray[2],Boolean.parseBoolean(tempArray[3]));
		
		for (int index = 1;index < dialogueFile.size();index++) {
			tempArray = dialogueFile.get(index).split(":");
			initialDialogue.add(new Dialogue(tempArray[0],Integer.parseInt(tempArray[1]),tempArray[2],Boolean.parseBoolean(tempArray[3])));
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
