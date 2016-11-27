package com.adwordy;

/**
 * Only one option for now, but in future the data could come from other sources.
 */
public class AdwordsAccessorFactory {
	/**
	 * Finds the best class to use to get the ad-words data.
	 * @param _args (not currently used)
	 * @return 
	 */
	public static AdwordAccessor getAccessor(String[] _args) {
		return new AdwordAPIAccessor();
	}  
}
