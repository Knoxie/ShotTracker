package com.shotrackersql;

import java.util.TreeSet;

public class INSERT {

	private static final String Type = "Type";
	private static final String Manufacturer = "Manufacturer";
	private static final String Produced = "Produced";
	private static final String Variant = "Variant";

	private static final String Weight = "Weight";
	private static final String Length = "Length";
	private static final String BarrelLength = "BarrelLength";

	private static final String Caliber = "Caliber";
	private static final String Action = "Action";
	private static final String MuzzleVelocity = "MuzzleVelocity";

	private static final String FeedSystem = "FeedSystem";
	private static final String Sights = "Sights";
	private static final String Country = "Country";

	public static TreeSet<String> create_tables(Weapon weapon) {
		TreeSet<String> output = new TreeSet<String>();

		output.add(insert_Weapon(weapon.getWeapon(), weapon.getInfo(), weapon.getImage()));
		output.addAll(insert_WeaponProperty(Type, weapon.getType()));
		output.addAll(insert_WeaponProperty(Manufacturer, weapon.getManufacturer()));
		output.addAll(insert_WeaponProperty(Produced, weapon.getProduced()));
		output.addAll(insert_WeaponProperty(Variant, weapon.getVariant()));

		output.addAll(insert_WeaponProperty(Weight, weapon.getWeight()));
		output.addAll(insert_WeaponProperty(Length, weapon.getLength()));
		output.addAll(insert_WeaponProperty(BarrelLength, weapon.getBarrelLength()));

		output.addAll(insert_WeaponProperty(Caliber, weapon.getCaliber()));
		output.addAll(insert_WeaponProperty(Action, weapon.getAction()));
		output.addAll(insert_WeaponProperty(MuzzleVelocity, weapon.getMuzzleVelocity()));

		output.addAll(insert_WeaponProperty(FeedSystem, weapon.getFeedSystem()));
		output.addAll(insert_WeaponProperty(Sights, weapon.getSights()));
		output.addAll(insert_WeaponProperty(Country, weapon.getCountry()));

		return output;
	}

	public static TreeSet<String> create_allkeytables(Weapon weapon) {
		TreeSet<String> output = new TreeSet<String>();

		output.addAll(insert_WeaponProperty_AllKey(Type, weapon.getWeapon(), weapon.getType()));
		output.addAll(insert_WeaponProperty_AllKey(Manufacturer, weapon.getWeapon(), weapon.getManufacturer()));
		output.addAll(insert_WeaponProperty_AllKey(Produced, weapon.getWeapon(), weapon.getProduced()));
		output.addAll(insert_WeaponProperty_AllKey(Variant, weapon.getWeapon(), weapon.getVariant()));

		output.addAll(insert_WeaponProperty_AllKey(Weight, weapon.getWeapon(), weapon.getWeight()));
		output.addAll(insert_WeaponProperty_AllKey(Length, weapon.getWeapon(), weapon.getLength()));
		output.addAll(insert_WeaponProperty_AllKey(BarrelLength, weapon.getWeapon(), weapon.getBarrelLength()));

		output.addAll(insert_WeaponProperty_AllKey(Caliber, weapon.getWeapon(), weapon.getCaliber()));
		output.addAll(insert_WeaponProperty_AllKey(Action, weapon.getWeapon(), weapon.getAction()));
		output.addAll(insert_WeaponProperty_AllKey(MuzzleVelocity, weapon.getWeapon(), weapon.getMuzzleVelocity()));

		output.addAll(insert_WeaponProperty_AllKey(FeedSystem, weapon.getWeapon(), weapon.getFeedSystem()));
		output.addAll(insert_WeaponProperty_AllKey(Sights, weapon.getWeapon(), weapon.getSights()));
		output.addAll(insert_WeaponProperty_AllKey(Country, weapon.getWeapon(), weapon.getCountry()));
		
		return output;
	}

	private static TreeSet<String> insert_WeaponProperty_AllKey(String strTableName, String strWeapon,
			String[] properties) {
		TreeSet<String> output = new TreeSet<String>();
		for (String property : properties)
			output.add("INSERT INTO Weapon" + strTableName + " (weapon_id, " + strTableName.toLowerCase()
					+ "_id) VALUES ((" + "SELECT id FROM Weapon WHERE weapon = '" + strWeapon.replace("'", "''")
					+ "'), " + "(SELECT id FROM " + strTableName + " WHERE " + strTableName + " = '"
					+ property.replace("'", "''") + "')" + ");");
		return output;
	}

	private static String insert_Weapon(String strWeapon, String info, String image) {
		return "INSERT INTO Weapon (weapon,info,image) VALUES ('" + strWeapon.replace("'", "''") + "', '"
				+ info.replace("'", "''") + "', '" + image.replace("'", "''") + "');";
	}

	private static TreeSet<String> insert_WeaponProperty(String strTableName, String[] properties) {
		TreeSet<String> output = new TreeSet<String>();
		for (String property : properties)
			output.add("INSERT INTO " + strTableName + " (" + strTableName.toLowerCase() + ") VALUES ('"
					+ property.replace("'", "''") + "');");
		return output;
	}

}
