package com.flex.interview.graphtraversal.domain;

import java.util.ArrayList;
import java.util.List;

public class Site {

	private final String name;
	private final String country;
	private final List<Lane> lanes = new ArrayList<>();

	public Site(String name, String country) {
		this.name = name;
		this.country = country;
	}

	public void addLane(Product product, Site destination) {
		this.lanes.add(new Lane(this, destination, product));
	}

	public void addLane(Product product, Site destination, double split) {
		this.lanes.add(new Lane(this, destination, product, split));
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public List<Lane> getLanes() {
		return lanes;
	}

	@Override
	public String toString() {
		return name;
	}
}
