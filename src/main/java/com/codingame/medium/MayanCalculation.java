package com.codingame.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MayanCalculation {

	private static final int RADIX_20 = 20;

	protected String compute(NumeralOpRepresentation numeralOpRepresentation) {

		String[][] numRepresentation = readNumRepresentation(numeralOpRepresentation.getWidth(),
				numeralOpRepresentation.getHeight(), numeralOpRepresentation.getNumRep());
		Map<String, Integer> computedBase = computeBase(numRepresentation, numeralOpRepresentation.getHeight());
		return "";
	}

	protected Map<String, Integer> computeBase(String[][] numRepresentation, int height) {
		final Map<String, Integer> mayanToIn = new HashMap<>(RADIX_20);

		for (int i = 0; i < RADIX_20; i++) {
			String num = "";
			for (int j = 0; j < height; j++) {
				num += numRepresentation[j][i];
			}
			mayanToIn.put(num, i);
		}
		return mayanToIn;

	}

	protected String[][] readNumRepresentation(int width, int height, String numRep) {
		String[][] arr = new String[height][20];

		final int[] k = new int[] { 0 };

		Stream<String> lines = numRep.lines();
		lines.forEach((line) -> {
			String rep = "";
			for (int i = 0; i <= (RADIX_20 * width) - 1; i++) {
				if (i >= width && i % width == 0) {
					if (k[0] < height - 1) {
						rep += "\n";
					}
					int idx = (i / width) - 1;
					arr[k[0]][idx] = rep;
					rep = String.valueOf(line.charAt(i));
				} else {
					rep += line.charAt(i);
				}
			}
			rep += "\n";
			arr[k[0]][19] = rep;
			k[0]++;
		});
		return arr;
	}

//	protected int getSingleNumberFromRep(String rep, int height) {
//		
//	}

	protected static class NumeralOpRepresentation {

		private final int width;
		private final int height;
		private final String numRep;
		private final int numLinesFirstOperand;
		private final String firstOperandRep;
		private final int numLinesSecondOperand;
		private final String secondOperandRep;
		private final char operator;

		public NumeralOpRepresentation(int width, int height, String numRep, int numLinesFirstOperand,
				String firstOperandRep, int numLinesSecondOperand, String secondOperandRep, char operator) {
			this.width = width;
			this.height = height;
			this.numRep = numRep;
			this.numLinesFirstOperand = numLinesFirstOperand;
			this.firstOperandRep = firstOperandRep;
			this.numLinesSecondOperand = numLinesSecondOperand;
			this.secondOperandRep = secondOperandRep;
			this.operator = operator;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		public String getNumRep() {
			return numRep;
		}

		public int getNumLinesFirstOperand() {
			return numLinesFirstOperand;
		}

		public String getFirstOperandRep() {
			return firstOperandRep;
		}

		public int getNumLinesSecondOperand() {
			return numLinesSecondOperand;
		}

		public String getSecondOperandRep() {
			return secondOperandRep;
		}

		public char getOperator() {
			return operator;
		}

	}
}
