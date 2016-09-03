package com.codingame.genome.sequencing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

final public class GenomeSequencing {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		// maximum size of
		int N = in.nextInt();
		final List<String> inputSequences = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			inputSequences.add(in.next());
		}
		;
		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");

		System.out.println(shuffleTheUnmergedSequencesAndGetBestLength(inputSequences));
	}

	protected static int shuffleTheUnmergedSequencesAndGetBestLength(List<String> unmergedGeneSequences) {
		final List<String> intialSequences = new ArrayList<>(unmergedGeneSequences);
		Collections.copy(intialSequences, unmergedGeneSequences);
		final Set<Integer> length = new TreeSet<>();
		// normal order

		for (int i = 0; i < intialSequences.size(); i++) {
			final List<String> tmpIntialSequences = new ArrayList<>(intialSequences);
			Collections.copy(tmpIntialSequences, intialSequences);
			Collections.rotate(tmpIntialSequences, i);
			length.add(getMergeGeneSequence(tmpIntialSequences).length());
		}
		return length.iterator().next();
	}

	protected static String getMergeGeneSequence(final List<String> unmergedGeneSequences) {
		// merging 1srt 2
		while (unmergedGeneSequences.size() > 1) {
			mergeOneMergeSequenceWithAnUnmergedSequence(unmergedGeneSequences);
		}
		return unmergedGeneSequences.get(0);

	}

	protected static List<String> mergeOneMergeSequenceWithAnUnmergedSequence(final List<String> mergeInProccessList) {
		final String seq1seq2Merge = getFinalSequenceBetweenTwoSequences(mergeInProccessList.get(0),
				mergeInProccessList.get(1));
		mergeInProccessList.remove(0);
		mergeInProccessList.remove(0);
		mergeInProccessList.add(0, seq1seq2Merge);
		return mergeInProccessList;

	}

	protected static String getFinalSequenceBetweenTwoSequences(final String sequence1, final String sequence2) {
		if (sequence1.contains(sequence2)) {
			return sequence1;
		} else if (sequence2.contains(sequence1)) {
			return sequence2;
		} else {

			final String longestCommonSequencesBetweenTwoSequences = getLongestCommonSequencesBetweenTwoSequences(
					sequence1, sequence2);
			final String sequence1WithoutCommonPart = sequence1.substring(0,
					sequence1.length() - longestCommonSequencesBetweenTwoSequences.length());
			final String sequence2WithoutCommonPart = sequence2
					.substring(longestCommonSequencesBetweenTwoSequences.length(), sequence2.length());
			return sequence1WithoutCommonPart + longestCommonSequencesBetweenTwoSequences + sequence2WithoutCommonPart;
		}
	}

	protected static String getLongestCommonSequencesBetweenTwoSequences(final String sequence1,
			final String sequence2) {

		final List<String> commonSequences = getCommonSequencesBetweenTwoSequences(sequence1, sequence2,
				new ArrayList<String>());
		String longestCommonSequence = "";
		for (String commonSequence : commonSequences) {
			if (commonSequence.length() > longestCommonSequence.length()) {
				longestCommonSequence = commonSequence;
			}
		}
		return longestCommonSequence;
	}

	protected static List<String> getCommonSequencesBetweenTwoSequences(final String sequence1, final String sequence2,
			final List<String> commonSequences) {
		if (sequence1.length() == 0) {
			return commonSequences;
		}
		// caracter to be tested
		String toBeTested = String.valueOf(sequence2.charAt(0));
		if (!sequence1.startsWith(toBeTested)) {
			// A
			return getCommonSequencesBetweenTwoSequences(sequence1.substring(1), sequence2, commonSequences);
		} else {
			String commonGeneSequence = "";
			commonGeneSequence += toBeTested;
			boolean hasFirstCaracterInCommonBeenAdded = false;
			for (int i = 1; i < sequence2.length(); i++) {
				if (sequence1.length() > i) {
					if (sequence2.charAt(i) == sequence1.charAt(i)) {
						commonGeneSequence += sequence2.charAt(i);
						commonSequences.add(commonGeneSequence);
						hasFirstCaracterInCommonBeenAdded = true;
					} else {
						break;
					}
				}
			}
			if (hasFirstCaracterInCommonBeenAdded == false) {
				commonSequences.add(toBeTested);
			}
			return getCommonSequencesBetweenTwoSequences(sequence1.substring(commonGeneSequence.length()), sequence2,
					commonSequences);

		}
	}
}
