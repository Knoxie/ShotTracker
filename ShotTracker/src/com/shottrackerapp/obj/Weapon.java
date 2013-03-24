package com.shottrackerapp.obj;

import java.util.HashMap;

public class Weapon extends HashMap<String, String> {
	private static final long serialVersionUID = 12872473L;
	public String weapon;
	public String type;

	public static String KEY_WEAPON = "weapon";
	public static String KEY_TYPE = "type";

	public Weapon(String weapon, String type) {
		this.weapon = weapon;
		this.type = type;
	}

	@Override
	public String get(Object k) {
		String key = (String) k;
		if (KEY_WEAPON.equals(key))
			return weapon;
		else if (KEY_TYPE.equals(key))
			return type;
		return null;
	}
}
