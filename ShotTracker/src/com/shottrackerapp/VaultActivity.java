package com.shottrackerapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.knoxhouse.shottracker.R;
import com.shottrackerapp.db.DataAdpater;
import com.shottrackerapp.db.ShotTrackerDB;
import com.shottrackerapp.db.Utility;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VaultActivity extends Activity {

	private List<String> weapons;
	private Map<String, Integer> weaponTable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vault);

		DataAdpater mDbHelper = new DataAdpater(this);
		mDbHelper.createDatabase();
		mDbHelper.open();

		Cursor curWeapons = mDbHelper.getWeapons();
		weapons = new ArrayList<String>();
		weaponTable = new HashMap<String, Integer>();
		do {
			String weapon = Utility.GetColumnValue(curWeapons, ShotTrackerDB.Weapon.WEAPON);
			Integer id = Integer.parseInt(Utility.GetColumnValue(curWeapons, ShotTrackerDB.Weapon.ID));
			weapons.add(weapon);
			weaponTable.put(weapon, id);
		} while (curWeapons.moveToNext());

		mDbHelper.close();

		// Get a handle to the list view
		ListView lv = (ListView) findViewById(R.id.lvwWeapons);

		// Convert ArrayList to array
		String[] arrWeapons = Arrays.copyOf(weapons.toArray(), weapons.toArray().length, String[].class);
		lv.setAdapter(new ArrayAdapter<String>(VaultActivity.this, android.R.layout.simple_list_item_1, arrWeapons));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_vault, menu);
		return true;
	}

}
