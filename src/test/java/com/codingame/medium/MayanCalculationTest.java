package com.codingame.medium;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

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
				secondNumb, '+');

		// assertThat(mayanCalculation.compute(numOpRepresentation)).isEqualTo(expectedNumb);
	}

	@Test
	public void test_read_representation() {
		String[][] readNumRepresentation = mayanCalculation.readNumRepresentation(4, 4,
				getSimpleNumberOfRepresentation());

		assertThat(readNumRepresentation[0][1]).isEqualTo("o...\n");
		assertThat(readNumRepresentation[1][1]).isEqualTo("....\n");
		assertThat(readNumRepresentation[2][1]).isEqualTo("....\n");
		assertThat(readNumRepresentation[3][1]).isEqualTo("....");

		assertThat(readNumRepresentation[2][12]).isEqualTo("____\n");
		assertThat(readNumRepresentation[0][16]).isEqualTo("o...\n");

	}

	@Test
	public void test_compute_base() {
		String[][] readNumRepresentation = mayanCalculation.readNumRepresentation(4, 4,
				getSimpleNumberOfRepresentation());
		String firstNumb = "o...\n" + "....\n" + "....\n" + "....";
		String seventeen = "oo..\n" + "____\n" + "____\n" + "____";

		Map<String, Integer> baseTo10 = mayanCalculation.computeBase(readNumRepresentation, 4);

		assertThat(baseTo10.size()).isEqualTo(20);
		assertThat(baseTo10.get(firstNumb)).isEqualTo(1);
		assertThat(baseTo10.get(seventeen)).isEqualTo(17);
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
}
