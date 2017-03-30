package com.ex.mindbraker.service;

import com.ex.mindbraker.models.Circle;
import com.ex.mindbraker.models.Rib;
import com.ex.mindbraker.models.Triangle;
import com.ex.mindbraker.models.Triangle.TriangleType;
import com.ex.mindbraker.models.Vertex;
import com.ex.mindbraker.models.Vertex.Importance;

public class CircleConstructor {

	private static final String A_VERTEX = "A";
	private static final String B_VERTEX = "B";
	private static final String C_VERTEX = "C";

	private Triangle[] triangles;// = new Triangle[13];
	private Circle circleA;
	private Circle circleB;
	private Circle circleC;

	private Vertex[] vertexs;
	private Vertex vertexMainA;
	private Vertex vertexMainB;
	private Vertex vertexMainC;

	public CircleConstructor() {
		initVertex();
		initTriangles();
		initCircles();
	}

	public Triangle[] getTriangles() {
		return triangles;
	}

	public void setTriangles(Triangle[] triangles) {
		this.triangles = triangles;
	}

	public Circle getCircleA() {
		return circleA;
	}

	public void setCircleA(Circle circleA) {
		this.circleA = circleA;
	}

	public Circle getCircleB() {
		return circleB;
	}

	public void setCircleB(Circle circleB) {
		this.circleB = circleB;
	}

	public Circle getCircleC() {
		return circleC;
	}

	public void setCircleC(Circle circleC) {
		this.circleC = circleC;
	}

	public Vertex getVertexMainA() {
		return vertexMainA;
	}

	public void setVertexMainA(Vertex vertexMainA) {
		this.vertexMainA = vertexMainA;
	}

	public Vertex getVertexMainB() {
		return vertexMainB;
	}

	public void setVertexMainB(Vertex vertexMainB) {
		this.vertexMainB = vertexMainB;
	}

	public Vertex getVertexMainC() {
		return vertexMainC;
	}

	public void setVertexMainC(Vertex vertexMainC) {
		this.vertexMainC = vertexMainC;
	}

	private void initVertex() {
		vertexMainA = new Vertex(A_VERTEX, Importance.MAIN);
		vertexMainB = new Vertex(B_VERTEX, Importance.MAIN);
		vertexMainC = new Vertex(C_VERTEX, Importance.MAIN);

		Vertex vertex01 = new Vertex("01", Importance.ORDINARY);
		Vertex vertex02 = new Vertex("02", Importance.ORDINARY);

		Vertex vertex03 = new Vertex("03", Importance.ORDINARY);
		Vertex vertex05 = new Vertex("04", Importance.ORDINARY);

		Vertex vertex06 = new Vertex("06", Importance.ORDINARY);
		Vertex vertex09 = new Vertex("09", Importance.ORDINARY);

		Vertex vertex10 = new Vertex("10", Importance.ORDINARY);
		Vertex vertex11 = new Vertex("11", Importance.ORDINARY);
		Vertex vertex12 = new Vertex("12", Importance.ORDINARY);

		vertexs = new Vertex[] { vertex01, vertex02, vertex03, vertexMainB, vertex05, vertex06, vertexMainA,
				vertexMainC, vertex09, vertex10, vertex11, vertex12 };
	}

	// A - left most, B - top, C- rightmost
	private void initTriangles() {
		Triangle triangle1 = createOneConcaveTriangle(vertexMainB, vertexs[2], vertexs[0], "01");
		Triangle triangle2 = createTwoConcaveTriangle(vertexMainB, vertexs[0], vertexs[1], "02");
		Triangle triangle3 = createOneConcaveTriangle(vertexMainB, vertexs[4], vertexs[1], "03");

		Triangle triangle4 = createOneConcaveTriangle(vertexMainA, vertexs[2], vertexs[5], "04");
		Triangle triangle5 = createOneConcaveTriangleM(vertexMainA, vertexMainB, vertexs[2], "05");
		Triangle triangle6 = createCentralTriangle("06");
		Triangle triangle7 = createOneConcaveTriangleM(vertexMainB, vertexMainC, vertexs[4], "07");
		Triangle triangle8 = createOneConcaveTriangle(vertexMainC, vertexs[4], vertexs[8], "08");

		Triangle triangle9 = createTwoConcaveTriangle(vertexMainA, vertexs[5], vertexs[9], "09");
		Triangle triangle10 = createOneConcaveTriangle(vertexMainA, vertexs[10], vertexs[9], "10");
		Triangle triangle11 = createOneConcaveTriangleM(vertexMainA, vertexMainC, vertexs[10], "11");
		Triangle triangle12 = createOneConcaveTriangle(vertexMainC, vertexs[10], vertexs[11], "12");
		Triangle triangle13 = createTwoConcaveTriangle(vertexMainC, vertexs[11], vertexs[8], "13");
		triangles = new Triangle[] { triangle1, triangle2, triangle3, triangle4, triangle5, triangle6, triangle7,
				triangle8, triangle9, triangle10, triangle11, triangle12, triangle13 };
	}

