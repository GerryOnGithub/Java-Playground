package com.adwordy;

/**
 * A simple place to store ad-word data.
 */
public class Adword {
	final private String word;
	final private float click;
	final private float dollars;
	private double rank;

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
		rank = NOT_SET;
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
	 * @param maxDollars
	 * @return if the ad-word is within the indicated budget
	 */
	public boolean cheapEnough(float maxDollars) {
		return dollars <= maxDollars;
	}

	/**
	 * Set the rank.
	 * @param rank 
	 */
	public void setRank(double rank) {
		this.rank = rank;
	}

	/**
	 * @return rank, or NOT_SET if rank has never been set. Lower is better, as it is a measure of cost.
	 */
	public double getRank() {
		return rank;
	}

	public void print() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return String.format("Word(s): \"%s\"\trank: %.2f\tcost: $%.2f\tclick through %d%%", word, rank, dollars, (int)click);
	}
}
