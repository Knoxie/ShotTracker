package com.shottrackerapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.knoxhouse.shottracker.R;
import com.shottrackerapp.db.DataAdpater;
import com.shottrackerapp.db.ShotTrackerDB;
import com.shottrackerapp.db.Utility;

public class VaultActivity extends Activity {

	private static final String TAG = "VaultActivity";

	private List<String> weapons;
	private Map<String, Integer> weaponTable;
	private DataAdpater DBHelper;
	private TextView txtSearch;
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vault);

		DBHelper = new DataAdpater(this);
		DBHelper.createDatabase();
		DBHelper.open();

		Cursor curWeapons = DBHelper.getAllWeapons();
		weapons = new ArrayList<String>();
		weaponTable = new HashMap<String, Integer>();
		do {
			String weapon = Utility.GetColumnValue(curWeapons, ShotTrackerDB.Weapon.WEAPON);
			Integer id = Integer.parseInt(Utility.GetColumnValue(curWeapons, ShotTrackerDB.Weapon.ID));
			weapons.add(weapon);
			weaponTable.put(weapon, id);
		} while (curWeapons.moveToNext());

		DBHelper.close();

		// Get a handle to the list view
		lv = (ListView) findViewById(R.id.lvwWeapons);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
				int weapon_id = weaponTable.get(lv.getItemAtPosition(position).toString());
				Log.i(TAG, "weapon_id: " + weapon_id);
				Toast.makeText(getApplicationContext(), String.valueOf(weapon_id), Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(VaultActivity.this, WeaponInfoActivity.class);
				intent.putExtra(ShotTrackerDB.Weapon.ID, weapon_id);
				startActivity(intent);
			}
		});

		// Convert ArrayList to array
		// String[] arrWeapons = Arrays.copyOf(weapons.toArray(),
		// weapons.toArray().length, String[].class);
		List<Weapon> weaponAndType = getData();
		ListAdapter adapter = new WeaponListAdapter(this, weaponAndType, android.R.layout.simple_list_item_2,
				new String[] { Weapon.KEY_WEAPON, Weapon.KEY_TYPE },
				new int[] { android.R.id.text1, android.R.id.text2 });
		lv.setAdapter(adapter);

		txtSearch = ((TextView) findViewById(R.id.txtSearch));

		TextWatcher textChecker = new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String enteredText = txtSearch.getText().toString();
				refreshList(enteredText);
			}

		};

		txtSearch.addTextChangedListener(textChecker);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_vault, menu);
		return true;
	}

	private List<Weapon> getData() {
		List<Weapon> wepaonAndType = new ArrayList<Weapon>();
		for (String strWeapon : weapons)
			wepaonAndType.add(new Weapon(strWeapon, "Rifle"));
		return wepaonAndType;
	}

	public void refreshList(String text) {
		DBHelper.open();
		Cursor curWeapons = DBHelper.getSomeWeapons(text);
		weapons = new ArrayList<String>();
		do {
			String weapon = Utility.GetColumnValue(curWeapons, ShotTrackerDB.Weapon.WEAPON);
			weapons.add(weapon);
		} while (curWeapons.moveToNext());

		// Get a handle to the list view
		ListView lv = (ListView) findViewById(R.id.lvwWeapons);

		// Convert ArrayList to array
		String[] arrWeapons = Arrays.copyOf(weapons.toArray(), weapons.toArray().length, String[].class);
		lv.setAdapter(new ArrayAdapter<String>(VaultActivity.this, android.R.layout.simple_list_item_1, arrWeapons));
		DBHelper.close();
	}
}
