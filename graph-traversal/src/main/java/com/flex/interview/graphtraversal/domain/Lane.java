package com.flex.interview.graphtraversal.domain;


public record Lane(Site origin, Site destination, Product product, double split) {

	public Lane(Site origin, Site destination, Product product) {
		this(origin, destination, product, 1.0);
	}

	public double getLaneCost() {
		return product.cost() * split * product.quantity();
	}

	public String getProductName() {
		return product.name();
	}

	public String getOriginCountry() {
		return origin.getCountry();
	}

	public String getDestinationCountry() {
		return destination.getCountry();
	}
}