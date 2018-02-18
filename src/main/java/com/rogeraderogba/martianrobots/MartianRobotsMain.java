package com.rogeraderogba.martianrobots;

import java.io.Console;

public class MartianRobotsMain {

	private static InputHandler inputHandler = new InputHandler();
	
	public static void main(String[] args) {
		Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        while(true) {
            String instruction = c.readLine("Enter instruction: ");
            inputHandler.addInput(instruction);
            inputHandler.printOutput();
        }
	}
}
