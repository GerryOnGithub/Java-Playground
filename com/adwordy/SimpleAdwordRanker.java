package com.adwordy;

public class SimpleAdwordRanker implements AdwordRankerAlgorithm {
 /**
   * Calculate the ratio of an ad-word using a simple algorithm.
   */
  @Override
  public void calcRatio(Adword adword) {
    adword.setRatio(adword.getDollars() / adword.getClickThroughPercentage());
  } 
}
