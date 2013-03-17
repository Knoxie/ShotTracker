package com.shottrackerapp.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.util.Log;

public class ShotTrackerDB {

	public static final String TAG = "ShotTrackerDB";
	private static final String ALL_WEAPONS_SQL = "SQL/AllWeapons.sql";
	private static final String WEAPON_INFO = "SQL/WEAPON_INFO.sql";

	public static String execute_AllWeapons(Context context) {
		Log.d(TAG, "execute_AllWeapons()");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(ALL_WEAPONS_SQL)));
			String strOutput = reader.readLine();
			Log.i(TAG, "strOutput: " + strOutput);
			return strOutput;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static String execute_WeaponInfo(Context context) {
		Log.d(TAG, "execute_WeaponInfo()");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(WEAPON_INFO)));
			String strOutput = reader.readLine();
			Log.i(TAG, "strOutput: " + strOutput);
			return strOutput;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public class Weapon {
		public static final String ID = "id";
		public static final String WEAPON = "weapon";
	}

}
