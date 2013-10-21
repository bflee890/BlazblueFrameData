package com.example.blazblueframedata;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;  
import android.widget.Button;

public class MainActivity extends Activity {


	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Get reference of the button
		Button btnShowCharacters = (Button) findViewById(R.id.buttonShowCharacters);
		
		btnShowCharacters.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// Create intent for SimpleTable Activity and Start the Activity
				Intent intentCharacterList = new Intent(getApplicationContext(), SimpleTable.class);
				startActivity(intentCharacterList);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
