package com.adwordy;

public class SimpleAdwordRanker implements AdwordRankerAlgorithm {
 /**
	 * Calculate the rank of an ad-word using a simple algorithm.
	 */
	@Override
	public Adword rank(Adword adword) {
		adword.setRank(adword.getDollars() / adword.getClickThroughPercentage());
		return adword;
	} 
}
