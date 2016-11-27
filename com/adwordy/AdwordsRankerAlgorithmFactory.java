package com.adwordy;

/**
 * There is only one algorithm at this time.
 */
public class AdwordsRankerAlgorithmFactory {
  public static AdwordRankerAlgorithm getAlgorithm(String[] _args) {
    return new SimpleAdwordRanker();
  } 
}
