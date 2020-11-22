package com.codingame.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class DwarfsStandingOnTheShouldersOfGiants2 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int numOfConnections = scanner.nextInt();
		int[][] arr = new int[numOfConnections][];

		// Map of Vertexes and Edges for building T(V,E) tree.
		HashMap<Integer, Set<Integer>> graph = new HashMap<>(numOfConnections);

		// Build T(V,E)
		for (int i = 0; i < numOfConnections; ++i) {
			int source = scanner.nextInt();
			int target = scanner.nextInt();
			arr[i] = new int[] { source, target };
			extracted(arr, graph, i);
		}
		// In this puzzle, Number of influences are max tree path + the source vertex
		// (+1).
		System.out.println(maxTreePath(graph) + 1);
	}

	private static void extracted(int[][] arr, HashMap<Integer, Set<Integer>> graph, int i) {
		graph.putIfAbsent(arr[i][0], new HashSet<>());
		graph.get(arr[i][0]).add(arr[i][1]);
	}

	// Get the max Tree path by comparing the max paths from each vertex.
	private static int maxTreePath(final HashMap<Integer, Set<Integer>> tree) {
		final AtomicInteger maxPath = new AtomicInteger(0);

		tree.keySet().forEach(V -> maxPath.set(Math.max(getVertexMaxPath(tree, V), maxPath.get())));

		return maxPath.get();
	}

	// For each vertex get its max Path.
	private static int getVertexMaxPath(final HashMap<Integer, Set<Integer>> tree, final int v) {
		if (!tree.containsKey(v)) {
			return 0;
		}
		Set<Integer> E = tree.get(v);

		final AtomicInteger maxPath = new AtomicInteger(0);

		E.forEach(e -> maxPath.set(Math.max(getVertexMaxPath(tree, e), maxPath.get())));

		return maxPath.incrementAndGet();
	}
}
