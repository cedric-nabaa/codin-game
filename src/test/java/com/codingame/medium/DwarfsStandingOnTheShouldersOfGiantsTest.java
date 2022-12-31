package com.codingame.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DwarfsStandingOnTheShouldersOfGiantsTest {

	@Test
	public void should_return_3_for_first_custom_use_case() {

		final int arr[][] = new int[][] { { 1, 2 }, { 1, 3 }, { 3, 4 } };

		Assertions.assertThat(DwarfsStandingOnTheShouldersOfGiants.getMax(arr)).isEqualTo(3);
	}

	@Test
	public void sould_return_4_for_complete_example() {
		final int arr[][] = new int[][] { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 2, 4 }, { 2, 5 }, { 10, 11 }, { 10, 1 },
				{ 10, 3 } };
		Assertions.assertThat(DwarfsStandingOnTheShouldersOfGiants.getMax(arr)).isEqualTo(4);

	}

	@Test
	public void sould_return_3_for_several_mentor_example() {
		final int arr[][] = new int[][] { { 2, 3 }, { 8, 9 }, { 1, 2 }, { 6, 3 } };
		Assertions.assertThat(DwarfsStandingOnTheShouldersOfGiants.getMax(arr)).isEqualTo(3);

	}

}
