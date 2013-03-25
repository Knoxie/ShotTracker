package com.shottrackerapp.obj;

public class Weapon {

	private String weapon, info, image, type;
	private int id;

	public Weapon(String weapon, String info, String image, String type, int id) {
		super();
		this.weapon = weapon;
		this.info = info;
		this.image = image;
		this.type = type;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
