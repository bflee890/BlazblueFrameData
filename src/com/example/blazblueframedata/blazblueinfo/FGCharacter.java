package com.example.blazblueframedata.blazblueinfo;

import java.util.ArrayList;

/**
 * Represents a FGCharacter. Has moves where each moves have many different
 * properties
 * 
 * @author Brandon Lee
 * 
 */
public class FGCharacter {

	private String name;
	private ArrayList<Move> moves;

	/**
	 * Creates fighting character with moves
	 * 
	 * @param name
	 *            The name represents the character's name
	 */
	public FGCharacter(String name) {
		this.name = name;
		moves = new ArrayList<Move>();
	}

	/**
	 * Adds a move to the character's moveset
	 * 
	 * @param move
	 */
	public void addMove(Move move) {
		moves.add(move);
	}

	/**
	 * Returns an ArrayList of all of the move names that the FGCharacter has
	 * 
	 * @return
	 */
	public ArrayList<String> getMoveNames() {
		ArrayList<String> moveNames = new ArrayList<String>();
		for (Move move : moves) {
			moveNames.add(move.getMoveName());
		}

		return moveNames;
	}

	/**
	 * Returns the name of the FGCharacter
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns an ArrayList of all of the moves that the FGCharacter has
	 * 
	 * @return
	 */
	public ArrayList<Move> getAllMoves() {
		return moves;
	}

}
