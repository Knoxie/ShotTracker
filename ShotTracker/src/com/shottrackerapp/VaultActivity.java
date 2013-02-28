package com.shottrackerapp;

import com.knoxhouse.shottracker.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class VaultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vault);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_vault, menu);
		return true;
	}

}
