package com.flex.interview.graphtraversal.domain;

import java.util.function.BiFunction;

public interface TariffProvider extends BiFunction<String, String, Double> {

	/**
	 * Returns a PERCENTAGE value of tariff between
	 *
	 * @param originCountry
	 * @param destinationCountry
	 * @return returns tariff value ranging from 0.00 to 1.00
	 */
	default double getTariff(String originCountry, String destinationCountry) {
		return apply(originCountry, destinationCountry);
	}
}
