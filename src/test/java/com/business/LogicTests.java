package com.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.business.basiclogics.Logic;

class LogicTests {

	@Test
	void countTotalMultipliesPriceByQuantity() {
		assertEquals(250.0, Logic.countTotal(50.0, 5), 0.0001);
	}

	@Test
	void countTotalHandlesZeroQuantity() {
		assertEquals(0.0, Logic.countTotal(99.99, 0), 0.0001);
	}
}
