package com.example.blazblueframedata.blazblueinfo;

/**
 * Represents a property of a move
 * 
 * @author Brandon Lee
 * 
 */
public class Property {
	private String prop;
	private String value;

	/**
	 * Gives a name to represent the property and the value that the said
	 * character has for that property
	 * 
	 * @param prop
	 * @param value
	 */
	public Property(String prop, String value) {
		this.prop = prop;
		this.value = value;
	}

	/**
	 * Gets the property's name 
	 * @return
	 */
	public String getProp() {
		return prop;
	}

	/**
	 * Returns the value of the said property
	 * @return
	 */
	public String getPropValue() {
		return value;
	}
}
