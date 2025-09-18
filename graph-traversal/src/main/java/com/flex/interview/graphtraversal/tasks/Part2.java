package com.flex.interview.graphtraversal.tasks;

import com.flex.interview.graphtraversal.domain.Graph;
import com.flex.interview.graphtraversal.domain.Lane;
import com.flex.interview.graphtraversal.domain.Site;
import com.flex.interview.graphtraversal.domain.TariffProvider;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Part2 {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private void traverse(Site root) {
		for (Lane lane : root.getLanes()) {
			logger.info("{} ({} -> {}) [{}%]", lane.product().name(), lane.origin().getName(),
					lane.destination().getName(), lane.split() * 100);
			traverse(lane.destination());
		}
	}

	/**
	 * Calculates Total Cost according to the formula:
	 * <p>LANE COST = PRODUCT COST * PRODUCT QUANTITY * SPLIT</p>
	 * <p>SUM(LANE COST)</p>
	 *
	 * @param graph graph to calculate
	 * @return returns the total cost for the given graph
	 */
	public double totalCost(Graph graph) {
		return 0;
	}

	/**
	 * Calculates Total Cost as above with the following adjustment:
	 * <p>
	 * If tariffProvider returns value greater than 0 for given origin-destination combination, adjust
	 * lane cost by that percentage.
	 * <p>
	 * <p>EXAMPLE: TariffProvider returns 0.2 for lane: MEXICO -> POLAND,</p>
	 * <p>Lane cost should be adjusted to: 120%</p>
	 *
	 * @param graph          to calculate total cost
	 * @param tariffProvider tariff provider that returns tariff value for given two countries
	 * @return returns the total cost for the given graph with tariff adjustment
	 */
	public double totalCostWithTariffs(Graph graph, TariffProvider tariffProvider) {
		return 0;
	}


	/**
	 * Calculates Total Cost as above, with the following adjustment:
	 * <p>
	 * DO NOT apply tariff to a lane IFF:
	 * <ul>
	 * <li>Tariff value is >= 0.25 for that lane, AND</li>
	 * <li>Given product is on the {@code exemptList}</li>
	 * </ul>
	 *
	 * @param graph          to calculate total cost
	 * @param tariffProvider tariff provider that returns tariff value for given two countries
	 * @param exemptList     list of exempt products
	 * @return calculated total cost
	 */
	public double totalCostWithExemptTariffs(Graph graph, TariffProvider tariffProvider,
			List<String> exemptList) {
		return 0;
	}
}
