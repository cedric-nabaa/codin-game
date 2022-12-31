package com.codingame.medium;

import java.util.Arrays;
import java.util.stream.Stream;

public class MayanCalculation {

	private static final int NUMBER_OF_RADIX = 10;

	private static final int RADIX_20 = 20;

	private static final double[] RADIX_POWERS = new double[1000];

	public MayanCalculation() {
		for (int i = 0; i < NUMBER_OF_RADIX; i++) {
			RADIX_POWERS[i] = (Math.pow(RADIX_20, i));
		}
	}

	protected String compute(NumeralOpRepresentation numeralOpRepresentation) {

		String[] numRepresentation = readNumRepresentationSimple(numeralOpRepresentation.getWidth(),
				numeralOpRepresentation.getHeight(), numeralOpRepresentation.getNumRep());

		long firstOperandSingleFormatRepresentation = getSingleNumberFromRep(
				numeralOpRepresentation.getFirstOperandRep(), numeralOpRepresentation.getNumLinesFirstOperand(),
				numRepresentation, numeralOpRepresentation.getHeight());

		long secondOperandSingleFormatRepresentation = getSingleNumberFromRep(
				numeralOpRepresentation.getSecondOperandRep(), numeralOpRepresentation.getNumLinesSecondOperand(),
				numRepresentation, numeralOpRepresentation.getHeight());
		long numb = 0;
		if ("+".equals(numeralOpRepresentation.getOperator())) {
			numb = firstOperandSingleFormatRepresentation + secondOperandSingleFormatRepresentation;
		} else if ("-".equals(numeralOpRepresentation.getOperator())) {
			numb = firstOperandSingleFormatRepresentation - secondOperandSingleFormatRepresentation;
		} else if ("*".equals(numeralOpRepresentation.getOperator())) {
			numb = firstOperandSingleFormatRepresentation * secondOperandSingleFormatRepresentation;
		} else if ("/".equals(numeralOpRepresentation.getOperator())) {
			numb = firstOperandSingleFormatRepresentation / secondOperandSingleFormatRepresentation;
		}
		return convertFromDecimalToBaseTwentyRep(numb, numRepresentation);
	}

	protected String[] readNumRepresentationSimple(int width, int height, String numRep) {
		String[] arr = new String[20];
		Arrays.fill(arr, "");
		Stream<String> lines = numRep.lines();


		final int[] k = new int[] { 0 };

		lines.forEach((line) -> {
			String rep = "";
			for (int i = 0; i <= (RADIX_20 * width) - 1; i++) {
				if (i >= width && i % width == 0) {
					if (k[0] < height - 1) {
						rep += "\n";
					}
					int idx = (i / width) - 1;
					arr[idx] += rep;
					rep = String.valueOf(line.charAt(i));
				} else {
					rep += line.charAt(i);
				}
			}
			k[0]++;
		});
		if (k[0] == 1) {
			arr[arr.length - 1] = String.valueOf(numRep.charAt(arr.length - 1));
		}
		return arr;
	}

	protected long getSingleNumberFromRep(String singleRep, int singleHeight, String[] values, int height) {
		int numberOfNumbers = singleHeight / height;
		String[] complexNumberRepArr = getComplexNumberRep(singleRep, height, numberOfNumbers);
		long num = 0;
		for (int i = 0; i < complexNumberRepArr.length; i++) {

			String complexNumberRep = complexNumberRepArr[i].substring(0, complexNumberRepArr[i].length() - 1);
			for (int j = 0; j < values.length; j++) {
				if (complexNumberRep.equals(values[j])) {
					int power = complexNumberRepArr.length - 1 - i;
					num += j * Math.pow(RADIX_20, power);
				}
			}
		}

		return num;
	}

	protected String[] getComplexNumberRep(String singleRep, int height, int numberOfNumbers) {
		String[] rep = new String[numberOfNumbers];
		Arrays.fill(rep, "");
		int[] lineNumber = new int[] { 0 };
		int[] number = new int[] { 0 };
		singleRep.lines().forEach((line) -> {
			if (lineNumber[0] >= height && lineNumber[0] % height == 0) {
				number[0]++;
			}
			rep[number[0]] += line + "\n";
			lineNumber[0]++;
		});
		return rep;
	}

	protected String convertFromDecimalToBaseTwentyRep(long number, String[] values) {
		Integer[] arr = new Integer[NUMBER_OF_RADIX];
		Arrays.fill(arr, 0);
		Integer[] convertFromDecimalToBaseTwenty = convertFromDecimalToBaseTwenty(number, arr);

		int idx = -1;
		boolean isDiffFromZero = false;
		for (int i = 0; i < convertFromDecimalToBaseTwenty.length; i++) {
			if (convertFromDecimalToBaseTwenty[i] > 0) {
				idx = i;
				isDiffFromZero = true;
			}
		}
		String rep = "";
		if (isDiffFromZero) {
			Integer[] formatedArr = new Integer[idx + 1];
			System.arraycopy(convertFromDecimalToBaseTwenty, 0, formatedArr, 0, idx + 1);
			for (int i = formatedArr.length - 1; i >= 0; i--) {
				if (i > 0) {
					rep += values[formatedArr[i]] + "\n";
				} else {
					rep += values[formatedArr[i]];
				}
			}
		} else {
			rep = values[0];
		}
		return rep;
	}

	protected Integer[] convertFromDecimalToBaseTwenty(double number, Integer[] arr) {
		if (number == 0) {
			return arr;
		} else {
			for (int i = 0; i < RADIX_POWERS.length - 1; i++) {
				if (RADIX_POWERS[i] <= number && number < RADIX_POWERS[i + 1]) {
					int div = (int) (number / RADIX_POWERS[i]);
					arr[i] = div;
					return convertFromDecimalToBaseTwenty(number - (RADIX_POWERS[i] * div), arr);
				}
			}
		}
		return null;
	}

	protected static class NumeralOpRepresentation {

		private final int width;
		private final int height;
		private final String numRep;
		private final int numLinesFirstOperand;
		private final String firstOperandRep;
		private final int numLinesSecondOperand;
		private final String secondOperandRep;
		private final String operator;

		public NumeralOpRepresentation(int width, int height, String numRep, int numLinesFirstOperand,
				String firstOperandRep, int numLinesSecondOperand, String secondOperandRep, String operator) {
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

		public String getOperator() {
			return operator;
		}

		@Override
		public String toString() {
			return "NumeralOpRepresentation [width=" + width + ", height=" + height + ", numRep=" + numRep
					+ ", numLinesFirstOperand=" + numLinesFirstOperand + ", firstOperandRep=" + firstOperandRep
					+ ", numLinesSecondOperand=" + numLinesSecondOperand + ", secondOperandRep=" + secondOperandRep
					+ ", operator=" + operator + "]";
		}

	}
}
