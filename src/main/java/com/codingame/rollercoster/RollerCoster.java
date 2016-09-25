package com.codingame.rollercoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RollerCoster {
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
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numberOfGroups; i++) {
			int numberOfPersons = in.nextInt();
			list.add(numberOfPersons);
		}
		final long totalReturn = calculateReturn(numberOfPlaces, numberOfRounds, list);
		System.out.println(totalReturn);
	}

	protected static long calculateReturn(final int numberOfPlaces, final int numberOfRounds,
			final List<Integer> list) {
		long finalReturn = 0L;
		long index = 0;
		for (int i = 0; i < numberOfRounds; i++) {
			long arr[] = getReturnForOneRoundList(numberOfPlaces, list, index);
			long singeReturn = arr[0];
			index = arr[1];
			finalReturn += singeReturn;
		}
		return finalReturn;
	}

	private static long[] getReturnForOneRoundList(final int numberOfPlaces, final List<Integer> queue, long index) {
		final int numberOfGroups = queue.size();
		int remainingPlaces = numberOfPlaces;
		long returnForOneRound = 0L;
		long newIndex = 0;
		boolean found = false;
		for (long i = index; i < numberOfGroups; i++) {

			final long groupSize = queue.get((int) (i));

			if (remainingPlaces < groupSize) {
				found = true;
				newIndex = i;
				break;

			} else {
				remainingPlaces -= groupSize;
				returnForOneRound += groupSize;
			}
		}
		if (found == false) {
			for (long i = 0; i < index; i++) {
				final long groupSize = queue.get((int) (i));
				if (remainingPlaces < groupSize) {
					newIndex = i;
					break;
				} else {
					remainingPlaces -= groupSize;
					returnForOneRound += groupSize;
				}
			}
		}
		return new long[] { returnForOneRound, newIndex };
	}
}
