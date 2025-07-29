package com.flex.interview.graphtraversal.tasks;

import com.flex.interview.graphtraversal.domain.Graph;
import com.flex.interview.graphtraversal.domain.Lane;
import com.flex.interview.graphtraversal.domain.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Part1 {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void printGraph(Graph graph) {
		graph.roots().forEach(this::traverse);
	}

	private void traverse(Site root) {
		for (Lane lane : root.getLanes()) {
			logger.info("{} ({} -> {}) [{}%]", lane.product().name(), lane.origin().getName(),
					lane.destination().getName(), lane.split() * 100);
			traverse(lane.destination());
		}
	}

	/**
	 * Calculates Total Cost according to the formula:
	 * <p>
	 * LANE COST = PRODUCT COST * PRODUCT QUANTITY * SPLIT SUM(LANE COST)
	 *
	 * @param graph graph to calculate
	 * @return returns the total cost for the given graph
	 */
	public double totalCost(Graph graph) {
		return 0;
	}


}
