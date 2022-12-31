package com.codingame.rollercoster;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;


public class RollerCosterTest {

	@Test
	// 7 dirham for l=3,c=3,n=4 with groups of 3 1 1 2
	public void should_return_7_for_3_3_4_3112() {
		final List<Integer> list = new ArrayList<>();
		// 3, 1, 1, 2
		list.add(3);
		list.add(1);
		list.add(1);
		list.add(2);

		assertThat(RollerCoster.calculateReturn(3, 3, list)).isEqualTo(7);
	}
	//
	// @Test
	// public void should_return_7_when_7_0() {
	// assertThat(RollerCoster.convertNumberToString(7.0D)).isEqualTo("7");
	// }

	//@Test
	public void testBigNumbers() throws FileNotFoundException {
//		Scanner in = new Scanner(new File("/home/apo/Desktop/test.txt"));
//		final int numberOfPlaces = in.nextInt();
//		final int numberOfRounds = in.nextInt();
//		final int numberOfGroups = in.nextInt();
//		final List<Integer> list = new ArrayList<Integer>();
//		final long startTime = System.currentTimeMillis();
//		System.out.println("starting : " + startTime);
//		for (int i = 0; i < numberOfGroups; i++) {
//			int numberOfPersons = in.nextInt();
//			list.add(numberOfPersons);
//		}
//		final long startingALgoTime = (System.currentTimeMillis() - startTime);
//		System.out.println("starting algo : " + startingALgoTime);
//		final double totalReturn = RollerCoster.calculateReturn(numberOfPlaces, numberOfRounds, list);
//
//		System.out.println("finishing algo : " + (System.currentTimeMillis() - startTime));
//		// Write an action using System.out.println()
//		// To debug: System.err.println("Debug messages...");
//		assertThat(totalReturn).isEqualTo(89744892565569L);
	}
}
