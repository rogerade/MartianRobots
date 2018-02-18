package com.rogeraderogba.martianrobots;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

import com.rogeraderogba.martianrobots.enums.Command;
import com.rogeraderogba.martianrobots.enums.Orientation;


public class MartianRobotsTest {
	
	private Controller controller = new Controller();

	@Test
	public void test_sample_data() {		
		controller.setUpperRightCoordinate(5,3);
		controller.addRobot(1, 1, Orientation.EAST);
		controller.commandRobot(Arrays.asList(
				Command.RIGHT, Command.FORWARD, Command.RIGHT, Command.FORWARD, 
				Command.RIGHT, Command.FORWARD, Command.RIGHT, Command.FORWARD
				));
		
		controller.addRobot(3, 2, Orientation.NORTH);
		controller.commandRobot(Arrays.asList(
				Command.FORWARD, Command.RIGHT, Command.RIGHT, Command.FORWARD, 
				Command.LEFT, Command.LEFT, Command.FORWARD, Command.FORWARD,
				Command.RIGHT, Command.RIGHT, Command.FORWARD, Command.FORWARD
				));

		controller.addRobot(0, 3, Orientation.WEST);
		controller.commandRobot(Arrays.asList(
				Command.LEFT, Command.LEFT, Command.FORWARD, Command.FORWARD, 
				Command.FORWARD, Command.LEFT, Command.FORWARD, Command.LEFT,
				Command.FORWARD, Command.LEFT
				));
		
		List<String> output = controller.getFinalGridPositions();
		Assert.assertEquals(3, output.size());
		Assert.assertEquals("1 1 E", output.get(0));
		Assert.assertEquals("3 3 N LOST", output.get(1));
		Assert.assertEquals("2 3 S", output.get(2));
	}
	
	@Test(expected=MartianRobotsException.class)
	public void testMaximumXCordinate() {
		controller.setUpperRightCoordinate(51,3);
	}
	
	@Test(expected=MartianRobotsException.class)
	public void testMaximumYCordinate() {
		controller.setUpperRightCoordinate(3,51);
	}
	
	@Test(expected=MartianRobotsException.class)
	public void testMaximumXCordinateForRobot() {
		controller.addRobot(51, 3, Orientation.NORTH);
	}
	
	@Test(expected=MartianRobotsException.class)
	public void testMaximumYCordinateForRobot() {
		controller.addRobot(3, 51, Orientation.NORTH);
	}
	
	@Test(expected=MartianRobotsException.class)
	public void testNegativeXCordinateForRobot() {
		controller.addRobot(Integer.MIN_VALUE, 3, Orientation.NORTH);
	}

	@Test(expected=MartianRobotsException.class)
	public void testNegativeYCordinateForRobot() {
		controller.addRobot(3, Integer.MIN_VALUE, Orientation.NORTH);
	}
}
