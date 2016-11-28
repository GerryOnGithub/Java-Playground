package com.adwordy;

import java.util.Comparator;
import java.util.function.Predicate;

public interface AdwordRankerAlgorithm {
  /**
   * Apply an algorithm to judge an ad-words effectiveness and update the input ad-word object.
   * @param adword
   */
  void calcRatio(Adword adword);

  default Predicate<Adword> costFilter(float maxDollars) {
    return (Adword data) -> data.getDollars() <= maxDollars;
  }

  default Comparator<Adword> sorter(){
      return (a, b) -> { return Double.compare(a.getRatio(), b.getRatio()); };
  }
}
