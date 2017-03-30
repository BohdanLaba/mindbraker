package com.ex.mindbraker.models;

import java.util.Arrays;

public class Rib {

	public static enum RibCurve {
		CONVEX, CONCAVE
	}

	private int degree; // 60 120 180 240 300 360
	private RibCurve curve;
	private Vertex[] vertexs = new Vertex[2];

	public Rib(Vertex[] vertexs, RibCurve curve) {
		this.vertexs = vertexs;
		this.curve = curve;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public RibCurve getCurve() {
		return curve;
	}

	public void setCurve(RibCurve curve) {
		this.curve = curve;
	}

	public Vertex[] getVertexs() {
		return vertexs;
	}

	public void setVertexs(Vertex[] vertexs) {
		this.vertexs = vertexs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curve == null) ? 0 : curve.hashCode());
		result = prime * result + degree;
		result = prime * result + Arrays.hashCode(vertexs);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rib other = (Rib) obj;
		if (curve != other.curve)
			return false;
		if (degree != other.degree)
			return false;
		if (!Arrays.equals(vertexs, other.vertexs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rib [degree=" + degree + ", curve=" + curve + ", vertexs=" + Arrays.toString(vertexs) + "]";
	}

	
}
