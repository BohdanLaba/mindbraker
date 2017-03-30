package com.ex.mindbraker.service;

import com.ex.mindbraker.models.Circle;
import com.ex.mindbraker.models.Triangle;

public class Printer {
	public static void printTriangleStatus(Triangle[][] triangles) {
		for (int i = 0; i < triangles.length; i++) {
			for (int j = 0; j < triangles[i].length; j++) {
				if (triangles[i][j] != null) {
					System.out.print(triangles[i][j].toString() + " ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}

	public static void printAllCircles(Circle circleA, Circle circleB, Circle circleC) {
		System.out.println(" * " + circleB.getArray()[0][0].getName() + " " + circleB.getArray()[0][1].getName() + " "
				+ circleB.getArray()[0][2].getName() + " * ");
		System.out.println(circleA.getArray()[0][0].getName() + " " + circleA.getArray()[0][1].getName() + " "
				+ circleA.getArray()[0][2].getName() + " " + circleC.getArray()[0][1].getName() + " "
				+ circleC.getArray()[0][2].getName());
		System.out.println(circleA.getArray()[1][0].getName() + " " + circleA.getArray()[1][1].getName() + " "
				+ circleA.getArray()[1][2].getName() + " " + circleC.getArray()[1][1].getName() + " "
				+ circleC.getArray()[1][2].getName());
	}
}
