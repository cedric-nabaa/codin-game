package com.codingame.medium;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import com.codingame.medium.MayanCalculation.NumeralOpRepresentation;

public class MayanCalculationTest {

	private final MayanCalculation mayanCalculation = new MayanCalculation();

	/*
	 * 4 4
	 * .oo.o...oo..ooo.oooo....o...oo..ooo.oooo....o...oo..ooo.oooo....o...oo..ooo.
	 * oooo o..o................
	 * ____________________________________________________________
	 * .oo.....................................
	 * ________________________________________
	 * ............................................................
	 * ____________________ 4 o... .... .... .... 4 o... .... .... .... +
	 * 
	 */
	@Test
	public void test_simple_addition() {
		String numRep = getSimpleNumberOfRepresentation();

		String firstNumb = "o...\n" + "....\n" + "....\n" + "....";

		String secondNumb = "o...\n" + "....\n" + "....\n" + "....";

		String expectedNumb = "oo..\n" + "....\n" + "....\n" + "....";

		final NumeralOpRepresentation numOpRepresentation = new NumeralOpRepresentation(4, 4, numRep, 4, firstNumb, 4,
				secondNumb, "+");

		assertThat(mayanCalculation.compute(numOpRepresentation)).isEqualTo(expectedNumb);
	}

	/*
	 * 
	 * 4 4
	 * .oo.o...oo..ooo.oooo....o...oo..ooo.oooo....o...oo..ooo.oooo....o...oo..ooo.
	 * oooo o..o................
	 * ____________________________________________________________
	 * .oo.....................................
	 * ________________________________________
	 * ............................................................
	 * ____________________ 4 ooo. ____ ____ ____ 4 ooo. .... .... .... +
	 */

	@Test
	public void test_addition_with_carry() {
		String numRep = getSimpleNumberOfRepresentation();

		String firstNumb = "ooo.\n" + "____\n" + "____\n" + "____";

		String secondNumb = "ooo.\n" + "....\n" + "....\n" + "....";

		String expectedNumb = "o...\n" + "....\n" + "....\n" + "....\n" + "o...\n" + "....\n" + "....\n" + "....";

		final NumeralOpRepresentation numOpRepresentation = new NumeralOpRepresentation(4, 4, numRep, 4, firstNumb, 4,
				secondNumb, "+");

		assertThat(mayanCalculation.compute(numOpRepresentation)).isEqualTo(expectedNumb);

	}

	@Test
	public void test_read_representation_simple() {
		String[] readNumRepresentation = mayanCalculation.readNumRepresentationSimple(4, 4,
				getSimpleNumberOfRepresentation());
		String seventeen = "oo..\n" + "____\n" + "____\n" + "____";
		String firstNumb = "o...\n" + "....\n" + "....\n" + "....";

		assertThat(readNumRepresentation[1]).isEqualTo(firstNumb);
		assertThat(readNumRepresentation[17]).isEqualTo(seventeen);

	}

	@Test
	public void test_get_single_number_from_rep() {

		String twelve = "oo..\n" + "____\n" + "____\n" + "....";
		String zero = ".oo.\n" + "o..o\n" + ".oo.\n" + "....";
		String five = "....\n" + "____\n" + "....\n" + "....";

		String radixTwentyNumb = twelve + "\n" + zero + "\n" + five;

		String[] arrComlexNumber = new String[] { twelve + "\n", zero + "\n", five + "\n" };

		String[] readNumRepresentation = mayanCalculation.readNumRepresentationSimple(4, 4,
				getSimpleNumberOfRepresentation());

		assertThat(mayanCalculation.getComplexNumberRep(radixTwentyNumb, 4, 3)).isEqualTo(arrComlexNumber);

		assertThat(mayanCalculation.getSingleNumberFromRep(radixTwentyNumb, 12, readNumRepresentation, 4))
				.isEqualTo(4805);
	}

	@Test
	public void test_convert_from_decimal_to_base_twenty_rep() {
		String twelve = "oo..\n" + "____\n" + "____\n" + "....";
		String zero = ".oo.\n" + "o..o\n" + ".oo.\n" + "....";
		String five = "....\n" + "____\n" + "....\n" + "....";

		String radixTwentyNumb = twelve + "\n" + zero + "\n" + five;
		String[] readNumRepresentation = mayanCalculation.readNumRepresentationSimple(4, 4,
				getSimpleNumberOfRepresentation());
		assertThat(mayanCalculation.convertFromDecimalToBaseTwentyRep(4805, readNumRepresentation))
				.isEqualTo(radixTwentyNumb);
	}

	@Test
	public void test_convert_from_decimal_to_base_twenty_simple() {
		final Integer[] expected = new Integer[] { 5, 0, 12, 0, 0 };
		Integer[] arr = new Integer[5];
		Arrays.fill(arr, 0);
		assertThat(mayanCalculation.convertFromDecimalToBaseTwenty(4805, arr)).isEqualTo(expected);
	}

