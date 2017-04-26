package com.ex.mindbraker.alternative;

import com.ex.mindbraker.alternative.Field.CircleType;
import com.ex.mindbraker.alternative.Field.Direction;

public class Main {

	
	/**
	 * 
	 * alternative - don`t remember how circle is rotated, just hold objects in arrays
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("=Start mindbraker=");
		Field field = new Field();
		field.printField();
		field.rotateCircle(CircleType.LEFT, Direction.CLOCKWISE);
		field.printField();
		field.rotateCircle(CircleType.TOP, Direction.COUNTERCLOCKWISE);
		field.printField();
		field.rotateCircle(CircleType.RIGHT, Direction.COUNTERCLOCKWISE);
		field.printField();
		field.rotateCircle(CircleType.RIGHT, Direction.COUNTERCLOCKWISE);
		field.printField();
		field.rotateCircle(CircleType.RIGHT, Direction.COUNTERCLOCKWISE);
		field.printField();
		field.rotateCircle(CircleType.RIGHT, Direction.COUNTERCLOCKWISE);
		field.printField();
		field.rotateCircle(CircleType.LEFT, Direction.CLOCKWISE);
		field.printField();
		field.rotateCircle(CircleType.TOP, Direction.COUNTERCLOCKWISE);
		field.printField();
		
//		field.printCircle(CircleType.LEFT);
//		field.printCircle(CircleType.RIGHT);
//		field.printCircle(CircleType.TOP);
	}

}
