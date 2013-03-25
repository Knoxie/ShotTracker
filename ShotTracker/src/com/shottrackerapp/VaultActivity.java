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
import com.shottrackerapp.db.Table;
import com.shottrackerapp.db.Utility;
import com.shottrackerapp.obj.Weapon;
import com.shottrackerapp.obj.WeaponMap;

public class VaultActivity extends Activity {

	private static final String TAG = "VaultActivity";

	private List<Weapon> weapons;
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
		weapons = new ArrayList<Weapon>();
		//weaponTable = new HashMap<String, Integer>();
		do {
			String weapon = Utility.GetColumnValue(curWeapons, Table.Weapon.WEAPON);
			Integer id = Integer.parseInt(Utility.GetColumnValue(curWeapons, Table.Weapon.ID));
			String image = Utility.GetColumnValue(curWeapons, Table.Weapon.IMAGE);
			String info = Utility.GetColumnValue(curWeapons, Table.Weapon.INFO);
			String type = Utility.GetColumnValue(curWeapons, Table.Weapon.TYPE);

			weapons.add(new Weapon(weapon, info, image, type, id));
			//weaponTable.put(weapon, id);
		} while (curWeapons.moveToNext());

		DBHelper.close();

		// Get a handle to the list view
		lv = (ListView) findViewById(R.id.lvwWeapons);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
				int weapon_id = 1;//weaponTable.get(lv.getItemAtPosition(position).toString());
				Log.i(TAG, lv.getItemAtPosition(position).toString());
				Log.i(TAG, "weapon_id: " + weapon_id);
				Toast.makeText(getApplicationContext(), String.valueOf(weapon_id), Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(VaultActivity.this, WeaponInfoActivity.class);
				intent.putExtra(Table.Weapon.ID, weapon_id);
				startActivity(intent);
			}
		});

		// Convert ArrayList to array
		// String[] arrWeapons = Arrays.copyOf(weapons.toArray(),
		// weapons.toArray().length, String[].class);
		List<WeaponMap> weaponAndType = getData();
		ListAdapter adapter = new WeaponListAdapter(this, weaponAndType, android.R.layout.simple_list_item_2,
				new String[] { WeaponMap.KEY_WEAPON, WeaponMap.KEY_TYPE }, new int[] { android.R.id.text1,
						android.R.id.text2 });
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

	private List<WeaponMap> getData() {
		List<WeaponMap> wepaonAndType = new ArrayList<WeaponMap>();
		for (Weapon weapon : weapons)
			wepaonAndType.add(new WeaponMap(weapon.getWeapon(), weapon.getType()));
		return wepaonAndType;
	}

	public void refreshList(String text) {
		DBHelper.open();
		Cursor curWeapons = DBHelper.getSomeWeapons(text);
		weapons = new ArrayList<Weapon>();
		do {
			String weapon = Utility.GetColumnValue(curWeapons, Table.Weapon.WEAPON);
			Integer id = Integer.parseInt(Utility.GetColumnValue(curWeapons, Table.Weapon.ID));
			String image = Utility.GetColumnValue(curWeapons, Table.Weapon.IMAGE);
			String info = Utility.GetColumnValue(curWeapons, Table.Weapon.INFO);
			String type = Utility.GetColumnValue(curWeapons, Table.Weapon.TYPE);

			weapons.add(new Weapon(weapon, info, image, type, id));
		} while (curWeapons.moveToNext());

		// Get a handle to the list view
		ListView lv = (ListView) findViewById(R.id.lvwWeapons);

		// Convert ArrayList to array
		String[] arrWeapons = Arrays.copyOf(weapons.toArray(), weapons.toArray().length, String[].class);
		lv.setAdapter(new ArrayAdapter<String>(VaultActivity.this, android.R.layout.simple_list_item_1, arrWeapons));
		DBHelper.close();
	}
}
