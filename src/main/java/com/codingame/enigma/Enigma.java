package com.codingame.enigma;

import java.util.ArrayList;
import java.util.HashMap;
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
	 */
	final Map<Character,Integer> map;
	public Enigma() {
		map = new HashMap<>(26);
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
	
	public String encode(int factor, String message, ArrayList<String> rotors) {
		final char [] chars=message.toCharArray();
		final char []shiftedChars = new char [message.length()];
		for (int i=0;i<chars.length;i++) {
			shiftedChars[i]=((char)(chars[i] + factor + i));
		}
		for(int i=0;i<rotors.size();i++) {
			for(int j=0;j< shiftedChars.length;j++) {
				int pos= map.get(shiftedChars[j]);
				char repValue=rotors.get(i).toCharArray()[pos-1];
				shiftedChars[j]= repValue;
			}
		}
		return new String(shiftedChars);
	}

}
