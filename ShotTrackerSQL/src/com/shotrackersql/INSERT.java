package com.shotrackersql;

import java.util.TreeSet;

public class INSERT {

	public static TreeSet<String> create(Weapon weapon) {
		TreeSet<String> output = new TreeSet<String>();

		output.add(insert_Weapon(weapon.getWeapon()));
		output.addAll(insert_Country(weapon.getCountries()));
		output.addAll(insert_Action(weapon.getActions()));
		output.addAll(insert_Caliber(weapon.getCalibers()));
		output.addAll(insert_WeaponAction(weapon.getWeapon(),
				weapon.getActions()));
		output.addAll(insert_WeaponCaliber(weapon.getWeapon(),
				weapon.getCalibers()));
		output.addAll(insert_WeaponCountry(weapon.getWeapon(),
				weapon.getCountries()));

		return output;
	}

	private static TreeSet<String> insert_WeaponAction(String strWeapon,
			String[] actions) {
		TreeSet<String> output = new TreeSet<String>();
		for (String strAction : actions)
			output.add("INSERT INTO WeaponAction (weapon_id, action_id) VALUES (("
					+ "SELECT id FROM Weapon WHERE weapon = '"
					+ strWeapon.replace("'", "''")
					+ "'), "
					+ "(SELECT id FROM Action WHERE action = '"
					+ strAction.replace("'", "''") + "')" + ");");
		return output;
	}

	private static TreeSet<String> insert_WeaponCaliber(String strWeapon,
			String[] calibers) {
		TreeSet<String> output = new TreeSet<String>();
		for (String strCalibers : calibers)
			output.add("INSERT INTO WeaponCaliber (weapon_id, caliber_id) VALUES (("
					+ "SELECT id FROM Weapon WHERE weapon = '"
					+ strWeapon.replace("'", "''")
					+ "'), "
					+ "(SELECT id FROM Caliber WHERE caliber = '"
					+ strCalibers.replace("'", "''") + "')" + ");");
		return output;
	}

	private static TreeSet<String> insert_WeaponCountry(String strWeapon,
			String[] countries) {
		TreeSet<String> output = new TreeSet<String>();
		for (String strCountry : countries)
			output.add("INSERT INTO WeaponCountry (weapon_id, country_id) VALUES (("
					+ "SELECT id FROM Weapon WHERE weapon = '"
					+ strWeapon.replace("'", "''")
					+ "'), "
					+ "(SELECT id FROM Country WHERE country = '"
					+ strCountry.replace("'", "''") + "')" + ");");
		return output;
	}

	private static String insert_Weapon(String strWeapon) {
		return "INSERT INTO Weapon (weapon) VALUES ('" + strWeapon.replace("'", "''") + "');";
	}

	private static TreeSet<String> insert_Country(String[] countries) {
		TreeSet<String> output = new TreeSet<String>();
		for (String strCountry : countries)
			output.add("INSERT INTO Country (country) VALUES ('" + strCountry.replace("'", "''")
					+ "');");
		return output;
	}

	private static TreeSet<String> insert_Action(String[] actions) {
		TreeSet<String> output = new TreeSet<String>();
		for (String strAction : actions)
			output.add("INSERT INTO Action (action) VALUES ('" + strAction.replace("'", "''") + "');");
		return output;
	}

	private static TreeSet<String> insert_Caliber(String[] calibers) {
		TreeSet<String> output = new TreeSet<String>();
		for (String strCaliber : calibers)
			output.add("INSERT INTO Caliber (caliber) VALUES ('" + strCaliber.replace("'", "''")
					+ "');");
		return output;
	}
}
