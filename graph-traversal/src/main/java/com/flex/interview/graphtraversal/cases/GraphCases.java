package com.flex.interview.graphtraversal.cases;

import com.flex.interview.graphtraversal.domain.Graph;
import com.flex.interview.graphtraversal.domain.Product;
import com.flex.interview.graphtraversal.domain.Site;
import java.util.List;

public class GraphCases {

	public static Graph case1() {
		Product pcba = new Product("PCBA", 100, 2);
		Product aluminiumCase = new Product("Aluminium Case", 50, 1);
		Product cables = new Product("Cables", 0.02, 2);

		Site tczew = new Site("Tczew", "POLAND");
		Site guad = new Site("Guadalajara", "MEXICO");
		Site shen = new Site("Shenzhen", "CHINA");

		shen.addLane(pcba, tczew);
		guad.addLane(aluminiumCase, tczew, 0.5);
		guad.addLane(aluminiumCase, tczew, 0.5);
		guad.addLane(cables, tczew);

		return new Graph(List.of(guad, shen));
	}

	public static Graph case2() {
		Product pcba = new Product("PCBA", 100, 2);
		Product aluminiumCase = new Product("Aluminium Case", 50, 1);
		Product cables = new Product("Cables", 0.02, 2);

		Site tczew = new Site("Tczew", "POLAND");
		Site guad = new Site("Guadalajara", "MEXICO");
		Site shen = new Site("Shenzhen", "CHINA");

		shen.addLane(pcba, tczew, 0.5);
		guad.addLane(pcba, tczew, 0.5);
		guad.addLane(aluminiumCase, tczew, 0.5);
		guad.addLane(aluminiumCase, tczew, 0.5);
		guad.addLane(cables, tczew);

		return new Graph(List.of(guad, shen));
	}

	public static Graph case3() {
		Product pcba = new Product("PCBA", 100, 2);
		Product aluminiumCase = new Product("Aluminium Case", 50, 1);
		Product cables = new Product("Cables", 0.02, 2);

		Site tczew = new Site("Tczew", "POLAND");
		Site guad = new Site("Guadalajara", "MEXICO");
		Site shen = new Site("Shenzhen", "CHINA");
		Site austin = new Site("Austin", "USA");

		shen.addLane(pcba, tczew);
		guad.addLane(aluminiumCase, austin, 0.5);
		guad.addLane(aluminiumCase, tczew, 0.5);
		austin.addLane(aluminiumCase, tczew);
		guad.addLane(cables, tczew);

		return new Graph(List.of(guad, shen));
	}
}
