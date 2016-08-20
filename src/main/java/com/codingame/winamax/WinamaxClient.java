package com.codingame.winamax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WinamaxClient {
	private static final List<String> DECK = Arrays.asList(new String[] { "2",
			"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" });

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		List<String> player1 = new ArrayList<>();
		List<String> player2 = new ArrayList<>();
		int n = in.nextInt(); // the number of cards for player 1
		for (int i = 0; i < n; i++) {
			String cardp1 = in.next(); // the n cards of player 1
			if (cardp1.length() > 1) {
				if (cardp1.length() == 3) {
					cardp1 = cardp1.substring(0, 2);

				} else {

					cardp1 = cardp1.substring(0, 1);
				}
			}
			player1.add(cardp1);
		}
		int m = in.nextInt(); // the number of cards for player 2
		for (int i = 0; i < m; i++) {
			String cardp2 = in.next(); // the m cards of player 2
			if (cardp2.length() == 3) {
				cardp2 = cardp2.substring(0, 2);

			} else {

				cardp2 = cardp2.substring(0, 1);
			}
			player2.add(cardp2);
		}
		System.err.println("Debug messages... player1:" + player1);
		System.err.println("Debug messages... player2:" + player2);
		String winningString = play(player1, player2);
		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");

		System.out.println(winningString);
	}

	public static String play(List<String> p1, List<String> p2) {
		int roundCounter = 0;
		String winner = "";
		while (p1.size() > 0 && p2.size() > 0) {
			// System.out.println("Debug messages... player1:" + p1);
			// System.out.println("Debug messages... player2:" + p2);
			String player1Card = p1.get(0);
			p1.remove(0);
			String player2Card = p2.get(0);
			p2.remove(0);
			roundCounter++;
			// System.out.println("counter: " + roundCounter);
			int roundWinner = winner(player1Card, player2Card);
			// battle
			List<String> tmpHand = null;
			if (roundWinner == 0) {
				try {

					BO bo = battle(p1, p2, null, player1Card, null);
					roundWinner = bo.getRoundWinner();
					tmpHand = bo.getTmpHand();
				} catch (IndexOutOfBoundsException ae) {
					winner = "PAT";
				}

			}
			if (roundWinner == 1) {
				if (tmpHand != null) {
					p1.addAll(tmpHand);
				} else {

					p1.add(p1.size(), player1Card);
					p1.add(p1.size(), player2Card);
				}
				winner = "1";
			} else if (roundWinner == 2) {
				if (tmpHand != null) {
					p2.addAll(tmpHand);
				} else {

					p2.add(p2.size(), player1Card);
					p2.add(p2.size(), player2Card);
				}
				winner = "2";
			}
		}

		if (winner != "PAT") {

			return winner + " " + roundCounter;
		} else {
			return winner;
		}
	}

	private static int winner(String card1, String card2) {
		int card1Value = DECK.indexOf(card1);
		int card2Value = DECK.indexOf(card2);
		if (card1Value < card2Value) {
			return 2;
		} else if (card1Value > card2Value) {
			return 1;
		} else {
			return 0;
		}

	}

	private static BO battle(final List<String> p1, final List<String> p2,
			List<String> tmpHand, String battleCard, List<String> secondTmpHand) {
		BO bo = new BO();
		if (tmpHand == null) {
			tmpHand = new ArrayList<String>();
		}
		if (secondTmpHand == null) {
			secondTmpHand = new ArrayList<String>();
		}
		tmpHand.add(battleCard);
		if (p1.size() >= 1) {

			tmpHand.add(p1.get(0));
		}

		if (p1.size() >= 2) {

			tmpHand.add(p1.get(1));
		}
		if (p1.size() >= 3) {

			tmpHand.add(p1.get(2));
		}

		secondTmpHand.add(battleCard);

		if (p2.size() >= 1) {

			secondTmpHand.add(p2.get(0));
		}
		if (p2.size() >= 2) {

			secondTmpHand.add(p2.get(1));
		}
		if (p2.size() >= 3) {

			secondTmpHand.add(p2.get(2));
		}

		// remove 1srt 3 cards
		if (p1.size() >= 1) {
			p1.remove(0);
		}
		if (p1.size() >= 1) {
			p1.remove(0);
		}
		if (p1.size() >= 1) {
			p1.remove(0);
		}
		if (p2.size() >= 1) {

			p2.remove(0);
		}
		if (p2.size() >= 1) {

			p2.remove(0);
		}
		if (p2.size() >= 1) {

			p2.remove(0);
		}
		// play another round

		int roundWinner = winner(p1.get(0), p2.get(0));
		if (roundWinner == 0) {
			battleCard = p1.get(0);
			// removing new battleCard
			p1.remove(0);
			p2.remove(0);
			bo = battle(p1, p2, tmpHand, battleCard, secondTmpHand);
		} else {
			bo.setRoundWinner(roundWinner);
			// final int indexForInsertingWinningP1Card = tmpHand.size() / 2;
			// tmpHand.add(indexForInsertingWinningP1Card, p1.get(0));
			// tmpHand.add(tmpHand.size(), p2.get(0));
			tmpHand.add(tmpHand.size(), p1.get(0));
			secondTmpHand.add(p2.get(0));
			tmpHand.addAll(secondTmpHand);
			bo.setTmpHand(tmpHand);

			p1.remove(0);
			p2.remove(0);
		}

		return bo;

	}

	private static class BO {
		private int roundWinner;
		private List<String> tmpHand;

		public int getRoundWinner() {
			return roundWinner;
		}

		public void setRoundWinner(int roundWinner) {
			this.roundWinner = roundWinner;
		}

		public List<String> getTmpHand() {
			return tmpHand;
		}

		public void setTmpHand(List<String> tmpHand) {
			this.tmpHand = tmpHand;
		}
	}
}
