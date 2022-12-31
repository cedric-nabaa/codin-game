package com.codingame.stockexchange;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StockExchangeTest {

	@Test
	public void should_return_minus_3_for_example_0() {
		List<Integer> input = Lists.newArrayList(new Integer[] { 4, 3, 2, 1 });
		assertThat(StockExchange.calculateBiggestLost(input)).isEqualTo(3);
	}

	@Test
	public void should_return_minus_3_for_example_1() {
		List<Integer> input = Lists.newArrayList(new Integer[] { 3, 2, 4, 2, 1,
				5 });
		assertThat(StockExchange.calculateBiggestLost(input)).isEqualTo(3);
	}
}
