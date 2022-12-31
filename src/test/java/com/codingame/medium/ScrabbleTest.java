package com.codingame.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class ScrabbleTest {

	Set<String> dico = new HashSet<>();

	@Test
	public void should_return_which_with_test_case_1() {
		dico.add("because");
		dico.add("first");
		dico.add("these");
		dico.add("could");
		dico.add("which");
		Assertions.assertThat(Scrabble.getMaxWord(dico, "hicquwh")).isEqualTo("which");

	}

}
