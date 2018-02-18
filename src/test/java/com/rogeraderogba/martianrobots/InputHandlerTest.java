package com.rogeraderogba.martianrobots;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class InputHandlerTest {
	
	@Test
	public void test_sample_data() {	
		InputHandler inputHandler = new InputHandler();
		inputHandler.addInput("5 3");
		inputHandler.addInput("1 1 E");
		inputHandler.addInput("RFRFRFRF");
		inputHandler.addInput("3 2 N");
		inputHandler.addInput("FRRFLLFFRRFLL");
		inputHandler.addInput("0 3 W");		
		inputHandler.addInput("LLFFFLFLFL");
		List<String> output = inputHandler.getController().getFinalGridPositions();
		Assert.assertEquals(3, output.size());
		Assert.assertEquals("1 1 E", output.get(0));
		Assert.assertEquals("3 3 N LOST", output.get(1));
		Assert.assertEquals("2 3 S", output.get(2));
	}
	
	@Test(expected=MartianRobotsException.class)
	public void test_instruction_string_greater_than_max() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<101;i++) {
		    sb.append(5);
		 }
		InputHandler inputHandler = new InputHandler();
		inputHandler.addInput(sb.toString());
	}
}
