package com.shottrackerapp;

import com.knoxhouse.shottracker.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GunViewerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gun_viewer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_gun_viewer, menu);
		return true;
	}

}
