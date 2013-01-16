/**
 * 
 */
package com.knoxhouse.shottracker.utils;

import android.os.Environment;

/**
 * Constants for ShotTracker
 * 
 * @author Greg Knox
 */
public class ShotTracker_Constants {

	private static String main_dir = Environment.getExternalStorageDirectory()
			.toString() + "/ShotTracker";
	private static String heatMap_dir = "heatMapDir";

	public static String getMain_directory() {
		return main_dir;
	}

	public static String getHeatMapImageDir() {
		return getMain_directory() + "/" + heatMap_dir;
	}
}
