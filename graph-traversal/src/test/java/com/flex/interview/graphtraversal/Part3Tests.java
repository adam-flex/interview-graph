package com.flex.interview.graphtraversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.flex.interview.graphtraversal.cases.GraphCases;
import com.flex.interview.graphtraversal.domain.TariffProvider;
import com.flex.interview.graphtraversal.tasks.Part3;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Part3Tests {

	private Part3 part3;

	@BeforeEach
	public void init() {
		part3 = new Part3();
	}

	@Test
	void totalCost() {
		double cost = part3.totalCost(GraphCases.case1());
		assertEquals(250.04, cost, 0.01);
	}

	@Test
	void totalCostWithChinaTariffs() {
		TariffProvider tariffProvider = (origin, destination) -> origin.equals("CHINA") ? .5 : 0;
		double totalCosts = part3.totalCostWithTariffs(GraphCases.case1(), tariffProvider);
		assertEquals(350.04, totalCosts, 0.01);
	}

	@Test
	void totalCostWithMexicoTariffs() {
		TariffProvider tariffProvider = (origin, destination) -> origin.equals("MEXICO") ? 1.0 : 0;
		double totalCosts = part3.totalCostWithTariffs(GraphCases.case1(), tariffProvider);
		assertEquals(300.08, totalCosts, 0.01);
	}

	@Test
	void totalCostWithMexicoTariffsWithCablesExempt() {
		TariffProvider tariffProvider = (origin, destination) -> origin.equals("MEXICO") ? 1.0 : 0;
		double totalCosts = part3.totalCostWithExemptTariffs(GraphCases.case1(), tariffProvider,
				List.of("Cables"));
		assertEquals(300.04, totalCosts, 0.01);
	}

	@Test
	void totalCostWithMexicoTariffsWithCablesAndCaseExempt() {
		TariffProvider tariffProvider = (origin, destination) -> origin.equals("MEXICO") ? 1.0 : 0;
		double totalCosts = part3.totalCostWithExemptTariffs(GraphCases.case1(), tariffProvider,
				List.of("Cables", "Aluminium Case"));
		assertEquals(250.04, totalCosts, 0.01);
	}

	@Test
	void totalCostWithChinaTariffsWithNoPcbaExempt() {
		TariffProvider tariffProvider = (origin, destination) -> origin.equals("CHINA") ? 0.24 : 0;
		double totalCosts = part3.totalCostWithExemptTariffs(GraphCases.case1(), tariffProvider,
				List.of("PCBA"));
		assertEquals(298.04, totalCosts, 0.01);
	}

	@Test
	void totalCostWithChinaTariffsWithPcbaExempt() {
		TariffProvider tariffProvider = (origin, destination) -> origin.equals("CHINA") ? 0.25 : 0;
		double totalCosts = part3.totalCostWithExemptTariffs(GraphCases.case1(), tariffProvider,
				List.of("PCBA"));
		assertEquals(250.04, totalCosts, 0.01);
	}

	@Test
	void totalCostWithChinaTariffsWithPcbaExemptCase2() {
		TariffProvider tariffProvider = (origin, destination) -> {
			if (origin.equals("CHINA")) {
				return 0.45;
			} else if (origin.equals("MEXICO")) {
				return 0.35;
			} else {
				return 0.0;
			}
		};
		double totalCosts = part3.totalCostWithExemptTariffs(GraphCases.case2(), tariffProvider,
				List.of("PCBA"));
		assertEquals(267.554, totalCosts, 0.01);
	}
}
