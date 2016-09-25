package com.codingame.rollercoster;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RollerCosterWIthPerfIssue {
	public static void main(String args[]) {
		/*
		 * The attraction contains a limited number L of places. The attraction
		 * can only function C number of times per day. The queue contains a
		 * number N of groups. Each group contains a number Pi of people.
		 * Scanner in = new Scanner(System.in);
		 * 
		 * 
		 */
		final Scanner in = new Scanner(System.in);
		final int numberOfPlaces = in.nextInt();
		final int numberOfRounds = in.nextInt();
		final int numberOfGroups = in.nextInt();
		final Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numberOfGroups; i++) {
			int numberOfPersons = in.nextInt();
			queue.add(numberOfPersons);
		}
		final long totalReturn = calculateReturn(numberOfPlaces, numberOfRounds, queue);
		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");
		System.out.println(totalReturn);
	}

	protected static long calculateReturn(final int numberOfPlaces, final int numberOfRounds,
			final Queue<Integer> queue) {
		long finalReturn = 0L;
		for (int i = 0; i < numberOfRounds; i++) {
			finalReturn += getReturnForOneRound(numberOfPlaces, queue);
		}
		return finalReturn;
	}

	private static long getReturnForOneRound(final int numberOfPlaces, final Queue<Integer> queue) {
		final int numberOfGroups = queue.size();
		int remainingPlaces = numberOfPlaces;
		long returnForOneRound = 0L;
		for (int i = 0; i < numberOfGroups; i++) {
			final int groupSize = queue.peek();
			if (remainingPlaces < groupSize) {
				break;
			} else {
				queue.poll();
				remainingPlaces -= groupSize;
				returnForOneRound += groupSize;
				queue.add(groupSize);
			}
		}
		return returnForOneRound;
	}

}
