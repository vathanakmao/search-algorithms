package com.vathanakmao.search;

import java.util.List;
import java.util.Map;

public class Graph<T> {
	private List<T> vertices;
	private Map<T, List<T>> edges;

	public Graph(List<T> vertices, Map<T, List<T>> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}

	public List<T> getVertices() {
		return vertices;
	}

	public void setVertices(List<T> vertices) {
		this.vertices = vertices;
	}

	public Map<T, List<T>> getEdges() {
		return edges;
	}

	public void setEdges(Map<T, List<T>> edges) {
		this.edges = edges;
	}
	
	
}
