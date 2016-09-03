package com.vathanakmao.search.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vathanakmao.search.DFS;
import com.vathanakmao.search.Graph;

public class DfsTest {

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
		
		// Edges
		Map<String, List<String>> edges = new HashMap<String, List<String>>();
		edges.put("E", Arrays.asList("C", "G"));
		edges.put("C", Arrays.asList("E", "A"));
		edges.put("G", Arrays.asList("E", "A"));
		edges.put("A", Arrays.asList("C", "G", "B", "F"));
		edges.put("F", Arrays.asList("A", "D"));
		edges.put("B", Arrays.asList("A", "D"));
		edges.put("D", Arrays.asList("F", "B"));
		
		// Graph
		Graph graph = new Graph(vertices, edges);
		
		String init = "E";
		String goal = "D";
		DFS dfs = new DFS(graph);
		List<String> paths = dfs.search(init, goal);
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
