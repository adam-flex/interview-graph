package com.flex.interview.graphtraversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.flex.interview.graphtraversal.cases.GraphCases;
import com.flex.interview.graphtraversal.domain.TariffProvider;
import com.flex.interview.graphtraversal.tasks.Part1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Part1Tests {

	private Part1 part1;

	@BeforeEach
	public void init() {
		part1 = new Part1();
	}

	@Test
	void totalCost() {
		double cost = part1.totalCost(GraphCases.case1());
		assertEquals(250.04, cost, 0.01);
	}

	@Test
	void totalCostWithChinaTariffs() {
		TariffProvider tariffProvider = (origin, destination) -> origin.equals("CHINA") ? .5 : 0;
		double totalCosts = part1.totalCostWithTariffs(GraphCases.case1(), tariffProvider);
		assertEquals(350.04, totalCosts, 0.01);
	}

	@Test
	void totalCostWithMexicoTariffs() {
		TariffProvider tariffProvider = (origin, destination) -> origin.equals("MEXICO") ? 1.0 : 0;
		double totalCosts = part1.totalCostWithTariffs(GraphCases.case1(), tariffProvider);
		assertEquals(300.08, totalCosts, 0.01);
	}
}
