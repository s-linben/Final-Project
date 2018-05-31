package main;

import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gazillionSongs.SongCollection;

public class Reader {
	
	/*
		// Creates the file reader variable
		Scanner console = new Scanner(System.in);

		// Creates but doesn't initialize the file variable going in
		File in;

		// Creates but doesn't initialize the file variable going out
		File out;

		// prompt
		System.out.print(">Enter Input File: ");

		// Input variable
		String text;

		// A loop that will keep asking for the file name till it exists
		do {
			text = console.next();
			in = new File(text);
			if (!in.exists()) {
				System.out.println(">The file was not found. Please re-enter" + text);
			}
		} while (!in.exists());
		
		// This initializes the FileReader variable to read from the file
		FileReader input = new FileReader(in);
		
		// This initializes the Scanner class to read from the FileReader variable
		Scanner trueInput = new Scanner(input);
		
		// This initializes the SongCollection class where it stores all the songs
		SongCollection gazillionSongs = new SongCollection();
		
		// This will keep reading from the Scanner class for all the lines in the file till there is none left
		while (trueInput.hasNextLine()) {
			
			// This adds each line to the GazillionSongs variable
			gazillionSongs.addSong(trueInput.nextLine());

		} // End of the while loop

		// TODO: Fix???
		// This reads in the input of the user. The method called checks to make sure it is a proper input
		String[] read = consoleInput(console);
		
		// This group of if/else statements match the input with the function
		if (read[0].equalsIgnoreCase("filter")) {

			gazillionSongs.filter(read[1], read[2]);

		} else if (read[0].equalsIgnoreCase("selectionSort")) {

			gazillionSongs.selectionSort(read[1]);

		} else if (read[0].equalsIgnoreCase("insertionSort")) {

			gazillionSongs.insertionSort(read[1]);

		} else if (read[0].equalsIgnoreCase("mergeSort")) {

			gazillionSongs.mergeSortInitializer(read[1]);

		}
		
		// This is the prompt to ask the user for the output file name
		System.out.print(">Enter Output File: ");
		
		// TODO: add question that asks whether you want to overwrite your input
		// This creates/uses the file specified by the user
		out = new File(console.next());

		// This initializes the PrintStream variable to print out to the file
		PrintStream output = new PrintStream(out);

		// This calls the printSongs method in the SongCollection class to print all the songs out into the file
		gazillionSongs.printSongs(output);

	} // End of the main method

	/**
	 * 
	 * @param in - This is a Scanner variable with the purpose to read in from the user
	 * @return This returns the input in 2 parts in a String array. index 0 should be the executed command and
	 * index 1 should be the field or range of what you're filtering/searching for.
	 */
	public static String[] consoleInput(Scanner in) {

		System.out.print(">Enter sort/search command: ");

		String input = in.next();
		String[] tempInput = input.split(":");

		if (tempInput.length <= 1) {

			System.out.println(">Command is not formatted correctly. Please re-enter the command: " + input);
			return consoleInput(in);

		} else if (!(tempInput[0].equals("year") || tempInput[0].equals("rank") || tempInput[0].equals("artist")
				|| tempInput[0].equals("title"))) {

			System.out.println(">Command is not formatted correctly. Please re-enter the command: " + input);
			return consoleInput(in);

		} else {

			tempInput[0] = tempInput[0].toLowerCase();
			return tempInput;

		}
	 */
	
}
