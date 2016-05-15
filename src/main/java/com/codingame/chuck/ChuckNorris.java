package com.codingame.chuck;

import java.nio.charset.Charset;
import java.util.Scanner;

public class ChuckNorris {

	private static final String US_ASCII = "US-ASCII";

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String message = in.nextLine();
		System.out.println(convertTextToFullBinaryMessage(message));
	}

	protected static String convertTextToFullBinaryMessage(String message) {
		byte[] chars = message.getBytes(Charset.forName(US_ASCII));

		String sumBin = "";
		for (byte c : chars) {
			int rep = (int) c;
			String binaryRepresentation = Integer.toBinaryString(rep);

			binaryRepresentation = pad(binaryRepresentation);
			sumBin += binaryRepresentation;
		}
		String binary = convertToPuzzleBinary(sumBin, "", 0);
		return binary;
	}

	private static String convertToPuzzleBinary(String binaryRepresentation,
			String newRepresentation, int position) {

		if (position == binaryRepresentation.length()) {
			return newRepresentation;
		} else {
			String previousToAnalyse = null;
			if (position > 0) {
				previousToAnalyse = ((Character) binaryRepresentation
						.charAt(position - 1)).toString();
			}
			String toAnalyse = ((Character) binaryRepresentation
					.charAt(position)).toString();

			if (previousToAnalyse != null) {
				if (previousToAnalyse.equals(toAnalyse)) {
					newRepresentation += "0";
				} else {
					if (toAnalyse.equals("0")) {
						newRepresentation += " 00 0";
					} else {
						newRepresentation += " 0 0";
					}
				}
			} else {
				if (toAnalyse.equals("0")) {
					newRepresentation += "00 0";
				} else {

					newRepresentation += "0 0";
				}
			}

			return convertToPuzzleBinary(binaryRepresentation,
					newRepresentation, position + 1);
		}
	}

	private static String pad(String binaryRepresentation) {
		if (binaryRepresentation.length() % 7 == 0) {
			return binaryRepresentation;
		} else {
			return pad("0" + binaryRepresentation);
		}
	}

}
