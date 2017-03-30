package com.ex.mindbraker.models;

public class Circle {

	private Triangle[][] array;
	private Vertex mainVertex;

	public Circle(Triangle[][] triangles, Vertex mainVertex) {
		this.array = triangles;
	}

	public Triangle[][] getArray() {
		return array;
	}

	public void setArray(Triangle[][] array) {
		this.array = array;
	}

	public Vertex getMainVertex() {
		return mainVertex;
	}

	public void setMainVertex(Vertex mainVertex) {
		this.mainVertex = mainVertex;
	}

}
