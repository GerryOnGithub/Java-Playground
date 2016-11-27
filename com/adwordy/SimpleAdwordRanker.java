package com.adwordy;

public class SimpleAdwordRanker implements AdwordRankerAlgorithm {
 /**
   * Calculate the rank of an ad-word using a simple algorithm.
   */
  @Override
  public void rank(Adword adword) {
    adword.setRank(adword.getDollars() / adword.getClickThroughPercentage());
  } 
}
