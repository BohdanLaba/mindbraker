package com.ex.mindbraker.models;

import java.util.Arrays;
import java.util.Deque;

public class Triangle {
	//TODO add direction  - 1,2,3,4,5,6 (same as degree) - beam from the mainVertex
	public static enum TriangleType {
		ZERO_CONCAVE, ONE_CONCAVE, TWO_CONCAVE;
	}

	private Rib ribs[] = new Rib[3];
	private TriangleType type;
	private String name;
	private Deque<Vertex> innerVertexs;
	
	
	public Triangle(Rib ribs[], TriangleType type, String name) {
		this.ribs = ribs;
		this.type = type;
		this.name = name;
	}

	public Rib[] getRibs() {
		return ribs;
	}

	public void setRibs(Rib[] ribs) {
		this.ribs = ribs;
	}

	public TriangleType getType() {
		return type;
	}

	public void setType(TriangleType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Deque<Vertex> getInnerVertexs() {
		return innerVertexs;
	}

	public void setInnerVertexs(Deque<Vertex> innerVertexs) {
		this.innerVertexs = innerVertexs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(ribs);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Triangle other = (Triangle) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(ribs, other.ribs))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
