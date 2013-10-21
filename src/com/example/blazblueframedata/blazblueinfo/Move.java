package com.example.blazblueframedata.blazblueinfo;

import java.util.ArrayList;

/**
 * Represents a move that a FGCharacter has. Each move has many different
 * properties
 * 
 * @author Brandon Lee
 * 
 */
public class Move {
	private String moveName;
	private ArrayList<Property> properties;

	/**
	 * Creates the move. Gives it a moveName
	 * 
	 * @param moveName
	 */
	public Move(String moveName) {
		this.moveName = moveName;
		properties = new ArrayList<Property>();
	}

	/**
	 * Retunrs the moveName of the said move
	 * 
	 * @return
	 */
	public String getMoveName() {
		return moveName;
	}

	/**
	 * Adds a property to the move whatever it may be
	 * 
	 * @param prop
	 */
	public void addProp(Property prop) {
		properties.add(prop);
	}

	/**
	 * Returns all of the different properties that the move has in a ArrayList
	 * 
	 * @return
	 */
	public ArrayList<Property> getMoveProp() {
		return properties;
	}

	/**
	 * Returns all of the property values of the move
	 * 
	 * @return
	 */
	public ArrayList<String> getPropValues() {
		ArrayList<String> values = new ArrayList<String>();
		for (Property props : properties) {
			values.add(props.getPropValue());
		}

		return values;
	}
}
