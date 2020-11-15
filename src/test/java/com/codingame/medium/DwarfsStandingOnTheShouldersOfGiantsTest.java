package com.codingame.medium;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DwarfsStandingOnTheShouldersOfGiantsTest {

	@Test
	public void should_return_3_for_first_custom_use_case() {

		final int arr[][] = new int[][] { { 1, 2 }, { 1, 3 }, { 3, 4 } };

		Assertions.assertThat(DwarfsStandingOnTheShouldersOfGiants.getMax(arr)).isEqualTo(3);
	}

	@Test
	public void sould_return_4_for_complete_example() {
//		1 2
//		1 3
//		3 4
//		2 4
//		2 5
//		10 11
//		10 1
//		10 3
//		
		final int arr[][] = new int[][] { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 2, 4 }, { 2, 5 }, { 10, 11 }, { 10, 1 },
				{ 10, 3 } };

		Assertions.assertThat(DwarfsStandingOnTheShouldersOfGiants.getMax(arr)).isEqualTo(4);

	}

}
