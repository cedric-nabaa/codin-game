package com.codingame.stockexchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockExchange {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> input = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int v = in.nextInt();
			input.add(v);

		}
		int biggestLost = calculateBiggestLost(input);
		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");
		if (biggestLost != 0) {
			System.out.println("-" + biggestLost);
		} else {
			System.out.println(biggestLost);
		}
	}

	// find the difference until finding a bigger number then continuing with
	// the bigger number
	public static int calculateBiggestLost(List<Integer> input) {
		int currentBiggestLost = 0;
		for (int i = 0; i < input.size(); i++) {
			for (int j = i + 1; j < input.size(); j++) {
				if (input.get(i) > input.get(j)) {
					int loss = input.get(i) - input.get(j);
					if (currentBiggestLost < loss) {
						currentBiggestLost = loss;
					}
				} else {
					break;
				}
			}
		}
		return currentBiggestLost;
	}
}
