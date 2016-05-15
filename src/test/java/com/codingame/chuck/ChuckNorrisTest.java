package com.codingame.chuck;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ChuckNorrisTest {
	@Test
	public void testC() {
		Assertions.assertThat(ChuckNorris.convertTextToFullBinaryMessage("C"))
				.isEqualTo("0 0 00 0000 0 00");
	}

	@Test
	public void testCC() {
		Assertions.assertThat(ChuckNorris.convertTextToFullBinaryMessage("CC"))
				.isEqualTo("0 0 00 0000 0 000 00 0000 0 00");
	}

	@Test
	public void testSpecialCaracter() {
		Assertions.assertThat(ChuckNorris.convertTextToFullBinaryMessage("%"))
				.isEqualTo("00 0 0 0 00 00 0 0 00 0 0 0");
	}

	@Test
	public void testCheckNorris() {
		String binary = "0 0 00 0000 0 0000 00 0 0 0 00 000 0 000 00 0 0 0 00 0 0 000 00 000 0 0000 00 0 0 0 00 0 0 00 00 0 0 0 00 00000 0 0 00 00 0 000 00 0 0 00 00 0 0 0000000 00 00 0 0 00 0 0 000 00 00 0 0 00 0 0 00 00 0 0 0 00 00 0 0000 00 00 0 00 00 0 0 0 00 00 0 000 00 0 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 000 00 000 0 0 00 0 0 00 00 0 0 000000 00 0000 0 0000 00 00 0 0 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 00 00 0 0 0 00 000 0 00 00 0000 0 0000 00 00 0 00 00 0 0 0 00 000000 0 00 00 00 0 0 00 00 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 0000 00 00 0 00 00 0 0 000 00 0 0 0 00 00 0 0 00 000000 0 00 00 00000 0 0 00 00000 0 00 00 0000 0 000 00 0 0 000 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 000 00 0 0 00000 00 0 0 0 00 000 0 00 00 0 0 0 00 00 0 0000 00 0 0 0 00 00 0 00 00 00 0 0 00 0 0 0 00 0 0 0 00 00000 0 000 00 00 0 00000 00 0000 0 00 00 0000 0 000 00 000 0 0000 00 00 0 0 00 0 0 0 00 0 0 0 00 0 0 000 00 0";

		Assertions
				.assertThat(
						ChuckNorris
								.convertTextToFullBinaryMessage("Chuck Norris' keyboard has 2 keys: 0 and white space."))
				.isEqualTo(binary);
	}
}
