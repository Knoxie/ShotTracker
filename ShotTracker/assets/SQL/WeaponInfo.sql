SELECT weapon, caliber, country, action FROM Weapon JOIN WeaponCaliber ON WeaponCaliber.weapon_id = Weapon.id JOIN Caliber ON Caliber.id = WeaponCaliber.caliber_id JOIN WeaponCountry ON WeaponCountry.weapon_id = Weapon.id JOIN Country ON Country.id = WeaponCountry.country_id JOIN WeaponAction ON WeaponAction.weapon_id = Weapon.id JOIN Action ON Action.id = WeaponAction.action_id WHERE Weapon.id = 