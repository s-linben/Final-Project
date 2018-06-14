package main;

import javafx.application.Application;

public class Main {
	/*
	 * This is the main method of the program. It immediately starts off by calling the Javafx Applicaiton libraries.
	 * This means that it will run 3 methods, init (to initialize), start(Stage) (mandatory and needed to run the program, and
	 * stop(), which ends the program
	 */
	public static void main(String[] args) {
		
		// This is used to run and call the Javafx visuals
		Application.launch(Visual.class,args);

	}
}
