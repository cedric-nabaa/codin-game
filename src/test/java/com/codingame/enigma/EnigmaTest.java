package com.codingame.enigma;


import org.assertj.core.util.Lists;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * @author cedric
 *
 */
public class EnigmaTest {
	
	/*
	 * ENCODE
		4
	BDFHJLCPRTXVZNYEIWGAKMUSQO
	AJDKSIRUXBLHWTMCQGZNPYFVOE
	EKMFLGDQVZNTOWYHXUSPAIBRCJ
	AAA
	 */
	
//	@Test
//	public void should_encode_to_KQF_when_input_is_AAA_with_one_rotor() {
//		final int N=4;
//		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";
//		final String message="AAA";
//		final String shiftedChars = new Enigma().encode(N,message,Lists.newArrayList(rotor1));
//		assertThat(shiftedChars).isEqualTo("JLC");
//	}
//	
//	@Test
//	public void should_encode_to_KQF_when_input_is_AAA() {
//		final int N=4;
//		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";
//		final String rotor2="AJDKSIRUXBLHWTMCQGZNPYFVOE";
//		final String rotor3="EKMFLGDQVZNTOWYHXUSPAIBRCJ";
//		final String message="AAA";
//		final String shiftedChars = new Enigma().encode(N,message,Lists.newArrayList(rotor1,rotor2,rotor3));
//		assertThat(shiftedChars).isEqualTo("KQF");
//	}
	
	@Test
	public void shoud_encode_WEATHERREPORTWINDYTODAY_to_ALWAURKQEQQWLRAWZHUYKVN() {
		final int N=7;
		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";
		final String rotor2="AJDKSIRUXBLHWTMCQGZNPYFVOE";
		final String rotor3="EKMFLGDQVZNTOWYHXUSPAIBRCJ";
		final String message="WEATHERREPORTWINDYTODAY";
		final String shiftedChars = new Enigma().encode(4,message,Lists.newArrayList(rotor1,rotor2,rotor3));
		assertThat(shiftedChars).isEqualTo("ALWAURKQEQQWLRAWZHUYKVN");
	}
	
}
