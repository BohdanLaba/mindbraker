package com.ex.mindbraker.models;

public class Vertex {
	private String name;

	public enum Importance {
		ORDINARY, MAIN
	}

	private Importance importance;

	public Vertex() {
		this.importance = Importance.ORDINARY;
	}

	public Vertex(String name, Importance importance) {
		this.name = name;
		this.importance = importance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Importance getImportance() {
		return importance;
	}

	public void setImportance(Importance pointImportance) {
		this.importance = pointImportance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((importance == null) ? 0 : importance.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Vertex other = (Vertex) obj;
		if (importance != other.importance)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + ", importance=" + importance + "]";
	}

}
