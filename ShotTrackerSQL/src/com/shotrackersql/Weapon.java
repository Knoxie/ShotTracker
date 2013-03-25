package com.shotrackersql;

public class Weapon {

	private String weapon;
	private String info;
	private String image;
	private String type;
	private String[] manufacturer;
	private String[] produced;
	private String[] variant;

	private String[] weight;
	private String[] length;
	private String[] barrelLength;

	private String[] caliber;
	private String[] action;
	private String[] muzzleVelocity;

	private String[] feedSystem;
	private String[] sights;
	private String[] country;

	private String tableSplit = "&&";
	private String valueSplit = "!!";

	public Weapon(String input) {
		String[] tables = input.split(tableSplit, -1);
		weapon = tables[Columns.weapon.ordinal()];
		info = tables[Columns.info.ordinal()];
		image = tables[Columns.image.ordinal()];
		type = tables[Columns.type.ordinal()];

		if (tables[Columns.manufacturer.ordinal()].contains(valueSplit))
			manufacturer = tables[Columns.manufacturer.ordinal()].split(valueSplit);
		else
			manufacturer = new String[] { tables[Columns.manufacturer.ordinal()] };

		if (tables[Columns.produced.ordinal()].contains(valueSplit))
			produced = tables[Columns.produced.ordinal()].split(valueSplit);
		else
			produced = new String[] { tables[Columns.produced.ordinal()] };

		if (tables[Columns.variant.ordinal()].contains(valueSplit))
			variant = tables[Columns.variant.ordinal()].split(valueSplit);
		else
			variant = new String[] { tables[Columns.variant.ordinal()] };

		if (tables[Columns.weight.ordinal()].contains(valueSplit))
			weight = tables[Columns.weight.ordinal()].split(valueSplit);
		else
			weight = new String[] { tables[Columns.weight.ordinal()] };

		if (tables[Columns.length.ordinal()].contains(valueSplit))
			length = tables[Columns.length.ordinal()].split(valueSplit);
		else
			length = new String[] { tables[Columns.length.ordinal()] };

		if (tables[Columns.barrelLength.ordinal()].contains(valueSplit))
			barrelLength = tables[Columns.barrelLength.ordinal()].split(valueSplit);
		else
			barrelLength = new String[] { tables[Columns.barrelLength.ordinal()] };

		if (tables[Columns.caliber.ordinal()].contains(valueSplit))
			caliber = tables[Columns.caliber.ordinal()].split(valueSplit);
		else
			caliber = new String[] { tables[Columns.caliber.ordinal()] };

		if (tables[Columns.action.ordinal()].contains(valueSplit))
			action = tables[Columns.action.ordinal()].split(valueSplit);
		else
			action = new String[] { tables[Columns.action.ordinal()] };

		if (tables[Columns.muzzleVelocity.ordinal()].contains(valueSplit))
			muzzleVelocity = tables[Columns.muzzleVelocity.ordinal()].split(valueSplit);
		else
			muzzleVelocity = new String[] { tables[Columns.muzzleVelocity.ordinal()] };

		if (tables[Columns.feedSystem.ordinal()].contains(valueSplit))
			feedSystem = tables[Columns.feedSystem.ordinal()].split(valueSplit);
		else
			feedSystem = new String[] { tables[Columns.feedSystem.ordinal()] };

		if (tables[Columns.sights.ordinal()].contains(valueSplit))
			sights = tables[Columns.sights.ordinal()].split(valueSplit);
		else
			sights = new String[] { tables[Columns.sights.ordinal()] };

		if (tables[Columns.country.ordinal()].contains(valueSplit))
			country = tables[Columns.country.ordinal()].split(valueSplit);
		else
			country = new String[] { tables[Columns.country.ordinal()] };

		weapon = weapon.trim();
		info = info.trim();
		image = image.trim();
		type = type.trim();

		for (int i = 0; i < manufacturer.length; i++)
			manufacturer[i] = manufacturer[i].trim();
		for (int i = 0; i < produced.length; i++)
			produced[i] = produced[i].trim();
		for (int i = 0; i < variant.length; i++)
			variant[i] = variant[i].trim();

		for (int i = 0; i < weight.length; i++)
			weight[i] = weight[i].trim();
		for (int i = 0; i < length.length; i++)
			length[i] = length[i].trim();
		for (int i = 0; i < barrelLength.length; i++)
			barrelLength[i] = barrelLength[i].trim();

		for (int i = 0; i < caliber.length; i++)
			caliber[i] = caliber[i].trim();
		for (int i = 0; i < action.length; i++)
			action[i] = action[i].trim();
		for (int i = 0; i < muzzleVelocity.length; i++)
			muzzleVelocity[i] = muzzleVelocity[i].trim();

		for (int i = 0; i < feedSystem.length; i++)
			feedSystem[i] = feedSystem[i].trim();
		for (int i = 0; i < sights.length; i++)
			sights[i] = sights[i].trim();
		for (int i = 0; i < country.length; i++)
			country[i] = country[i].trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String[] getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String[] manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String[] getProduced() {
		return produced;
	}

	public void setProduced(String[] produced) {
		this.produced = produced;
	}

	public String[] getVariant() {
		return variant;
	}

	public void setVariant(String[] variant) {
		this.variant = variant;
	}

	public String[] getWeight() {
		return weight;
	}

	public void setWeight(String[] weight) {
		this.weight = weight;
	}

	public String[] getLength() {
		return length;
	}

	public void setLength(String[] length) {
		this.length = length;
	}

	public String[] getBarrelLength() {
		return barrelLength;
	}

	public void setBarrelLength(String[] barrelLength) {
		this.barrelLength = barrelLength;
	}

	public String[] getCaliber() {
		return caliber;
	}

	public void setCaliber(String[] caliber) {
		this.caliber = caliber;
	}

	public String[] getAction() {
		return action;
	}

	public void setAction(String[] action) {
		this.action = action;
	}

	public String[] getMuzzleVelocity() {
		return muzzleVelocity;
	}

	public void setMuzzleVelocity(String[] muzzleVelocity) {
		this.muzzleVelocity = muzzleVelocity;
	}

	public String[] getFeedSystem() {
		return feedSystem;
	}

	public void setFeedSystem(String[] feedSystem) {
		this.feedSystem = feedSystem;
	}

	public String[] getSights() {
		return sights;
	}

	public void setSights(String[] sights) {
		this.sights = sights;
	}

	public String[] getCountry() {
		return country;
	}

	public void setCountry(String[] country) {
		this.country = country;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
