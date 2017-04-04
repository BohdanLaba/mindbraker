package com.ex.mindbraker.service;

import java.util.Date;
import java.util.Deque;
import java.util.Random;

import com.ex.mindbraker.models.Circle;
import com.ex.mindbraker.models.Triangle;
import com.ex.mindbraker.models.Vertex;
import com.ex.mindbraker.models.VertexNames;

public class Util {
	private static String VERTEX = "Vertex";
	private static Random random = new Random((new Date()).getTime());

	public static String getNextName() {
		return VERTEX + String.valueOf(random.nextInt());
	}

	public static boolean checkCircleConsistency(Circle circleA, Circle circleB, Circle circleC) {
		if (!circleA.getArray()[0][1].equals(circleB.getArray()[1][0])) {
			return false;
		}
		if (!circleB.getArray()[1][2].equals(circleC.getArray()[0][1])) {
			return false;
		}
		if (!circleA.getArray()[1][2].equals(circleC.getArray()[1][0])) {
			return false;
		}
		if (!circleA.getArray()[0][2].equals(circleB.getArray()[1][1])
				&& circleB.getArray()[1][1].equals(circleC.getArray()[0][0])) {
			return false;
		}

		return true;
	}

	public static Deque<Vertex> rotateVertexes(Deque<Vertex> vertexes) {
		Vertex lastVertex = vertexes.pollLast();
		vertexes.push(lastVertex);
		return vertexes;
	}

	public static void rotateVertexesClockwise(Vertex[][] vertexes) {
		if (!vertexes[0][1].getName().isEmpty() && !vertexes[0][1].getName().equals(VertexNames.NULL.toString())) {
			vertexes[0][2].setName(vertexes[0][1].getName());
			vertexes[0][1].setName(VertexNames.NULL.toString());

			vertexes[2][1].setName(vertexes[2][2].getName());
			vertexes[2][2].setName(VertexNames.NULL.toString());

			vertexes[0][0].setName(vertexes[2][0].getName());
			vertexes[2][0].setName(VertexNames.NULL.toString());
		} else {
			vertexes[2][2].setName(vertexes[0][2].getName());
			vertexes[0][2].setName(VertexNames.NULL.toString());

			vertexes[2][0].setName(vertexes[2][1].getName());
			vertexes[2][1].setName(VertexNames.NULL.toString());

			vertexes[0][1].setName(vertexes[0][0].getName());
			vertexes[0][0].setName(VertexNames.NULL.toString());
		}
	}

	public static void rotateVertexesCounterClockwise(Vertex[][] vertexes) {
		if (!vertexes[0][1].getName().isEmpty() && !vertexes[0][1].getName().equals(VertexNames.NULL.toString())) {
			vertexes[0][0].setName(vertexes[0][1].getName());
			vertexes[0][1].setName(VertexNames.NULL.toString());

			vertexes[0][2].setName(vertexes[2][2].getName());
			vertexes[2][2].setName(VertexNames.NULL.toString());

			vertexes[2][1].setName(vertexes[2][0].getName());
			vertexes[2][0].setName(VertexNames.NULL.toString());
		} else {
			vertexes[0][1].setName(vertexes[0][2].getName());
			vertexes[0][2].setName(VertexNames.NULL.toString());

			vertexes[2][2].setName(vertexes[2][1].getName());
			vertexes[2][1].setName(VertexNames.NULL.toString());

			vertexes[2][0].setName(vertexes[0][0].getName());
			vertexes[0][0].setName(VertexNames.NULL.toString());
		}

	}
}
