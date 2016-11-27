package com.adwordy;

import java.util.Comparator;
import java.util.function.Predicate;

public interface AdwordRankerAlgorithm {
	/**
	 * Apply an algorithm to judge an ad-words effectiveness and update the input adword object.
	 * @param adword
	 * @return for caller convenience, returns the input
	 */
	Adword rank(Adword adword);

	default Predicate<Adword> costFilter(float maxDollars) {
		return (Adword data) -> data.cheapEnough(maxDollars);
	}

	default Comparator<Adword> sorter(){
			return (a, b) -> { return Double.compare(a.getRank(), b.getRank()); };
	}
}