	// TODO implement automatic lookup by main vertex
	private void initCircles() {
		Triangle[][] circleATriangles = new Triangle[2][3];
		Triangle[][] circleBTriangles = new Triangle[2][3];
		Triangle[][] circleCTriangles = new Triangle[2][3];

		circleATriangles[0][0] = triangles[3];
		circleATriangles[0][1] = triangles[4];
		circleATriangles[0][2] = triangles[5];
		circleATriangles[1][0] = triangles[8];
		circleATriangles[1][1] = triangles[9];
		circleATriangles[1][2] = triangles[10];

		circleBTriangles[0][0] = triangles[0];
		circleBTriangles[0][1] = triangles[1];
		circleBTriangles[0][2] = triangles[2];
		circleBTriangles[1][0] = triangles[4];
		circleBTriangles[1][1] = triangles[5];
		circleBTriangles[1][2] = triangles[6];

		circleCTriangles[0][0] = triangles[5];
		circleCTriangles[0][1] = triangles[6];
		circleCTriangles[0][2] = triangles[7];
		circleCTriangles[1][0] = triangles[10];
		circleCTriangles[1][1] = triangles[11];
		circleCTriangles[1][2] = triangles[12];

		circleA = new Circle(circleATriangles, vertexMainA);
		circleB = new Circle(circleBTriangles, vertexMainB);
		circleC = new Circle(circleCTriangles, vertexMainC);
	}

	private Triangle createCentralTriangle(String name) {
		Rib rib1 = new Rib(new Vertex[] { vertexMainA, vertexMainB }, Rib.RibCurve.CONVEX);
		Rib rib2 = new Rib(new Vertex[] { vertexMainB, vertexMainC }, Rib.RibCurve.CONVEX);
		Rib rib3 = new Rib(new Vertex[] { vertexMainC, vertexMainA }, Rib.RibCurve.CONVEX);
		return new Triangle(new Rib[] { rib1, rib2, rib3 }, TriangleType.ZERO_CONCAVE, name);
	}

	private Triangle createOneConcaveTriangle(Vertex mainVertex, Vertex vertex1, Vertex vertex2, String name) {
		Rib rib1 = new Rib(new Vertex[] { mainVertex, vertex1}, Rib.RibCurve.CONCAVE);
		Rib rib2 = new Rib(new Vertex[] { vertex1, vertex2 }, Rib.RibCurve.CONVEX);
		Rib rib3 = new Rib(new Vertex[] { vertex2, mainVertex }, Rib.RibCurve.CONVEX);

		return new Triangle(new Rib[] { rib1, rib2, rib3 }, TriangleType.ONE_CONCAVE, name);
	}

	private Triangle createOneConcaveTriangleM(Vertex mainVertex1, Vertex mainVertex2, Vertex vertex1, String name) {
//		Vertex vertex1 = new Vertex(Util.getNextName(), Importance.ORDINARY);

		Rib rib1 = new Rib(new Vertex[] { mainVertex1, mainVertex2 }, Rib.RibCurve.CONCAVE);
		Rib rib2 = new Rib(new Vertex[] { mainVertex2, vertex1 }, Rib.RibCurve.CONVEX);
		Rib rib3 = new Rib(new Vertex[] { vertex1, mainVertex1 }, Rib.RibCurve.CONVEX);

		return new Triangle(new Rib[] { rib1, rib2, rib3 }, TriangleType.ONE_CONCAVE, name);
	}

	private Triangle createTwoConcaveTriangle(Vertex mainVertex, Vertex vertex1, Vertex vertex2, String name) {
//		Vertex vertex1 = new Vertex(Util.getNextName(), Importance.ORDINARY);
//		Vertex vertex2 = new Vertex(Util.getNextName(), Importance.ORDINARY);

		Rib rib1 = new Rib(new Vertex[] { mainVertex, vertex1 }, Rib.RibCurve.CONCAVE);
		Rib rib2 = new Rib(new Vertex[] { vertex1, vertex2 }, Rib.RibCurve.CONVEX);
		Rib rib3 = new Rib(new Vertex[] { vertex2, mainVertex }, Rib.RibCurve.CONCAVE);

		return new Triangle(new Rib[] { rib1, rib2, rib3 }, TriangleType.TWO_CONCAVE, name);
	}
}
