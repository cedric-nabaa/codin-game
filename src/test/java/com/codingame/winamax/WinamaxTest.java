package com.codingame.winamax;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class WinamaxTest {
	@Test
	public void should_return_1_when_3_cards() {
		Stack<String> player1 = new Stack<>();
		player1.push("A");
		player1.push("K");
		player1.push("Q");
		Stack<String> player2 = new Stack<>();
		player2.push("K");
		player2.push("Q");
		player2.push("J");

		Assertions.assertThat(WinamaxClient.play(player1, player2)).isEqualTo(
				"1 3");
	}

	@Test
	public void should_return_2_26_when_26_cards() {
		Stack<String> player1 = new Stack<>();
		Stack<String> player2 = new Stack<>();
		// 5, 3, 2, 7, 8, 7, 5, 5, 6, 5, 4, 6, 6, 3, 3, 7, 4, 4, 7, 4, 2, 6, 8,
		// 3, 2, 2]
		player1.push("5");
		player1.push("3");
		player1.push("2");
		player1.push("7");
		player1.push("8");
		player1.push("7");
		player1.push("5");
		player1.push("5");
		player1.push("6");
		player1.push("5");
		player1.push("4");
		player1.push("6");
		player1.push("6");
		player1.push("3");
		player1.push("3");
		player1.push("7");
		player1.push("4");
		player1.push("4");
		player1.push("7");
		player1.push("4");
		player1.push("2");
		player1.push("6");
		player1.push("8");
		player1.push("3");
		player1.push("2");
		player1.push("2");

		// player2:[A, 9, K, K, K, K, 1, 1, 9, Q, J, 1, 8, Q, J, A, J, A, Q, A,
		// J, 1, 9, 8, Q, 9]

		player2.push("A");
		player2.push("9");
		player2.push("K");
		player2.push("K");
		player2.push("K");
		player2.push("K");
		player2.push("10");
		player2.push("10");
		player2.push("10");
		player2.push("9");
		player2.push("Q");
		player2.push("J");
		player2.push("10");
		player2.push("8");
		player2.push("Q");
		player2.push("J");
		player2.push("A");
		player2.push("J");
		player2.push("A");
		player2.push("Q");
		player2.push("A");
		player2.push("J");
		player2.push("10");
		player2.push("9");
		player2.push("8");
		player2.push("Q");
		player2.push("9");

		Assertions.assertThat(WinamaxClient.play(player1, player2)).isEqualTo(
				"2 26");
	}

	@Test
	public void should_return_2_56_when_26_cards_medium_length() {
		Stack<String> player1 = new Stack<>();
		Stack<String> player2 = new Stack<>();
		final String[] player1cards = new String[] { "6", "7", "6", "Q", "7",
				"8", "6", "5", "6", "Q", "4", "3", "7", "3", "4", "5", "Q",
				"5", "3", "3", "8", "4", "4", "Q", "5", "7" };

		player1.addAll(Lists.newArrayList(player1cards));
		final String[] player2cards = new String[] { "J", "A", "K", "A", "9",
				"2", "2", "J", "10", "K", "10", "J", "J", "9", "9", "K", "A",
				"K", "10", "8", "2", "10", "8", "A", "2", "9" };
		player2.addAll(Lists.newArrayList(player2cards));

		Assertions.assertThat(WinamaxClient.play(player1, player2)).isEqualTo(
				"2 56");
	}

	@Test
	public void should_return_2_2_when_battle() {
		Stack<String> player1 = new Stack<>();
		Stack<String> player2 = new Stack<>();
		// player1:[8, K, A, Q, 2]
		// player2:[8, 2, 3, 4, 3]
		final String[] player1cards = new String[] { "8", "K", "A", "Q", "2" };

		player1.addAll(Lists.newArrayList(player1cards));
		final String[] player2cards = new String[] { "8", "2", "3", "4", "3" };
		player2.addAll(Lists.newArrayList(player2cards));

		Assertions.assertThat(WinamaxClient.play(player1, player2)).isEqualTo(
				"2 1");
	}

	@Test
	public void should_return_1_52_when_one_game_one_battle() {
		Stack<String> player1 = new Stack<>();
		Stack<String> player2 = new Stack<>();
		// player1:[10, K, 6, 10, 8, A, Q, 3, 7, K, 9, 2, J, K, 3, 2, Q, A, J,
		// 7, K, 10, 4, A, 5, 5]
		final String[] p1 = new String[] { "10", "K", "6", "10", "8", "A", "Q",
				"3", "7", "K", "9", "2", "J", "K", "3", "2", "Q", "A", "J",
				"7", "K", "10", "4", "A", "5", "5" };
		// player2:[2, 9, 8, 4, 5, A, J, Q, 7, 5, 4, 6, 6, Q, 9, 10, 4, J, 6, 3,
		// 8, 3, 7, 9, 8, 2]
		final String[] p2 = new String[] { "2", "9", "8", "4", "5", "A", "J",
				"Q", "7", "5", "4", "6", "6", "Q", "9", "10", "4", "J", "6",
				"3", "8", "3", "7", "9", "8", "2" };
		player1.addAll(Lists.newArrayList(p1));
		player2.addAll(Lists.newArrayList(p2));
		Assertions.assertThat(WinamaxClient.play(player1, player2)).isEqualTo(
				"1 52");
	}

	@Test
	public void should_return_2_1_when_2_chained_battle() {
		// player1:[8, K, A, Q, 3, K, A, Q, 6]
		// player2:[8, 2, 3, 4, 3, 2, 3, 4, 7]
		Stack<String> player1 = new Stack<>();
		Stack<String> player2 = new Stack<>();

		final String[] p1 = new String[] { "8", "K", "A", "Q", "3", "K", "A",
				"Q", "6" };

		final String[] p2 = new String[] { "8", "2", "3", "4", "3", "2", "3",
				"4", "7" };
		player1.addAll(Lists.newArrayList(p1));
		player2.addAll(Lists.newArrayList(p2));
		Assertions.assertThat(WinamaxClient.play(player1, player2)).isEqualTo(
				"2 1");
	}

	@Test
	public void shoud_return_2_1262_when_long_game() {
		// player1:[A, 4, 5, 6, Q, J, 8, 2, 7, J, J, 6, K, Q, 9, 2, 5, 9, 6, 8,
		// A, 4, 2, 2, 7, 8]
		// player2:[10, 4, 6, 3, K, J, 10, A, 5, K, 10, 9, 9, 8, 5, A, 3, 4, K,
		// 7, 3, Q, 10, 3, 7, Q]
		Stack<String> player1 = new Stack<>();
		Stack<String> player2 = new Stack<>();
		final String[] p1 = new String[] { "A", "4", "5", "6", "Q", "J", "8",
				"2", "7", "J", "J", "6", "K", "Q", "9", "2", "5", "9", "6",
				"8", "A", "4", "2", "2", "7", "8" };
		final String[] p2 = new String[] { "10", "4", "6", "3", "K", "J", "10",
				"A", "5", "K", "10", "9", "9", "8", "5", "A", "3", "4", "K",
				"7", "3", "Q", "10", "3", "7", "Q" };
		player1.addAll(Lists.newArrayList(p1));
		player2.addAll(Lists.newArrayList(p2));
		Assertions.assertThat(WinamaxClient.play(player1, player2)).isEqualTo(
				"2 1262");

	}

	@Test
	public void shoud_return_PAT_when_PAT() {
		// player1:[5, 8, 10, 9, 4, 6, Q, 6, 6, 9, 2, 7, A, 5, 7, 9, Q, 4, 3, J,
		// 2, K, 10, Q, 3, 8]
		// player2:[4, J, 8, 10, 5, 7, 3, A, K, 10, J, 6, 2, K, 8, 9, K, 3, A,
		// J, 4, 7, 2, Q, 5, A]
		Stack<String> player1 = new Stack<>();
		Stack<String> player2 = new Stack<>();
		final String[] p1 = new String[] { "5", "8", "10", "9", "4", "6", "Q",
				"6", "6", "9", "2", "7", "A", "5", "7", "9", "Q", "4", "3",
				"J", "2", "K", "10", "Q", "3", "8" };
		final String[] p2 = new String[] { "4", "J", "8", "10", "5", "7", "3",
				"A", "K", "10", "J", "6", "2", "K", "8", "9", "K", "3", "A",
				"J", "4", "7", "2", "Q", "5", "A" };
		player1.addAll(Lists.newArrayList(p1));
		player2.addAll(Lists.newArrayList(p2));
		Assertions.assertThat(WinamaxClient.play(player1, player2)).isEqualTo(
				"PAT");

	}
}
