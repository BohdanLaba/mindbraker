package com.ex.mindbraker.service;

import java.util.Date;
import java.util.Deque;
import java.util.Random;

import com.ex.mindbraker.models.Circle;
import com.ex.mindbraker.models.Triangle;
import com.ex.mindbraker.models.Vertex;

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
	
	public static  Deque<Vertex> rotateVertexes(Deque<Vertex> vertexes) {
		Vertex lastVertex = vertexes.pollLast();
		vertexes.push(lastVertex);
		return vertexes;
	}
	
	public static
}
