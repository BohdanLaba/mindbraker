package com.ex.mindbraker.alternative;

import com.ex.mindbraker.alternative.Triangle.TriangleType;

public class Field {

	public enum CircleType {
		LEFT, TOP, RIGHT
	}

	public enum Direction {
		CLOCKWISE, COUNTERCLOCKWISE
	}

	private Triangle[][] globalField = new Triangle[3][5];
	private Triangle[][] leftCircle = new Triangle[2][3];
	private Triangle[][] topCircle = new Triangle[2][3];
	private Triangle[][] rightCircle = new Triangle[2][3];

	public Field() {
		globalField[0][0] = new Triangle("emptyOne", TriangleType.NULL);
		globalField[0][1] = new Triangle("1", TriangleType.DOUBLE_CONVEX);
		globalField[0][2] = new Triangle("2", TriangleType.ONE_CONVEX);
		globalField[0][3] = new Triangle("3", TriangleType.DOUBLE_CONVEX);
		globalField[0][4] = new Triangle("emptyTwo", TriangleType.NULL);
		globalField[1][0] = new Triangle("4", TriangleType.DOUBLE_CONVEX);
		globalField[1][1] = new Triangle("5", TriangleType.DOUBLE_CONVEX);
		globalField[1][2] = new Triangle("6", TriangleType.TRIPPLE_CONVEX);
		globalField[1][3] = new Triangle("7", TriangleType.DOUBLE_CONVEX);
		globalField[1][4] = new Triangle("8", TriangleType.DOUBLE_CONVEX);
		globalField[2][0] = new Triangle("9", TriangleType.ONE_CONVEX);
		globalField[2][1] = new Triangle("10", TriangleType.DOUBLE_CONVEX);
		globalField[2][2] = new Triangle("11", TriangleType.DOUBLE_CONVEX);
		globalField[2][3] = new Triangle("12", TriangleType.DOUBLE_CONVEX);
		globalField[2][4] = new Triangle("13", TriangleType.ONE_CONVEX);

		leftCircle[0][0] = globalField[1][0];
		leftCircle[0][1] = globalField[1][1];
		leftCircle[0][2] = globalField[1][2];
		leftCircle[1][0] = globalField[2][0];
		leftCircle[1][1] = globalField[2][1];
		leftCircle[1][2] = globalField[2][2];

		topCircle[0][0] = globalField[0][1];
		topCircle[0][1] = globalField[0][2];
		topCircle[0][2] = globalField[0][3];
		topCircle[1][0] = globalField[1][1];
		topCircle[1][1] = globalField[1][2];
		topCircle[1][2] = globalField[1][3];

		rightCircle[0][0] = globalField[1][2];
		rightCircle[0][1] = globalField[1][3];
		rightCircle[0][2] = globalField[1][4];
		rightCircle[1][0] = globalField[2][2];
		rightCircle[1][1] = globalField[2][3];
		rightCircle[1][2] = globalField[2][4];
	}

	public void rotateCircle(CircleType type, Direction direction) {
		if (canRotateCircle(type)) {
			Triangle[][] currentTriangle = geTriangleArray(type);

			if (direction.equals(Direction.CLOCKWISE)) {
				// TODO implement rotation

			} else if (direction.equals(Direction.COUNTERCLOCKWISE)) {
				// TODO implement rotation

			}

		} else {
			System.out.println("Cannot rotate this triangle");
		}

	}

	// only if has central element in it.
	private boolean canRotateCircle(CircleType type) {
		Triangle[][] currentTriangle = geTriangleArray(type);

		for (int i = 0; i < currentTriangle.length; i++) {
			for (int j = 0; j < currentTriangle[i].length; j++) {
				if (currentTriangle[i][j].getTriangleType().equals(TriangleType.TRIPPLE_CONVEX)) {
					return true;
				}
			}
		}
		return false;
	}

	private Triangle[][] geTriangleArray(CircleType type) {
		Triangle[][] currentTriangle = null;
		if (type.equals(CircleType.LEFT)) {
			currentTriangle = leftCircle;
		}
		if (type.equals(CircleType.RIGHT)) {
			currentTriangle = rightCircle;
		}
		if (type.equals(CircleType.TOP)) {
			currentTriangle = topCircle;
		}
		return currentTriangle;
	}

	public void printField() {

	}
}
