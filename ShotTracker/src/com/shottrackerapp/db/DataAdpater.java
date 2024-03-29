package com.shottrackerapp.db;

import java.io.IOException;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataAdpater {
	protected static final String TAG = "DataAdpater";

	private final Context context;
	private SQLiteDatabase mDB;
	private DataBaseHelper mDbHelper;

	public DataAdpater(Context context) {
		this.context = context;
		mDbHelper = new DataBaseHelper(context);
	}

	public DataAdpater createDatabase() throws SQLException {
		try {
			mDbHelper.createDataBase();
		} catch (IOException mIOException) {
			Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
			throw new Error("UnableToCreateDatabase");
		}
		return this;
	}

	public DataAdpater open() throws SQLException {
		try {
			mDbHelper.openDataBase();
			mDbHelper.close();
			mDB = mDbHelper.getReadableDatabase();
		} catch (SQLException e) {
			Log.e(TAG, "open >>" + e.toString());
			throw e;
		}
		return this;
	}

	public void close() {
		mDbHelper.close();
	}

	public Cursor getAllWeapons() {
		try {

			// String sql = "SELECT weapon FROM Weapon";
			String sql = ShotTrackerDB.execute_AllWeapons(context);

			Cursor mCur = mDB.rawQuery(sql, null);
			if (mCur != null) {
				mCur.moveToNext();
			}
			return mCur;
		} catch (SQLException e) {
			Log.e(TAG, "getAllWeapons >>" + e.toString());
			throw e;
		}
	}

	public Cursor getSomeWeapons(String strWeapon) {
		try {

			// String sql = "SELECT weapon FROM Weapon";
			String sql = ShotTrackerDB.execute_SomeWeapons(context, strWeapon);

			Cursor mCur = mDB.rawQuery(sql, null);
			if (mCur != null) {
				mCur.moveToNext();
			}
			return mCur;
		} catch (SQLException e) {
			Log.e(TAG, "getSomeWeapons >>" + e.toString());
			throw e;
		}
	}

	public Cursor getWeaponInfo_Caliber(int weapon_id) {
		try {

			// String sql = "SELECT weapon FROM Weapon";
			String sql = ShotTrackerDB.execute_WeaponInfo_Caliber(context, weapon_id);

			Cursor mCur = mDB.rawQuery(sql, null);
			if (mCur != null) {
				mCur.moveToNext();
			}
			return mCur;
		} catch (SQLException e) {
			Log.e(TAG, "getWeaponInfo_Caliber >>" + e.toString());
			throw e;
		}
	}
	
	public Cursor getWeaponInfo_Action(int weapon_id) {
		try {

			// String sql = "SELECT weapon FROM Weapon";
			String sql = ShotTrackerDB.execute_WeaponInfo_Action(context, weapon_id);

			Cursor mCur = mDB.rawQuery(sql, null);
			if (mCur != null) {
				mCur.moveToNext();
			}
			return mCur;
		} catch (SQLException e) {
			Log.e(TAG, "getWeaponInfo_Action >>" + e.toString());
			throw e;
		}
	}
	
	public Cursor getWeaponInfo_Country(int weapon_id) {
		try {

			// String sql = "SELECT weapon FROM Weapon";
			String sql = ShotTrackerDB.execute_WeaponInfo_Country(context, weapon_id);

			Cursor mCur = mDB.rawQuery(sql, null);
			if (mCur != null) {
				mCur.moveToNext();
			}
			return mCur;
		} catch (SQLException e) {
			Log.e(TAG, "getWeaponInfo_Country >>" + e.toString());
			throw e;
		}
	}

	/*
	 * public boolean SaveEmployee(String name, String email) { try {
	 * ContentValues cv = new ContentValues(); cv.put("Name", name);
	 * cv.put("Email", email);
	 * 
	 * mDb.insert("Employees", null, cv);
	 * 
	 * Log.d("SaveEmployee", "informationsaved"); return true;
	 * 
	 * } catch (Exception e) { Log.d("SaveEmployee", e.toString()); return
	 * false; } }
	 */
}
