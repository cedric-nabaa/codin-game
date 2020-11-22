package com.codingame.medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class DwarfsStandingOnTheShouldersOfGiants {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // the number of relationships of influence
		int[][] arr = new int[n][];
		for (int i = 0; i < n; i++) {
			int x = in.nextInt(); // a relationship of influence between two people (x influences y)
			int y = in.nextInt();
			arr[i] = new int[] { x, y };
		}
		int max = getMax(arr);

		System.out.println(max);
	}

	protected static int getMax(int[][] arr) {
		Set<LinkedList<Integer>> graph = addToGraph(arr);

		int max = getMax(graph);
		return max;
	}

	private static int getMax(Set<LinkedList<Integer>> graph) {
		int max = 0;

		Iterator<LinkedList<Integer>> iterator = graph.iterator();

		while (iterator.hasNext()) {
			LinkedList<Integer> next = iterator.next();
			if (max < next.size()) {
				max = next.size();
			}
		}
		return max;
	}

	protected static Set<LinkedList<Integer>> addToGraph(int[][] arr) {
		Set<LinkedList<Integer>> graph = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			final int[] item = arr[i];
			int x = item[0];
			int y = item[1];
			boolean added = false;
			for (LinkedList<Integer> chain : graph) {
				if (chain.getLast().equals(x)) {
					chain.add(y);
					added = true;
				}
			}
			if (!added) {
				LinkedList<Integer> newChain = new LinkedList<>();
				newChain.add(x);
				newChain.add(y);
				boolean addedAgain = false;
				for (LinkedList<Integer> existingChain : graph) {
					if (existingChain.getFirst().equals(y)) {
						existingChain.addFirst(x);
						addedAgain = true;
					}
				}
				if (!addedAgain) {
					graph.add(newChain);
				}
			}
		}
		return graph;

	}

}
