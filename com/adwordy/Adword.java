package com.adwordy;

/**
 * A place to store ad-word data.
 */
public class Adword {
  final private String word;
  final private float click;
  final private float dollars;
  private double ratio;

  final public int NOT_SET = Integer.MIN_VALUE;

  /**
   * Constructor
   * @param adWord - the ad-word or phrase
   * @param clickThroughPercentage - click through percentage for the word/phrase (historical)
   * @param clickCost - the current highest bid on the word/phrase; it's current estimated cost
  */
  public Adword(String adWord, float clickThroughPercentage, float clickCost) {
		word = adWord;
		click = clickThroughPercentage;
		dollars = clickCost;
		ratio = NOT_SET;
  }

  public String getAdWord() {
    return word;
  }

  /**
   * @return click through percentage (as double to support 'maths')
   */
  public double getClickThroughPercentage() {
    return click;
  }

  public double getDollars() {
    return dollars;
  }

  /**
   * Set the ratio.
   * @param ratio 
   */
  public void setRatio(double ratio) {
    this.ratio = ratio;
  }

  /**
   * @return ratio, or NOT_SET if ratio has never been set. Lower is better, as it is a measure of cost.
   */
  public double getRatio() {
    return ratio;
  }

  public void print() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    return String.format("Word(s): \"%s\"\tratio: %.2f\tcost: $%.2f\tclick through %d%%", word, ratio, dollars, (int)click);
  }
}
