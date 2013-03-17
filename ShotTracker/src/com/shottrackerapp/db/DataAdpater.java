package com.shottrackerapp.db;

import java.io.IOException;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataAdpater {
	protected static final String TAG = "DataAdpater";

	private final Context mContext;
	private SQLiteDatabase mDb;
	private DataBaseHelper mDbHelper;

	public DataAdpater(Context context) {
		this.mContext = context;
		mDbHelper = new DataBaseHelper(mContext);
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
			mDb = mDbHelper.getReadableDatabase();
		} catch (SQLException e) {
			Log.e(TAG, "open >>" + e.toString());
			throw e;
		}
		return this;
	}

	public void close() {
		mDbHelper.close();
	}

	public Cursor getWeapons() {
		try {
			String sql = "SELECT weapon FROM Weapon";

			Cursor mCur = mDb.rawQuery(sql, null);
			if (mCur != null) {
				mCur.moveToNext();
			}
			return mCur;
		} catch (SQLException e) {
			Log.e(TAG, "getTestData >>" + e.toString());
			throw e;
		}
	}

	/*public boolean SaveEmployee(String name, String email) {
		try {
			ContentValues cv = new ContentValues();
			cv.put("Name", name);
			cv.put("Email", email);

			mDb.insert("Employees", null, cv);

			Log.d("SaveEmployee", "informationsaved");
			return true;

		} catch (Exception e) {
			Log.d("SaveEmployee", e.toString());
			return false;
		}
	}*/
}