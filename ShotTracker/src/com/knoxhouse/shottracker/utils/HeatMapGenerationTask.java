/**
 * HeatMapGenerator.java
 */
package com.knoxhouse.shottracker.utils;

import java.io.File;
import java.io.IOException;
import org.tc33.jheatchart.HeatChart;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Heat map generation Asynchronous Task
 * 
 * @author Greg Knox
 * 
 */
public class HeatMapGenerationTask extends AsyncTask<Object, Object, Object> {

	// Create some dummy data.
	double[][] data = new double[][] { { 3, 2, 3, 4, 5, 6 }, // Data line 1
			{ 2, 3, 4, 5, 6, 7 }, // Data line 2
			{ 3, 4, 5, 6, 7, 6 }, // Data line 3
			{ 4, 5, 6, 7, 6, 5 } };// Data line 4

	/**
	 * Construct a HeaMapGeneration thread
	 * 
	 * @param params
	 *            Array of data [String Title, String XAxis, String YAxis]
	 */
	protected String doInBackground(Object... params) {
		String filename = "heatmap_" + System.currentTimeMillis();

		// Create our heat map chart using our data.
		HeatChart map = new HeatChart(data);

		// Customize the chart.
		map.setTitle(params[0].toString());
		map.setXAxisLabel(params[1].toString());
		map.setYAxisLabel(params[2].toString());

		// Output the chart to a file.
		try {
			map.saveToFile(new File(ShotTracker_Constants.getHeatMapImageDir()
					+ filename));
		} catch (IOException e) {
			Log.e("HeatMapGenerationTask", e.getMessage());
		}

		return filename;

	}
}
