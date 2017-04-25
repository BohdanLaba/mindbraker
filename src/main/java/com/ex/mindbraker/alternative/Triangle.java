package com.ex.mindbraker.alternative;

public class Triangle {
	public enum TriangleType {
		ONE_CONVEX, DOUBLE_CONVEX, TRIPPLE_CONVEX, NULL
	}

	private String name;
	private TriangleType triangleType;

	public Triangle(String name, TriangleType triangleType) {
		super();
		this.name = name;
		this.triangleType = triangleType;
	}

	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TriangleType getTriangleType() {
		return triangleType;
	}

	public void setTriangleType(TriangleType triangleType) {
		this.triangleType = triangleType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((triangleType == null) ? 0 : triangleType.hashCode());
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
		if (triangleType != other.triangleType)
			return false;
		return true;
	}

}
