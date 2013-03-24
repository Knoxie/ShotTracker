package com.shottrackerapp.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.util.Log;

public class ShotTrackerDB {

	private static final String TAG = "ShotTrackerDB";

	public static String execute_AllWeapons(Context context) {
		Log.d(TAG, "execute_AllWeapons()");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(SQL.ALL_WEAPONS)));
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
			BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(SQL.WEAPON_INFO)));
			String strOutput = reader.readLine();
			Log.i(TAG, "strOutput: " + strOutput);
			return strOutput;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String execute_SomeWeapons(Context context, String strWeapon) {
		Log.d(TAG, "execute_WeaponInfo()");
		String strOutput = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(SQL.SOME_WEAPONS)));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.equals(""))
					strOutput += strWeapon;
				else
					strOutput += line;
			}
			Log.i(TAG, "strOutput: " + strOutput);
			return strOutput;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String execute_WeaponInfo_Caliber(Context context, int weapon_id) {
		Log.d(TAG, "execute_WeaponInfo_Caliber()");
		String strOutput = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(
					SQL.WEAPON_INFO_CALIBER)));
			String line;
			while ((line = reader.readLine()) != null)
				strOutput += line;
			strOutput += weapon_id;
			Log.i(TAG, "strOutput: " + strOutput);
			return strOutput;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String execute_WeaponInfo_Action(Context context, int weapon_id) {
		Log.d(TAG, "execute_WeaponInfo_Action()");
		String strOutput = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(
					SQL.WEAPON_INFO_ACTION)));
			String line;
			while ((line = reader.readLine()) != null)
				strOutput += line;
			strOutput += weapon_id;
			Log.i(TAG, "strOutput: " + strOutput);
			return strOutput;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String execute_WeaponInfo_Country(Context context, int weapon_id) {
		Log.d(TAG, "execute_WeaponInfo_Country()");
		String strOutput = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(
					SQL.WEAPON_INFO_COUNTRY)));
			String line;
			while ((line = reader.readLine()) != null)
				strOutput += line;
			strOutput += weapon_id;
			Log.i(TAG, "strOutput: " + strOutput);
			return strOutput;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
