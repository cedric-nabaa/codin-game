package com.codingame.medium;

import com.codingame.medium.MayanCalculation.NumeralOpRepresentation;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MayanCalculationTest {

	private static final String BASE_20 = "0123456789ABCDEFGHIJ";
	private final MayanCalculation mayanCalculation = new MayanCalculation();

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
	public void test_with_zero() {
		String numRep = getSimpleNumberOfRepresentation();

		String firstNumb = "o...\n" + "....\n" + "....\n" + "....\n" + "....\n" + "____\n" + "____\n" + "....\n"
				+ "oo..\n" + "____\n" + "____\n" + "____\n" + "....\n" + "____\n" + "....\n" + "....\n";

		String secondNumb = ".oo.\n" + "o..o\n" + ".oo.\n" + "....";

		String expectedNumb = ".oo.\n" + "o..o\n" + ".oo.\n" + "....";

		final NumeralOpRepresentation numOpRepresentation = new NumeralOpRepresentation(4, 4, numRep, 16, firstNumb, 4,
				secondNumb, "*");

		assertThat(mayanCalculation.compute(numOpRepresentation)).isEqualTo(expectedNumb);
	}

	@Test
	public void test_with_great_multiplication() {
		String numRep = getSimpleNumberOfRepresentation();

		String firstNumb = "o...\n" + "....\n" + "....\n" + "....\n" + "....\n" + "____\n" + "____\n" + "....\n"
				+ "oo..\n" + "____\n" + "____\n" + "____\n" + "....\n" + "____\n" + "....\n" + "....\n";

		String secondNumb = "oooo\n" + "....\n" + "....\n" + "....\n" + "ooo.\n" + "____\n" + "____\n" + "____\n"
				+ "oo..\n" + "____\n" + "____\n" + "....\n" + "....\n" + "____\n" + "____\n" + "....\n" + "oo..\n"
				+ "____\n" + "____\n" + "....";

		String expectedNumb = "oo..\n" + "____\n" + "....\n" + "....\n" + "oo..\n" + "____\n" + "____\n" + "....\n"
				+ "ooo.\n" + "....\n" + "....\n" + "....\n" + "oo..\n" + "____\n" + "____\n" + "____\n" + "oooo\n"
				+ "....\n" + "....\n" + "....\n" + "oo..\n" + "....\n" + "....\n" + "....\n" + "oo..\n" + "____\n"
				+ "____\n" + "____\n" + ".oo.\n" + "o..o\n" + ".oo.\n" + "....";

		final NumeralOpRepresentation numOpRepresentation = new NumeralOpRepresentation(4, 4, numRep, 16, firstNumb, 20,
				secondNumb, "*");

		assertThat(mayanCalculation.compute(numOpRepresentation)).isEqualTo(expectedNumb);

	}

	@Test
	public void test_base_20_mult() {
		String numRep = getBase20Rep();
		// 8016
		String firstNumb = "1\n" + "0\n" + "0\n" + "G";
		// 42
		String secondNumb = "2\n" + "2";

		String expectedNumb = "2\n" + "2\n" + "1\n" + "D\n" + "C";

		final NumeralOpRepresentation numOpRepresentation = new NumeralOpRepresentation(1, 1, numRep, 4, firstNumb, 2,
				secondNumb, "*");

		assertThat(mayanCalculation.compute(numOpRepresentation)).isEqualTo(expectedNumb);

	}

	@Test
	public void test_base_20_add() {
		String numRep = getBase20Rep();
		// 8016
		String firstNumb = "1\n" + "0\n" + "0\n" + "G";
		// 42
		String secondNumb = "2\n" + "2";

		String expectedNumb = "1\n" + "0\n" + "2\n" + "I";

		final NumeralOpRepresentation numOpRepresentation = new NumeralOpRepresentation(1, 1, numRep, 4, firstNumb, 2,
				secondNumb, "+");

		assertThat(mayanCalculation.compute(numOpRepresentation)).isEqualTo(expectedNumb);

	}

	@Test
	public void test_base_20_sub() {
		String numRep = getBase20Rep();
		// 8016
		String firstNumb = "1\n" + "0\n" + "0\n" + "G";
		// 42
		String secondNumb = "2\n" + "2";

		String expectedNumb = "J\n" + "I\n" + "E";

		final NumeralOpRepresentation numOpRepresentation = new NumeralOpRepresentation(1, 1, numRep, 4, firstNumb, 2,
				secondNumb, "-");
		assertThat(mayanCalculation.readNumRepresentationSimple(1, 1, numRep)).isEqualTo(new String[] { "0", "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" });
		assertThat(mayanCalculation.compute(numOpRepresentation)).isEqualTo(expectedNumb);

	}

	@Test
	public void test_complex_base_20() {
		String numRep = getBase20Rep();
		// 8016
		String firstNumb = "1\n" + "0\n" + "0\n" + "G";

		String secondNumb = firstNumb;

		// 64_256_256

		String expectedNumb = "1\n" + "0\n" + "1\n" + "C\n" + "0\n" + "C\n" + "G";

		final NumeralOpRepresentation numOpRepresentation = new NumeralOpRepresentation(1, 1, numRep, 4, firstNumb, 4,
				secondNumb, "*");

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

	private String getBase20Rep() {
		return BASE_20;
	}

}
