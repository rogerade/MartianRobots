package com.rogeraderogba.martianrobots;

import java.util.ArrayList;
import java.util.List;

import com.rogeraderogba.martianrobots.enums.Command;
import com.rogeraderogba.martianrobots.enums.Orientation;

public class InputHandler {
	
	private static final int MAX_INSTRUCTION_STRING = 100;

	private Controller controller;
	private int counter;
	
	public InputHandler() {
		this.counter = 1;
		this.controller = new Controller();
	}
	
	public void addInput(String input) {
		if (input == null || "".equals(input) || input.length() > MAX_INSTRUCTION_STRING) {
			throw new MartianRobotsException("Invalid input");
		}
		if (this.counter == 1) {
			String[] split = input.split(" ");
			controller.setUpperRightCoordinate(Integer.valueOf(split[0]),Integer.valueOf(split[1]));
		}
		else if (this.counter % 2 == 0){
			String[] split = input.split(" ");			
			controller.addRobot(Integer.valueOf(split[0]),Integer.valueOf(split[1]), Orientation.getOrientation(split[2]));
		}
		else {
			List<Command> commands = new ArrayList<>();
			for(char c : input.toCharArray()) {
				commands.add(Command.getCommand(c));
			}
			//TODO create immutable list
			controller.commandRobot(commands);
		}
		this.counter++;
	}
	
	public Controller getController() {
		return this.controller;
	}

}
