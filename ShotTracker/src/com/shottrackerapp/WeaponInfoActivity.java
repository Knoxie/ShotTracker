package com.shottrackerapp;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.TextView;

import com.knoxhouse.shottracker.R;
import com.shottrackerapp.db.DataAdpater;
import com.shottrackerapp.db.ShotTrackerDB;
import com.shottrackerapp.db.Utility;

public class WeaponInfoActivity extends Activity {

	private int weapon_id;
	private ArrayList<String> calibers;
	private ArrayList<String> actions;
	private ArrayList<String> countries;
	private DataAdpater DBHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weapon_info);

		weapon_id = getIntent().getExtras().getInt(ShotTrackerDB.Weapon.ID);
		loadCaliberInfo();
		loadActionInfo();
		loadCaliberCountry();

		ExpandableListAdapter mAdapter;
		ExpandableListView epView = (ExpandableListView) findViewById(R.id.elvWeaponInfo);
		mAdapter = new MyExpandableListAdapter();
		epView.setAdapter(mAdapter);

		epView.setOnGroupClickListener(new OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView arg0, View arg1, int groupPosition, long arg3) {
				if (groupPosition == 5) {

				}
				return false;
			}
		});

		epView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				if (groupPosition == 0 && childPosition == 0) {

				}
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.weapon_info, menu);
		return true;
	}

	private void loadCaliberInfo() {
		DBHelper = new DataAdpater(this);
		DBHelper.createDatabase();
		DBHelper.open();

		Cursor curWeapons = DBHelper.getWeaponInfo_Caliber(weapon_id);
		calibers = new ArrayList<String>();
		do {
			String caliber = Utility.GetColumnValue(curWeapons, ShotTrackerDB.Caliber.CALIBER);
			calibers.add(caliber);
		} while (curWeapons.moveToNext());

		DBHelper.close();
	}

	private void loadActionInfo() {
		DBHelper = new DataAdpater(this);
		DBHelper.createDatabase();
		DBHelper.open();

		Cursor curWeapons = DBHelper.getWeaponInfo_Action(weapon_id);
		actions = new ArrayList<String>();
		do {
			String action = Utility.GetColumnValue(curWeapons, ShotTrackerDB.Action.ACTION);
			actions.add(action);
		} while (curWeapons.moveToNext());

		DBHelper.close();
	}

	private void loadCaliberCountry() {
		DBHelper = new DataAdpater(this);
		DBHelper.createDatabase();
		DBHelper.open();

		Cursor curWeapons = DBHelper.getWeaponInfo_Country(weapon_id);
		countries = new ArrayList<String>();
		do {
			String country = Utility.GetColumnValue(curWeapons, ShotTrackerDB.Country.COUNTRY);
			countries.add(country);
		} while (curWeapons.moveToNext());

		DBHelper.close();
	}

	public class MyExpandableListAdapter extends BaseExpandableListAdapter {

		private String[] groups = { "Caliber", "Action", "Country of Origin" };
		String[] arrCalibers = Arrays.copyOf(calibers.toArray(), calibers.toArray().length, String[].class);
		String[] arrActions = Arrays.copyOf(actions.toArray(), calibers.toArray().length, String[].class);
		String[] arrCountries = Arrays.copyOf(countries.toArray(), calibers.toArray().length, String[].class);
		private String[][] children = { arrCalibers, arrActions, arrCountries };

		public Object getChild(int groupPosition, int childPosition) {
			return children[groupPosition][childPosition];
		}

		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		public int getChildrenCount(int groupPosition) {
			int i = 0;
			try {
				i = children[groupPosition].length;

			} catch (Exception e) {
			}

			return i;
		}

		public TextView getGenericView() {
			// Layout parameters for the ExpandableListView
			AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);

			TextView textView = new TextView(WeaponInfoActivity.this);
			textView.setLayoutParams(lp);
			// Center the text vertically
			textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			// textView.setTextColor(Color.BLACK);
			// Set the text starting position
			textView.setPadding(72, 0, 0, 0);
			return textView;
		}

		public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
				ViewGroup parent) {
			TextView textView = getGenericView();
			textView.setText(getChild(groupPosition, childPosition).toString());
			return textView;
		}

		public Object getGroup(int groupPosition) {
			return groups[groupPosition];
		}

		public int getGroupCount() {
			return groups.length;
		}

		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
			TextView textView = getGenericView();
			textView.setText(getGroup(groupPosition).toString());
			return textView;
		}

		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}

		public boolean hasStableIds() {
			return true;
		}
	}

}