	@Test
	public void test_convert_from_decimal_to_base_twenty_carry() {
		final Integer[] expected = new Integer[] { 1, 1, 0, 0, 0 };
		Integer[] arr = new Integer[5];
		Arrays.fill(arr, 0);
		assertThat(mayanCalculation.convertFromDecimalToBaseTwenty(21, arr)).isEqualTo(expected);
	}

	@Test
	public void test_line_length() {
		String s = ".oo.o...oo..ooo.oooo....o...oo..ooo.oooo....o...oo..ooo.oooo....o...oo..ooo.oooo";
		assertThat(s.length()).isEqualTo(80);
	}

	private String getSimpleNumberOfRepresentation() {
		String numRep = ".oo.o...oo..ooo.oooo....o...oo..ooo.oooo....o...oo..ooo.oooo....o...oo..ooo.oooo\n"
				+ "	o..o................____________________________________________________________\n"
				+ "	.oo.....................................________________________________________;\n"
				+ "	............................................................____________________";
		return numRep.replace("\t", "");
	}

	/*
	 * 
	 * class Solution {
	 * 
	 * private static final int NUMBER_OF_RADIX = 5;
	 * 
	 * private static final int RADIX_20 = 20;
	 * 
	 * private static final double[] RADIX_POWERS = new double[1000];
	 * 
	 * public Solution() { for (int i = 0; i < NUMBER_OF_RADIX; i++) {
	 * RADIX_POWERS[i] = (Math.pow(RADIX_20, i)); } }
	 * 
	 * public static void main(String args[]) { Scanner in = new Scanner(System.in);
	 * int L = in.nextInt(); int H = in.nextInt(); String numRep=""; for (int i = 0;
	 * i < H; i++) { numRep += in.next() +"\n"; } int S1 = in.nextInt(); String
	 * firstNumb=""; for (int i = 0; i < S1; i++) { firstNumb += in.next() +"\n"; }
	 * 
	 * System.err.println("first Number: " + firstNumb);
	 * 
	 * int S2 = in.nextInt(); String secondNumb=""; for (int i = 0; i < S2; i++) {
	 * secondNumb += in.next() +"\n"; } String operation = in.next();
	 * 
	 * // Write an answer using System.out.println() // To debug:
	 * System.err.println("Debug messages..."); Solution solution = new Solution();
	 * final NumeralOpRepresentation numOpRepresentation = new
	 * NumeralOpRepresentation(L, H, numRep, S1, firstNumb, S2, secondNumb,
	 * operation); System.err.println("num rep " + numOpRepresentation); String
	 * result= solution.compute(numOpRepresentation); System.out.println(result); }
	 * 
	 * protected String compute(NumeralOpRepresentation numeralOpRepresentation) {
	 * 
	 * String[] numRepresentation =
	 * readNumRepresentationSimple(numeralOpRepresentation.getWidth(),
	 * numeralOpRepresentation.getHeight(), numeralOpRepresentation.getNumRep());
	 * 
	 * int firstOperandSingleFormatRepresentation = getSingleNumberFromRep(
	 * numeralOpRepresentation.getFirstOperandRep(),
	 * numeralOpRepresentation.getNumLinesFirstOperand(), numRepresentation,
	 * numeralOpRepresentation.getHeight());
	 * 
	 * int secondOperandSingleFormatRepresentation = getSingleNumberFromRep(
	 * numeralOpRepresentation.getSecondOperandRep(),
	 * numeralOpRepresentation.getNumLinesSecondOperand(), numRepresentation,
	 * numeralOpRepresentation.getHeight()); int numb = 0; if
	 * ("+".equals(numeralOpRepresentation.getOperator())) { numb =
	 * firstOperandSingleFormatRepresentation +
	 * secondOperandSingleFormatRepresentation; } else if
	 * ("-".equals(numeralOpRepresentation.getOperator())) { numb =
	 * firstOperandSingleFormatRepresentation -
	 * secondOperandSingleFormatRepresentation; } else if
	 * ("*".equals(numeralOpRepresentation.getOperator())) { numb =
	 * firstOperandSingleFormatRepresentation *
	 * secondOperandSingleFormatRepresentation; } else if
	 * ("/".equals(numeralOpRepresentation.getOperator())) { numb =
	 * firstOperandSingleFormatRepresentation /
	 * secondOperandSingleFormatRepresentation; } return
	 * convertFromDecimalToBaseTwentyRep(numb, numRepresentation); }
	 * 
	 * protected String[] readNumRepresentationSimple(int width, int height, String
	 * numRep) { String[] arr = new String[20]; Arrays.fill(arr, ""); Stream<String>
	 * lines = numRep.lines();
	 * 
	 * final int[] k = new int[] { 0 };
	 * 
	 * lines.forEach((line) -> { String rep = ""; for (int i = 0; i <= (RADIX_20 *
	 * width) - 1; i++) { if (i >= width && i % width == 0) { if (k[0] < height - 1)
	 * { rep += "\n"; } int idx = (i / width) - 1; arr[idx] += rep; rep =
	 * String.valueOf(line.charAt(i)); } else { rep += line.charAt(i); } } k[0]++;
	 * }); return arr; }
	 * 
	 * protected int getSingleNumberFromRep(String singleRep, int singleHeight,
	 * String[] values, int height) { int numberOfNumbers = singleHeight / height;
	 * String[] complexNumberRepArr = getComplexNumberRep(singleRep, height,
	 * numberOfNumbers); int num = 0; for (int i = 0; i <
	 * complexNumberRepArr.length; i++) {
	 * 
	 * String complexNumberRep = complexNumberRepArr[i].substring(0,
	 * complexNumberRepArr[i].length() - 1); for (int j = 0; j < values.length; j++)
	 * { if (complexNumberRep.equals(values[j])) { int power =
	 * complexNumberRepArr.length - 1 - i; num += j * Math.pow(RADIX_20, power); } }
	 * }
	 * 
	 * return num; }
	 * 
	 * protected String[] getComplexNumberRep(String singleRep, int height, int
	 * numberOfNumbers) { String[] rep = new String[numberOfNumbers];
	 * Arrays.fill(rep, ""); int[] lineNumber = new int[] { 0 }; int[] number = new
	 * int[] { 0 }; singleRep.lines().forEach((line) -> { if (lineNumber[0] >=
	 * height && lineNumber[0] % height == 0) { number[0]++; } rep[number[0]] +=
	 * line + "\n"; lineNumber[0]++; }); return rep; }
	 * 
	 * protected String convertFromDecimalToBaseTwentyRep(int number, String[]
	 * values) { Integer[] arr = new Integer[NUMBER_OF_RADIX]; Arrays.fill(arr, 0);
	 * Integer[] convertFromDecimalToBaseTwenty =
	 * convertFromDecimalToBaseTwenty(number, arr);
	 * 
	 * int idx = -1; for (int i = 0; i < convertFromDecimalToBaseTwenty.length; i++)
	 * { if (convertFromDecimalToBaseTwenty[i] > 0) { idx = i; } } Integer[]
	 * formatedArr = new Integer[idx + 1];
	 * System.arraycopy(convertFromDecimalToBaseTwenty, 0, formatedArr, 0, idx + 1);
	 * ; String rep = ""; for (int i = formatedArr.length - 1; i >= 0; i--) { if (i
	 * > 0) { rep += values[formatedArr[i]] + "\n"; } else { rep +=
	 * values[formatedArr[i]]; } } return rep; }
	 * 
	 * protected Integer[] convertFromDecimalToBaseTwenty(double number, Integer[]
	 * arr) { if (number == 0) { return arr; } else { for (int i = 0; i <
	 * RADIX_POWERS.length - 1; i++) { if (RADIX_POWERS[i] < number && number <
	 * RADIX_POWERS[i + 1]) { int div = (int) (number / RADIX_POWERS[i]); arr[i] =
	 * div; return convertFromDecimalToBaseTwenty(number - (RADIX_POWERS[i] * div),
	 * arr); } } } return null; }
	 * 
	 * protected static class NumeralOpRepresentation {
	 * 
	 * private final int width; private final int height; private final String
	 * numRep; private final int numLinesFirstOperand; private final String
	 * firstOperandRep; private final int numLinesSecondOperand; private final
	 * String secondOperandRep; private final String operator;
	 * 
	 * public NumeralOpRepresentation(int width, int height, String numRep, int
	 * numLinesFirstOperand, String firstOperandRep, int numLinesSecondOperand,
	 * String secondOperandRep, String operator) { this.width = width; this.height =
	 * height; this.numRep = numRep; this.numLinesFirstOperand =
	 * numLinesFirstOperand; this.firstOperandRep = firstOperandRep;
	 * this.numLinesSecondOperand = numLinesSecondOperand; this.secondOperandRep =
	 * secondOperandRep; this.operator = operator; }
	 * 
	 * public int getWidth() { return width; }
	 * 
	 * public int getHeight() { return height; }
	 * 
	 * public String getNumRep() { return numRep; }
	 * 
	 * public int getNumLinesFirstOperand() { return numLinesFirstOperand; }
	 * 
	 * public String getFirstOperandRep() { return firstOperandRep; }
	 * 
	 * public int getNumLinesSecondOperand() { return numLinesSecondOperand; }
	 * 
	 * public String getSecondOperandRep() { return secondOperandRep; }
	 * 
	 * public String getOperator() { return operator; }
	 * 
	 * @Override public String toString() { return "NumeralOpRepresentation [width="
	 * + width + ", height=" + height + ", numRep=" + numRep +
	 * ", numLinesFirstOperand=" + numLinesFirstOperand + ", firstOperandRep=" +
	 * firstOperandRep + ", numLinesSecondOperand=" + numLinesSecondOperand +
	 * ", secondOperandRep=" + secondOperandRep + ", operator=" + operator + "]"; }
	 * } }
	 * 
	 */
}
