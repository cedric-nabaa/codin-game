package com.codingame.genome.sequencing;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GenomeSequencingTest {

	@Test
	public void should_return_TA_when_AGATTA_and_TACA_for_longestCommonSequence() {

		Assertions.assertThat(GenomeSequencing.getLongestCommonSequencesBetweenTwoSequences("AGATTA", "TACA"))
				.isEqualTo("TA");
	}

	@Test
	public void should_return_TA_when_TA_and_TA_for_longestCommonSequence() {

		Assertions.assertThat(GenomeSequencing.getLongestCommonSequencesBetweenTwoSequences("TA", "TA"))
				.isEqualTo("TA");
	}

	@Test
	public void should_return_TACA_when_AGATTA_and_TACA_for_longestCommonSequence() {

		Assertions.assertThat(GenomeSequencing.getLongestCommonSequencesBetweenTwoSequences("AGATACATTA", "TACA"))
				.isEqualTo("TACA");
	}

	@Test
	public void should_return_C_when_AAC_and_CCTT_for_longestCommonSequenceLength() {

		Assertions.assertThat(GenomeSequencing.getLongestCommonSequencesBetweenTwoSequences("AAC", "CCTT"))
				.isEqualTo("C");
	}

	@Test
	public void should_return_1_when_AAC_and_CCTT_for_longestCommonSequenceLength() {

		Assertions.assertThat(GenomeSequencing.getLongestCommonSequencesBetweenTwoSequences("AAC", "CCTT").length())
				.isEqualTo(1);
	}
	
	
	@Test
	public void should_return_6_when_AAC_and_CCTT_for_finalSequenceLengthBetweenTwoSequences() {

		Assertions.assertThat(GenomeSequencing.getFinalSequenceBetweenTwoSequences("AAC", "CCTT").length())
				.isEqualTo(6);
	}

	@Test
	public void should_return_AACCTT_when_AAC_and_CCTT_for_finalSequenceLengthBetweenTwoSequences() {

		Assertions.assertThat(GenomeSequencing.getFinalSequenceBetweenTwoSequences("AAC", "CCTT")).isEqualTo("AACCTT");
	}

	@Test
	public void should_return_AGATTA_when_GAT_and_AGATTA_for_finalSequenceLengthBetweenTwoSequences() {

		Assertions.assertThat(GenomeSequencing.getFinalSequenceBetweenTwoSequences("GAT", "AGATTA"))
				.isEqualTo("AGATTA");
	}

	@Test
	public void should_return_6_when_GAT_and_AGATTA_for_finalSequenceLengthBetweenTwoSequencesLegnth() {

		Assertions.assertThat(GenomeSequencing.getFinalSequenceBetweenTwoSequences("GAT", "AGATTA").length())
				.isEqualTo(6);
	}

	@Test
	public void should_return_AGATTACAGA_when_AGATTA_and_GATTACA_and_TACAGA_for_getMergeGeneSequence() {
		final List<String> unmergedGeneSequences = new ArrayList<>();
		unmergedGeneSequences.add("AGATTA");
		unmergedGeneSequences.add("GATTACA");
		unmergedGeneSequences.add("TACAGA");
		Assertions.assertThat(GenomeSequencing.getMergeGeneSequence(unmergedGeneSequences)).isEqualTo("AGATTACAGA");
	}

	@Test
	public void should_return_AGATTACAGA_when_AGATTA_and_GATTACA_and_TACAGA_for_getMergeGeneSequenceLength() {
		final List<String> unmergedGeneSequences = new ArrayList<>();
		unmergedGeneSequences.add("AGATTA");
		unmergedGeneSequences.add("GATTACA");
		unmergedGeneSequences.add("TACAGA");
		Assertions.assertThat(GenomeSequencing.getMergeGeneSequence(unmergedGeneSequences).length()).isEqualTo(10);
	}
	
	@Test
	public void should_return_AGATTACAGA_when_AGATTA_and_GATTACA_and_TACAGA_for_shuffleTheUnmergedSequencesAndGetBestLength() {
		final List<String> unmergedGeneSequences = new ArrayList<>();
		unmergedGeneSequences.add("AGATTA");
		unmergedGeneSequences.add("GATTACA");
		unmergedGeneSequences.add("TACAGA");
		Assertions.assertThat(GenomeSequencing.shuffleTheUnmergedSequencesAndGetBestLength(unmergedGeneSequences)).isEqualTo(10);
	}
	
	@Test
	public void should_return_AACTT_when_TT_and_AA_and_ACT_for_shuffleTheUnmergedSequencesAndGetBestLength() {
		final List<String> unmergedGeneSequences = new ArrayList<>();
		unmergedGeneSequences.add("TT");
		unmergedGeneSequences.add("AA");
		unmergedGeneSequences.add("ACT");
		Assertions.assertThat(GenomeSequencing.shuffleTheUnmergedSequencesAndGetBestLength(unmergedGeneSequences))
				.isEqualTo(5);
	}

}
