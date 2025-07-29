package com.flex.interview.graphtraversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.flex.interview.graphtraversal.cases.GraphCases;
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
	void printGraphTest() {
		part1.printGraph(GraphCases.case1());
	}

	@Test
	void totalCost() {
		double cost = part1.totalCost(GraphCases.case1());
		assertEquals(250.04, cost, 0.01);
	}
}
