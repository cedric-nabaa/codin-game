package com.codingame.enigma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cedric
 *
 */
public class Enigma {
	
	/*During World War II, the Germans were using an encryption code called Enigma – 
	 * which was basically an encryption machine that encrypted messages for transmission. 
	 * The Enigma code went many years unbroken. Here How Basic Machine works:

First Caesar shift is applied using an incrementing number.
If AAA and starting number is 4 then output will be EFG. 
A + 4 = E
A + 4 + 1 = F
A + 4 + 1+ 1 = G
Now EFG from first ROTOR such as 'ABCDEFGHIJKLMNOPQRSTUVWXYZ' 
--> 							 'BDFHJLCPRTXVZNYEIWGAKMUSQO'
so EFG become 'JLC'. Then it is passed through 2 more rotors to get final value.
If the second ROTOR is 'AJDKSIRUXBLHWTMCQGZNPYFVOE', we apply the substitution step again thus:
ABCDEFGHIJKLMNOPQRSTUVWXYZ
AJDKSIRUXBLHWTMCQGZNPYFVOE
So 'JLC' becomes 'BHD'.

If the third ROTOR is 'EKMFLGDQVZNTOWYHXUSPAIBRCJ', then the final substitution is 'BHD' becoming 'KQF'.
Final Output is sent via Radio Transmitter.
	 * 
	 * 
	 * EMJESQFGTGGKNREKBXTPFDD
	 * JZTJGILCACCXNWJXDSAELHH
	 * 
	 * ABCDEFGHIJKLMNOPQRSTUVWXYZ
	 * BDFHJLCPRTXVZNYEIWGAKMUSQO
	 */
	final static Map<Character,Integer> map = new HashMap<>(26);
	
	static {

		map.put('A', 1);
		map.put('B', 2);
		map.put('C', 3);
		map.put('D', 4);
		map.put('E', 5);
		map.put('F', 6);
		map.put('G', 7);
		map.put('H', 8);
		map.put('I', 9);
		map.put('J', 10);
		map.put('K', 11);
		map.put('L', 12);
		map.put('M', 13);
		map.put('N', 14);
		map.put('O', 15);
		map.put('P', 16);
		map.put('Q', 17);
		map.put('R', 18);
		map.put('S', 19);
		map.put('T', 20);
		map.put('U', 21);
		map.put('V', 22); 
		map.put('W', 23);
		map.put('X', 24);
		map.put('Y', 25);
		map.put('Z', 26);
		
	
	}
			
	
	
	public static String encode(int factor, String message, List<String> rotors) {
		final char [] chars=message.toCharArray();
		final char []shiftedChars = new char [message.length()];
		for (int i=0;i<chars.length;i++) {
			int idx=(char)(chars[i] + factor + i);
			System.out.println("char " + chars[i] + "is "+ chars[i]+" + " + factor +" + "+ i);
			if(idx<=90) {
				shiftedChars[i]=(char)(idx);
			}else {
				while(idx>90) {
					idx-=26;
				}
				shiftedChars[i]=(char)(idx);
			}
			System.out.println("shifted char is: " + shiftedChars[i]);
		}
		System.out.println("shifted message is: " + new String(shiftedChars));

		for(int i=0;i<rotors.size();i++) {
			matchRotor(rotors.get(i), shiftedChars,true);
			System.out.println("rotor " + i + "shifted msg is : " + new String(shiftedChars));
		}
		return new String(shiftedChars);
	}

	private static void matchRotor(String rotor, char[] charsToMatch,boolean isEncode) {
		for(int j=0;j< charsToMatch.length;j++) {
			char repValue;
			if(isEncode) {
				int pos= map.get(charsToMatch[j]);
				repValue=rotor.toCharArray()[pos-1];
			}else {
				int pos=rotor.indexOf(charsToMatch[j]);
				repValue=(char)(65+pos);
			}
			charsToMatch[j]= repValue;
		}
	}

	
	public static String decode(int factor, String message, List<String> rotors) {
		//'ABCDEFGHIJKLMNOPQRSTUVWXYZ' 
		final char[] charArray = message.toCharArray();
		final char[] decodedArr = new char [charArray.length]; 
		for (int i =0;i<rotors.size();i++) {
			matchRotor(rotors.get(i), charArray,false);
			System.out.println("rotor number " + i +" message: " + new String (charArray));
		}
		for(int i=0;i<charArray.length;i++) {
			int idx=(char)(charArray[i]-factor-i);
			if(idx>=65) {
				decodedArr[i]=(char)(charArray[i]-factor-i);
			}else {
				while(idx<65) {
					idx+=26;
				}
				decodedArr[i]=(char)idx;
				System.out.println("idx : " + idx );
			}
			System.out.println("shifting message from : " + charArray[i] + " to : " + decodedArr[i]);
		}
		return new String (decodedArr);
	}

}
