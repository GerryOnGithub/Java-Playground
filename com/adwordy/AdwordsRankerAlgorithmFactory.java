package com.adwordy;

/**
 */
public class AdwordsRankerAlgorithmFactory {
  public static AdwordRankerAlgorithm getAlgorithm(String[] _args) {
    return new SimpleAdwordRanker();
  } 
}
