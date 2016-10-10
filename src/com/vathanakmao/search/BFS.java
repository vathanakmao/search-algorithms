package com.vathanakmao.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.vathanakmao.search.test.DfsTest;

public class BFS<T> {
	private Graph g;

	public BFS() {
		
	}
	
	public BFS(Graph<T> g) {
		this.g = g;
	}
	
	public List<T> search(T init, T goal) {
		List<T> visitedVertices = new ArrayList<T>();	// explored list
		Queue<T> frontiers = new LinkedList<>();
		frontiers.add(init);
		
		boolean goalFound = false;
		Map<T, T> trackbacks = new HashMap<T,T>();
		
		while( !frontiers.isEmpty() ) {
//			System.out.println("Frontiers:  " + frontiers);
			
			// node = peek at the top of the stack
			T prev = frontiers.poll();
			
			// visit the node if it has not been visited
			visitedVertices.add(prev);
			
			// discover the neighbors
			List<T> neighbors = (List<T>) g.getEdges().get(prev);
			T[] sortedNeighbors = (T[]) neighbors.toArray();
			
			// Sort descending order cause, for example, 'G' will be put
			// in the stack (frontiers) first and then 'C' will be popped out first
			// and so chosen as the path instead of 'G'
			Arrays.sort(sortedNeighbors);
//			DfsTest.println("sortedNeighbors: ", sortedNeighbors);
			
			for (int i = 0; i < sortedNeighbors.length; i++) {
				T vertex = sortedNeighbors[i];
				if (!(visitedVertices.contains(vertex) || frontiers.contains(vertex))) {
					frontiers.add(vertex);
					
					trackbacks.put(vertex, prev);
				}
				
				// if goal is found
				if (vertex.equals(goal)) {
					goalFound = true;
					break;
				}
			}
			
			System.out.println("Explored:   " + visitedVertices);
			
			if (goalFound) {
				break;
			}
			
			if (init.equals(goal)) {
				return visitedVertices;
			}
		}
		
		if (!goalFound) {
			System.out.println("Goal node is not reachable from the initial node");
			return Collections.emptyList();
		}
		
//		System.out.println("Trackbacks: " + trackbacks);
		
		List<T> result = new ArrayList<T>();
		result.add(goal);
		T parent = null;
		while (!init.equals(parent)) {
			parent = trackbacks.get(goal);
			result.add(parent);
			goal = parent;
		}
		return result;
	}
}
