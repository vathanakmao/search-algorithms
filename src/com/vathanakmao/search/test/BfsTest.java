package com.vathanakmao.search.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vathanakmao.search.BFS;
import com.vathanakmao.search.Graph;

public class BfsTest {

	public static void main(String[] args) {
		
		// Vertices
		List<String> vertices = new ArrayList<String>();
		vertices.add("A");
		vertices.add("B");
		vertices.add("C");
		vertices.add("D");
		vertices.add("E");
		vertices.add("F");
		vertices.add("G");
		vertices.add("H");
		
		// Edges
		Map<String, List<String>> edges = new HashMap<String, List<String>>();
		edges.put("A", Arrays.asList("B", "C", "D"));
		
		edges.put("B", Arrays.asList("A", "E", "F"));
		edges.put("E", Arrays.asList("B"));
		edges.put("F", Arrays.asList("B"));
		
		edges.put("C", Arrays.asList("A", "G"));
		edges.put("G", Arrays.asList("C"));
		
		edges.put("D", Arrays.asList("A", "H"));
		edges.put("H", Arrays.asList("D"));
		
		// Graph
		Graph graph = new Graph(vertices, edges);
		
		String init = "A";
		String goal = "H";
		BFS algorith = new BFS(graph);
		List<String> paths = algorith.search(init, goal);
		System.out.println(paths);
	}
	
	public static void println(String message, Object[] arr) {
		System.out.print(message);
		if (arr != null) {
			for (Object obj : arr) {
				System.out.print(obj + " ");
			}
		}
		System.out.println();
	}
}
