package com.shottrackerapp;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class WeaponListAdapter extends SimpleAdapter {

	private List<Weapon> weapons;
	/*
	* Alternating color list -- you could initialize this from anywhere.
	* Note that the colors make use of the alpha here, otherwise they would be
	* opaque and wouldn't give good results!
	*/
	private int[] colors = new int[] { 0xFFFFFFFF, 0xFFC0C0C0 };

	@SuppressWarnings("unchecked")
	public WeaponListAdapter(Context context, 
	        List<? extends Map<String, String>> weapons, 
	        int resource, 
	        String[] from, 
	        int[] to) {
	  super(context, weapons, resource, from, to);
	  this.weapons = (List<Weapon>) weapons;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	  View view = super.getView(position, convertView, parent);

	  int colorPos = position % colors.length;
	  view.setBackgroundColor(colors[colorPos]);
	  return view;
	}
	

}
