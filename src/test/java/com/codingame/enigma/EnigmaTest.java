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
	
	@Test
	public void should_encode_to_JLC_when_input_is_AAA_with_one_rotor() {
		final int N=4;
		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";
		final String message="AAA";
		final String shiftedChars = Enigma.encode(N,message,Lists.newArrayList(rotor1));
		assertThat(shiftedChars).isEqualTo("JLC");
	}
	
	
	@Test
	public void should_decode_to_AAA_when_input_is_KQF_with_3_rotors() {
		final int N=4;
		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";
		final String rotor2="AJDKSIRUXBLHWTMCQGZNPYFVOE";
		final String rotor3="EKMFLGDQVZNTOWYHXUSPAIBRCJ";
		final String message="KQF";
		final String shiftedChars = Enigma.decode(N,message,Lists.newArrayList(rotor3,rotor2,rotor1));
		assertThat(shiftedChars).isEqualTo("AAA");
	}
	
	@Test
	public void should_encode_to_KQF_when_input_is_AAA() {
		final int N=4;
		//ABCDEFGHIJKLMNOPQRSTUVWXYZ
		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";
		
		//BDF
		final String rotor2="AJDKSIRUXBLHWTMCQGZNPYFVOE";
		//JKI
		final String rotor3="EKMFLGDQVZNTOWYHXUSPAIBRCJ";
		//ZNV
		final String message="AAA";
		final String shiftedChars = Enigma.encode(N,message,Lists.newArrayList(rotor1,rotor2,rotor3));
		assertThat(shiftedChars).isEqualTo("KQF");
	}
	
	
	@Test
	public void should_encode_to_ZNV_when_input_is_ZZZ() {
		final int N=1;
	
		//ABCDEFGHIJKLMNOPQRSTUVWXYZ
		//shifted ABC
		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";
		//BDF
		final String rotor2="AJDKSIRUXBLHWTMCQGZNPYFVOE";
		//JKI
		final String rotor3="EKMFLGDQVZNTOWYHXUSPAIBRCJ";
		//ZNV
		final String message="ZZZ";
		final String shiftedChars = Enigma.encode(N,message,Lists.newArrayList(rotor1,rotor2,rotor3));
		assertThat(shiftedChars).isEqualTo("ZNV");
	}
	
	
	
	
	@Test
	public void shoud_encode_WEATHERREPORTWINDYTODAY_to_ALWAURKQEQQWLRAWZHUYKVN() {
		final int N=7;
		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";

		final String rotor2="AJDKSIRUXBLHWTMCQGZNPYFVOE";
		final String rotor3="EKMFLGDQVZNTOWYHXUSPAIBRCJ";
		//final String message="Y";
		final String message="WEATHERREPORTWINDYTODAY";
		final String shiftedChars = Enigma.encode(N,message,Lists.newArrayList(rotor1,rotor2,rotor3));
		assertThat(shiftedChars).isEqualTo("ALWAURKQEQQWLRAWZHUYKVN");
	}
	

	@Test
	public void should_decode_to_AAA_when_input_is_JLC_with_one_rotor() {
		final int N=5;
		//ABCDEFGHIJKLMNOPQRSTUVWXYZ
		//EFG
		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";
		final String message="JLC";
		final String shiftedChars = Enigma.decode(N,message,Lists.newArrayList(rotor1));
		assertThat(shiftedChars).isEqualTo("ZZZ");
	}
	
	@Test
	public void should_decode_DMJDSQEFTFFJMQDJAWSOECB_to_WEATHERREPORTWINDYTODAY() {
		final int N=7;
		final String message="DMJDSQEFTFFJMQDJAWSOECB";
		final String shiftedChars = Enigma.decode(N,message,Lists.newArrayList());
		assertThat(shiftedChars).isEqualTo("WEATHERREPORTWINDYTODAY");
	}

	@Test
	public void shoud_decode_ALWAURKQEQQWLRAWZHUYKVN_to_WEATHERREPORTWINDYTODAY() {
		final int N=7;
		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";
		final String rotor2="AJDKSIRUXBLHWTMCQGZNPYFVOE";
		final String rotor3="EKMFLGDQVZNTOWYHXUSPAIBRCJ";
		final String message="ALWAURKQEQQWLRAWZHUYKVN";
		final String shiftedChars = Enigma.decode(N,message,Lists.newArrayList(rotor3,rotor2,rotor1));
		assertThat(shiftedChars).isEqualTo("WEATHERREPORTWINDYTODAY");
	}
	
	@Test
	public void shoud_decode_PQSACVVTOISXFXCIAMQEM_to_EVERYONEISWELCOMEHERE() {
		final int N=9;
		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";
		final String rotor2="AJDKSIRUXBLHWTMCQGZNPYFVOE";
		final String rotor3="EKMFLGDQVZNTOWYHXUSPAIBRCJ";
		final String message="PQSACVVTOISXFXCIAMQEM";
		final String shiftedChars = Enigma.decode(N,message,Lists.newArrayList(rotor3,rotor2,rotor1));
		assertThat(shiftedChars).isEqualTo("EVERYONEISWELCOMEHERE");
	}
	
	@Test
	public void shoud_decode_XPCXAUPHYQALKJMGKRWPGYHFTKRFFFNOUTZCABUAEHQLGXREZ_to_THEQUICKBROWNFOXJUMPSOVERALAZYSPHINXOFBLACKQUARTZ() {
		final int N=5;
		final String rotor1="BDFHJLCPRTXVZNYEIWGAKMUSQO";
		final String rotor2="AJDKSIRUXBLHWTMCQGZNPYFVOE";
		final String rotor3="EKMFLGDQVZNTOWYHXUSPAIBRCJ";
		final String message="XPCXAUPHYQALKJMGKRWPGYHFTKRFFFNOUTZCABUAEHQLGXREZ";
		final String shiftedChars =  Enigma.decode(N,message,Lists.newArrayList(rotor3,rotor2,rotor1));
		assertThat(shiftedChars).isEqualTo("THEQUICKBROWNFOXJUMPSOVERALAZYSPHINXOFBLACKQUARTZ");
	}
	
	public static void main (String args []) {
		char t ='A';
		System.out.println((int)t);
		System.out.println((t + 7 +18));
	}
	
}
