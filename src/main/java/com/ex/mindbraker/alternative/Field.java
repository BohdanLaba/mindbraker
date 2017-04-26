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
		globalField[0][0] = new Triangle("**", TriangleType.NULL);
		globalField[0][1] = new Triangle("01", TriangleType.DOUBLE_CONVEX);
		globalField[0][2] = new Triangle("02", TriangleType.ONE_CONVEX);
		globalField[0][3] = new Triangle("03", TriangleType.DOUBLE_CONVEX);
		globalField[0][4] = new Triangle("**", TriangleType.NULL);
		globalField[1][0] = new Triangle("04", TriangleType.DOUBLE_CONVEX);
		globalField[1][1] = new Triangle("05", TriangleType.DOUBLE_CONVEX);
		globalField[1][2] = new Triangle("06", TriangleType.TRIPPLE_CONVEX);
		globalField[1][3] = new Triangle("07", TriangleType.DOUBLE_CONVEX);
		globalField[1][4] = new Triangle("08", TriangleType.DOUBLE_CONVEX);
		globalField[2][0] = new Triangle("09", TriangleType.ONE_CONVEX);
		globalField[2][1] = new Triangle("10", TriangleType.DOUBLE_CONVEX);
		globalField[2][2] = new Triangle("11", TriangleType.DOUBLE_CONVEX);
		globalField[2][3] = new Triangle("12", TriangleType.DOUBLE_CONVEX);
		globalField[2][4] = new Triangle("13", TriangleType.ONE_CONVEX);

		initCircles();
	}

	private void initCircles() {
		initCircleLeft();
		initCircleRight();
		initCircleTop();
	}

	private void initCircleLeft() {
		leftCircle[0][0] = globalField[1][0];
		leftCircle[0][1] = globalField[1][1];
		leftCircle[0][2] = globalField[1][2];
		leftCircle[1][0] = globalField[2][0];
		leftCircle[1][1] = globalField[2][1];
		leftCircle[1][2] = globalField[2][2];
	}

	private void initCircleRight() {
		rightCircle[0][0] = globalField[1][2];
		rightCircle[0][1] = globalField[1][3];
		rightCircle[0][2] = globalField[1][4];
		rightCircle[1][0] = globalField[2][2];
		rightCircle[1][1] = globalField[2][3];
		rightCircle[1][2] = globalField[2][4];
	}

	private void initCircleTop() {
		topCircle[0][0] = globalField[0][1];
		topCircle[0][1] = globalField[0][2];
		topCircle[0][2] = globalField[0][3];
		topCircle[1][0] = globalField[1][1];
		topCircle[1][1] = globalField[1][2];
		topCircle[1][2] = globalField[1][3];
	}

	public void rotateCircle(CircleType type, Direction direction) {
		System.out.println(String.format("Rotating cirle %s %s.", type.name(), direction.name()));
		if (canRotateCircle(type)) {
			Triangle[][] currentCircle = geTriangleArray(type);
			rotateCircle(currentCircle, direction);
			updateGlobalField(type);
		} else {
			System.out.println("Cannot rotate this circle.");
		}

	}

	private void rotateCircle(Triangle[][] currentCircle, Direction direction) {
		if (direction.equals(Direction.CLOCKWISE)) {
			Triangle temp = new Triangle(currentCircle[1][0]);
			currentCircle[1][0] = currentCircle[1][1];
			currentCircle[1][1] = currentCircle[1][2];
			currentCircle[1][2] = currentCircle[0][2];
			currentCircle[0][2] = currentCircle[0][1];
			currentCircle[0][1] = currentCircle[0][0];
			currentCircle[0][0] = temp;
		} else if (direction.equals(Direction.COUNTERCLOCKWISE)) {
			Triangle temp = new Triangle(currentCircle[1][0]);
			currentCircle[1][0] = currentCircle[0][0];
			currentCircle[0][0] = currentCircle[0][1];
			currentCircle[0][1] = currentCircle[0][2];
			currentCircle[0][2] = currentCircle[1][2];
			currentCircle[1][2] = currentCircle[1][1];
			currentCircle[1][1] = temp;
		}
	}

	// only if has central element in it.
	private boolean canRotateCircle(CircleType type) {
		Triangle[][] currentCircle = geTriangleArray(type);

		for (int i = 0; i < currentCircle.length; i++) {
			for (int j = 0; j < currentCircle[i].length; j++) {
				if (currentCircle[i][j].getTriangleType().equals(TriangleType.TRIPPLE_CONVEX)) {
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

	private void updateGlobalField(CircleType modifiedCircleType) {
		if (modifiedCircleType.equals(CircleType.LEFT)) {
			globalField[1][0] = leftCircle[0][0];
			globalField[1][1] = leftCircle[0][1];
			globalField[1][2] = leftCircle[0][2];
			globalField[2][0] = leftCircle[1][0];
			globalField[2][1] = leftCircle[1][1];
			globalField[2][2] = leftCircle[1][2];
			initCircleRight();
			initCircleTop();
		}
		if (modifiedCircleType.equals(CircleType.TOP)) {
			globalField[0][1] = topCircle[0][0];
			globalField[0][2] = topCircle[0][1];
			globalField[0][3] = topCircle[0][2];
			globalField[1][1] = topCircle[1][0];
			globalField[1][2] = topCircle[1][1];
			globalField[1][3] = topCircle[1][2];
			initCircleLeft();
			initCircleRight();
		}
		if (modifiedCircleType.equals(CircleType.RIGHT)) {
			globalField[1][2] = rightCircle[0][0];
			globalField[1][3] = rightCircle[0][1];
			globalField[1][4] = rightCircle[0][2];
			globalField[2][2] = rightCircle[1][0];
			globalField[2][3] = rightCircle[1][1];
			globalField[2][4] = rightCircle[1][2];
			initCircleLeft();
			initCircleTop();
		}
	}

	public void printField() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < globalField.length; i++) {
			for (int j = 0; j < globalField[i].length; j++) {
				builder.append(globalField[i][j].getName()).append(" ");
			}
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}

	public void printCircle(CircleType type) {
		System.out.println(String.format("Circle %s :", type.name()));
		Triangle[][] currentCircle = geTriangleArray(type);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < currentCircle.length; i++) {
			for (int j = 0; j < currentCircle[i].length; j++) {
				builder.append(currentCircle[i][j].getName()).append(" ");
			}
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}

}
