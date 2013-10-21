package com.example.blazblueframedata.blazblueinfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.content.res.AssetManager;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;

public class BlazblueFrameInfo {
	
	// 20 things
	private final String columns[] = {
		"Move/Version",
		"Damage",
		"Cancel",
		"P1",
		"P2",
		"Starter",
		"SMP",
		"Guard",
		"Level",
		"Attribute",
		"Startup",
		"Active",
		"Recovery",
		"Frame Adv",
		"Blockstun",
		"Ground Hit",
		"Ground CH",
		"Air Hit",
		"Air CH",
		"Invlu"
	};
	
	private ArrayList<FGCharacter> characters;
	
	/* RIGHT NOW INITALIZES AND READS EVERYTHING AT ONCE NEED TO REFACTOR THIS */
	public BlazblueFrameInfo (Context c) {
		File file = new File("Blazblue Frame Data.json");
		characters = new ArrayList<FGCharacter>();
	
		try {
			JsonFactory jfactory = new JsonFactory();
			 
			/*** read from file ***/
			AssetManager am = c.getAssets();
			JsonParser jp = jfactory.createJsonParser(am.open("blazblueframedata.json"));
		 
			jp.nextToken();		// Passes null
			jp.nextToken();		// Passes {
			// loop until token equal to "}"
			while (jp.nextToken() != JsonToken.END_OBJECT) {
				String fieldName = jp.getCurrentName();
				
				jp.nextToken(); // Move to value to start array
				// For every Character, create a new FGCharacter
				if (fieldName.equals("Character")) {
					jp.nextToken();
					String name = jp.getCurrentName();
					FGCharacter character = new FGCharacter(name);
					
					jp.nextToken();
					// Add moves to said FGCharacter
					while(jp.nextToken() != JsonToken.END_OBJECT) {
						String moveName = jp.getCurrentName();
						Move move = new Move(moveName);
						
						while(jp.nextToken() != JsonToken.END_OBJECT) {
							String prop = jp.getCurrentName();
							String propValue = jp.getText();
							if (!prop.equals(propValue)) {
								Property property = new Property(prop, propValue);
								move.addProp(property);
							}
						}
						jp.nextToken();
						character.addMove(move);
					}
					// Add character to master characters list
					characters.add(character);
				}
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not find" + file.toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	/**
	 * Returns the FGCharacter from the characters list based on the index given
	 * @param 
	 *		i
	 *			Index for the character to pull
	 * @return
	 * 		Returns the FGCharacter corresponding to the index
	 */
	public FGCharacter getCharacter(int i) {
		return characters.get(i);
	}
	
	public String[] cols() {
		return columns;
	}
}
