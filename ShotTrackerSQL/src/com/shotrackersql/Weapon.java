package com.shotrackersql;

public class Weapon {

	private String weapon;
	private String[] countries;
	private String[] calibers;
	private String[] actions;

	public Weapon(String input) {
		String[] tables = input.split(",", -1);
		weapon = tables[0];
		if (tables[1].contains(";"))
			countries = tables[1].split(";");
		else
			countries = new String[] { tables[1] };
		if (tables[2].contains(";"))
			actions = tables[2].split(";");
		else
			actions = new String[] { tables[2] };
		if (tables[3].contains(";"))
			calibers = tables[3].split(";");
		else
			calibers = new String[] { tables[3] };
		
		weapon = weapon.trim();
		for(int i = 0; i < countries.length;i++)
			countries[i] = countries[i].trim();
		
		for(int i = 0; i < actions.length;i++)
			actions[i] = actions[i].trim();
		
		for(int i = 0; i < calibers.length;i++)
			calibers[i] = calibers[i].trim();
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String[] getCountries() {
		return countries;
	}

	public void setCountries(String[] countries) {
		this.countries = countries;
	}

	public String[] getCalibers() {
		return calibers;
	}

	public void setCalibers(String[] calibers) {
		this.calibers = calibers;
	}

	public String[] getActions() {
		return actions;
	}

	public void setActions(String[] actions) {
		this.actions = actions;
	}

}
