package com.example.blazblueframedata;

import java.util.ArrayList;

import com.inqbarna.tablefixheaders.TableFixHeaders;
import com.example.blazblueframedata.blazblueinfo.BlazblueFrameInfo;
import com.example.blazblueframedata.blazblueinfo.FGCharacter;

import com.inqbarna.tablefixheaders.adapters.MatrixTableAdapter;

import android.app.Activity;
import android.os.Bundle;

public class SimpleTable extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);
		
		BlazblueFrameInfo info = new BlazblueFrameInfo(this);
		
		// Basic only take the only character there
		FGCharacter character = info.getCharacter(0);
		
		// Generate the 2D array that will be used to display all of the moves.
		String[][] array = new String[character.getAllMoves().size()+1][];
		array[0] = info.cols();
		
		for (int i = 0; i < character.getAllMoves().size(); i++) {
		    ArrayList<String> row = new ArrayList<String>();
		    row.add(character.getAllMoves().get(i).getMoveName());
		    row.addAll(character.getAllMoves().get(i).getPropValues());
		    
		    array[i+1] = row.toArray(new String[row.size()]);
		}
		
		// Display table and what not
		TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
		MatrixTableAdapter<String> matrixTableAdapter = new MatrixTableAdapter<String>(
				this, array);
		tableFixHeaders.setAdapter(matrixTableAdapter);
	}
}
