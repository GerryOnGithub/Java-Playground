package com.adwordy;

import java.util.List;
import java.util.Comparator;
import java.util.function.Predicate;

public class Main {
	final static float MOSTWEWILLPAY = 5.0f;

	public static void main(String[] args) throws Exception {
		System.out.println("starting");

		AdwordAccessor accessor = AdwordsAccessorFactory.getAccessor(args);
		AdwordRankerAlgorithm ranker = AdwordsRankerAlgorithmFactory.getAlgorithm(args);

		// let's declare what these methods are returning (for a little extra clarity)
		List<Adword> adwords = accessor.getAdwordData();
		Predicate<Adword> cheapEnough = ranker.costFilter(MOSTWEWILLPAY);
		Comparator<Adword> comparator = ranker.sorter();

		adwords.stream()
			     .filter(cheapEnough)
			     .map(adWord -> { return ranker.rank(adWord); }) // keep the stream flowing...
		       .sorted(comparator)
			     .forEach(adWord -> { adWord.print(); });

		System.out.println("done.");
	}
}